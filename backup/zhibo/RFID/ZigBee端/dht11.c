#include "dht11.h"
//#include "sys_init.h"
#include "hal_mcu.h"
#include "hal_assert.h"
#include "hal_board.h"

#include "hal_rf.h"
#include "basic_rf.h"


unsigned char sTemp;
unsigned char sHumidity;

DHT11 dht1;

#pragma optimize=none
static char dht11_read_bit(void)
{
  int i = 0;
  
  while (!COM_R);
  for (i=0; i<200; i++) {
    if (COM_R == 0) break;
  }
  if (i<30)return 0;  //30us
  return 1;
}

#pragma optimize=none
static unsigned char dht11_read_byte(void)
{
  unsigned char v = 0, b;
  int i;
  for (i=7; i>=0; i--) {
    b = dht11_read_bit();
    v |= b<<i;
  }
  return v; 
}

void halWait(unsigned char wait)
{
  unsigned long largeWait;

  if(wait == 0)
  {return;}
  largeWait = ((unsigned short) (wait << 7));
  largeWait += 114*wait;

  largeWait = (largeWait >> CLKSPD1);
  while(largeWait--);

  return;
}

void dht11_io_init(void)//温湿度初始化
{
  P0SEL  &= ~0x20;          //P0.5为普通 I/O 口
  COM_OUT;
  COM_SET;  
}
unsigned char dht11_temp(void)
{
  return sTemp;
}
unsigned char dht11_humidity(void)
{
  return sHumidity;
}

void dht11_update(void)//温湿度采集
{
  int flag = 1;
  unsigned char dat1, dat2, dat3, dat4, dat5, ck;
  
  //主机拉低18ms 
  COM_CLR;
  halMcuWaitMs(20);
//  halWait(18);
//  MicroWait(20);
  COM_SET;
  
  flag = 0;
  while (COM_R && ++flag);
  if (flag == 0) return;
  
  //总线由上拉电阻拉高 主机延时20us
  //主机设为输入 判断从机响应信号  
  //判断从机是否有低电平响应信号 如不响应则跳出，响应则向下运行	  	    
  flag = 0;
  while (!COM_R && ++flag);
  if (flag == 0) return;
  flag = 0;
  while (COM_R && ++flag);
  if (flag == 0) return;
  
  
  dat1 = dht11_read_byte();
  
  dat2 = dht11_read_byte();
  
  dat3 = dht11_read_byte();
   
  dat4 = dht11_read_byte();  
  
  dat5 = dht11_read_byte();            
  
  ck = dat1 + dat2 + dat3 + dat4;
  
  if (ck == dat5) {
    sTemp = dat3;
    sHumidity = dat1;        
    dht1.Sensor_Hig=dat3;
    dht1.Sensor_Low=dat1;  
  }
}



 //下面是光敏电阻相关函数
/*Photoresistance_Test函数
-------------------------------------------------------*/
void Photoresistance_Test(void)
{
  int AdcValue;  
  AdcValue = getADC();
  dht1.Sensor_Hig=AdcValue/10;
  dht1.Sensor_Low=AdcValue%10;
  D7=!D7;                             //标志发送状态
}

/*得到ADC值
-------------------------------------------------------*/
int getADC(void) 
{
  unsigned int  value;
  
  P0SEL |= 0x02;
  ADCCON3  = (0xB1);                    //选择AVDD5为参考电压；12分辨率；P0_1  ADC
  
  ADCCON1 |= 0x30;                      //选择ADC的启动模式为手动
  ADCCON1 |= 0x40;                      //启动AD转化             
  
  while(!(ADCCON1 & 0x80));             //等待ADC转化结束
  
  value =  ADCL >> 2;
  value |= (ADCH << 6);                 //取得最终转化结果，存入value中
  
  return ((value) >> 2);        
}


 //下面是LED相关函数
/*led初始化-------------------------------------------------------*/
void led_init(void)
{
  P1SEL &= ~0x03;          //P1.0 P1.1为普通 I/O 口
  P1DIR |= 0x03;           //输出
  
  D7 = 1;                //关LED
  D6 = 1;
}
/*酒精传感器-------------------------------------------------------*/
void AlcoholGas_Test(void)
{
  char StrAdc[10];
  int AdcValue; 
  
  AdcValue = getADC();
  dht1.Sensor_Hig=AdcValue/16;
  dht1.Sensor_Low=AdcValue%16;
}
void Infrared_Init(void)
{
  P0SEL &= ~0x20;                        //P0_5为普通io口
  P0DIR &= ~0x20;                        //P0_5输入
}
void Infrared_Test(void)//人体红外数据采集
{
//  char Str[10];
  int Value;
  
  Value = P0_5;
  dht1.Sensor_Hig=Value;
  dht1.Sensor_Low=0;
//  Uart_Send_char(Value);
//  sprintf(Str,"%d\r\n",Value);
//  Uart_Send_String(Str);            //串口发送数据
//  halWait(250);                     //延时
  D7=!D7;                           //标志发送状态
//  halWait(250);
//  halWait(250);
}