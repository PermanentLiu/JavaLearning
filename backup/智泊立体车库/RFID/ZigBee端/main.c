
#include <iocc2530.h>
#include "hal_mcu.h"
#include "hal_assert.h"
#include "hal_board.h"
#include "dht11.h"
#include "hal_rf.h"
#include "basic_rf.h"
#include <stdio.h>


#define RF_CHANNEL            11      // 2.4 GHz RF channel

#define PAN_ID                0x2007
#define SEND_ADDR             0x2530
#define RECV_ADDR             0x2520

#define NODE_TYPE            1         //0:副节点，！0：主节点
extern DHT11 dht1;
extern void dht11_update(void);
extern void Photoresistance_Test(void);
extern void Infrared_Test(void);
extern void Infrared_Init(void);
void io_init(void)
{
  P0SEL &= ~0x02;
  P0DIR &= ~0x02;
}
char recvBuf[256];
int recvCnt; 
static basicRfCfg_t basicRfConfig;
unsigned char data[10][6];
unsigned char datat[3][6];
void initdata()//发送数组初始化32
{
  int i;
  for(i=0;i<10;i++)
  {
    data[i][3]=0x0d;
    data[i][4]=0x0a;
    datat[i][3]=0x0d;
    datat[i][4]=0x0a;
  }
}

void led()//智能化控制
{
  if(!data[2][1])
  {
    if(dht1.Sensor_Hig) D6=0;
    else D6=1;
  }
  else if(data[2][2]) D6=0;
  else D6=1;
}

void air()
{
  if(dht1.Sensor_Hig>85) 
  {
    D6=1;D7=0;
  }
  else {D6=0;D7=1;}
}

void shine()
{
  if(!data[1][1])
  {
    if(dht1.Sensor_Hig>100) D6=0;
    else D6=1;
  }
  else if(data[1][2]) D6=0;
  else D6=1;
}

void rfChannelScan(void)
{
   int rlen;
    uint8 pTxData[] = {0,0,0};
    uint8 pRxData[64];
    int i;
    uint8 channel;    

    basicRfReceiveOn();    
    while(1)
    {
       D7=!D7;
        halRfSetChannel(11);
        if(recvCnt>0)
        {   halMcuWaitMs(50);
     
          basicRfSendPacket(RECV_ADDR, recvBuf, recvCnt); //发送数据的函数   
          printf("hh");
          for (i=0; i<1000; i++) {
            if (basicRfPacketIsReady())//等待节点回应
            {
  //            basicRfReceive(pRxData, 32, NULL);
              rlen = basicRfReceive(pRxData, sizeof pRxData, NULL);
              if(rlen > 0) 
              {

                for(i=0;i<rlen;i++)
                  Uart_Send_char(pRxData[i]);  //节点数据发送给单片机  
                recvCnt=0;
              }
                break;
            }
            halMcuWaitMs(2);
          }
        }
        halMcuWaitMs(200);

    }
}

void rfRecvData(void)
{
  uint8 pTxData[] ={RF_CHANNEL-11,0,0};
  uint8 pRxData[128];
  int rlen;
  int i; 
   basicRfReceiveOn();

    // Main loop
    while (TRUE) {
      D7=!D7;
        rlen = basicRfReceive(pRxData, sizeof pRxData, NULL);
        if(rlen > 0) {
              for(i=0;i<rlen;i++)
                Uart_Send_char(pRxData[i]);  //节点数据发送给单片机  
              for (i=0; i<1000; i++) {
                if(recvCnt>0)
                {
                 halMcuWaitMs(50);
                  basicRfSendPacket(basicRfReceiveAddress(), recvBuf, recvCnt);
                }
              }
          }
        halMcuWaitMs(20);
    }
}

void main(void)
{
    led_init();
    halMcuInit();
    initdata();
    io_init();
    hal_led_init();
    Infrared_Init();   
    hal_uart_init();
    dht11_io_init();
    if (FAILED == halRfInit()) {
        HAL_ASSERT(FALSE);
    }

    // Config basicRF
    basicRfConfig.panId = PAN_ID;
    basicRfConfig.channel = RF_CHANNEL;
    basicRfConfig.ackRequest = TRUE;
#ifdef SECURITY_CCM
    basicRfConfig.securityKey = key;
#endif

    
    // Initialize BasicRF
#if NODE_TYPE
    basicRfConfig.myAddr = SEND_ADDR;
#else
    basicRfConfig.myAddr = RECV_ADDR; 
#endif
    
    if(basicRfInit(&basicRfConfig)==FAILED) {
      HAL_ASSERT(FALSE);
    }
#if NODE_TYPE
  rfChannelScan();
#else
  rfRecvData();   
#endif
  while (TRUE);
}
