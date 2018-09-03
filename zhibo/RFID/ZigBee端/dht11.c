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

void dht11_io_init(void)//��ʪ�ȳ�ʼ��
{
  P0SEL  &= ~0x20;          //P0.5Ϊ��ͨ I/O ��
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

void dht11_update(void)//��ʪ�Ȳɼ�
{
  int flag = 1;
  unsigned char dat1, dat2, dat3, dat4, dat5, ck;
  
  //��������18ms 
  COM_CLR;
  halMcuWaitMs(20);
//  halWait(18);
//  MicroWait(20);
  COM_SET;
  
  flag = 0;
  while (COM_R && ++flag);
  if (flag == 0) return;
  
  //������������������ ������ʱ20us
  //������Ϊ���� �жϴӻ���Ӧ�ź�  
  //�жϴӻ��Ƿ��е͵�ƽ��Ӧ�ź� �粻��Ӧ����������Ӧ����������	  	    
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



 //�����ǹ���������غ���
/*Photoresistance_Test����
-------------------------------------------------------*/
void Photoresistance_Test(void)
{
  int AdcValue;  
  AdcValue = getADC();
  dht1.Sensor_Hig=AdcValue/10;
  dht1.Sensor_Low=AdcValue%10;
  D7=!D7;                             //��־����״̬
}

/*�õ�ADCֵ
-------------------------------------------------------*/
int getADC(void) 
{
  unsigned int  value;
  
  P0SEL |= 0x02;
  ADCCON3  = (0xB1);                    //ѡ��AVDD5Ϊ�ο���ѹ��12�ֱ��ʣ�P0_1  ADC
  
  ADCCON1 |= 0x30;                      //ѡ��ADC������ģʽΪ�ֶ�
  ADCCON1 |= 0x40;                      //����ADת��             
  
  while(!(ADCCON1 & 0x80));             //�ȴ�ADCת������
  
  value =  ADCL >> 2;
  value |= (ADCH << 6);                 //ȡ������ת�����������value��
  
  return ((value) >> 2);        
}


 //������LED��غ���
/*led��ʼ��-------------------------------------------------------*/
void led_init(void)
{
  P1SEL &= ~0x03;          //P1.0 P1.1Ϊ��ͨ I/O ��
  P1DIR |= 0x03;           //���
  
  D7 = 1;                //��LED
  D6 = 1;
}
/*�ƾ�������-------------------------------------------------------*/
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
  P0SEL &= ~0x20;                        //P0_5Ϊ��ͨio��
  P0DIR &= ~0x20;                        //P0_5����
}
void Infrared_Test(void)//����������ݲɼ�
{
//  char Str[10];
  int Value;
  
  Value = P0_5;
  dht1.Sensor_Hig=Value;
  dht1.Sensor_Low=0;
//  Uart_Send_char(Value);
//  sprintf(Str,"%d\r\n",Value);
//  Uart_Send_String(Str);            //���ڷ�������
//  halWait(250);                     //��ʱ
  D7=!D7;                           //��־����״̬
//  halWait(250);
//  halWait(250);
}