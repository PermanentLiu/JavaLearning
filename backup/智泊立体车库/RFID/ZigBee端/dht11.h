#include <ioCC2530.h>
#include <stdio.h>

#define       PIN_OUT       (P0DIR |= 0x20)
#define       PIN_IN        (P0DIR &= ~0x20)
#define       PIN_CLR       (P0_5 = 0)
#define       PIN_SET       (P0_5 = 1)
#define       PIN_R         (P0_5)

#define       COM_IN          PIN_IN  
#define       COM_OUT         PIN_OUT
#define       COM_CLR         PIN_CLR
#define       COM_SET         PIN_SET
#define       COM_R           PIN_R

#define CLKSPD1  ( CLKCONCMD & 0x07 )    //getting the clock division factor

#define D7    P1_0              //����D7ΪP1_0�ڿ���
#define D6    P1_1              //����D6ΪP1_1�ڿ���

#define moto1    P0_3     //��������������
#define moto2    P0_5    

typedef struct    //�������������ݽṹ��
{
    unsigned char head[2];  //ͷ֡
    unsigned char length;//��Ч����λ����
    unsigned char type;  //����
    unsigned char Sensor_Hig;   //����������
    unsigned char Sensor_Low;   //����������
    unsigned char checksum;  //У���
    unsigned char sendflag;  //AA�������͵ı�־
}DHT11;

static char dht11_read_bit(void);
static unsigned char dht11_read_byte(void);
void dht11_io_init(void);
unsigned char dht11_temp(void);
unsigned char dht11_humidity(void);
void dht11_update(void);
void halWait(unsigned char wait);
void led_init(void);


void Photoresistance_Test(void);
int getADC(void) ;
void AlcoholGas_Test(void);
void control_init(void);
void open_curtain(void);
void close_curtain(void);
void stop_curtain(void);
void Infrared_Init(void);
void Infrared_Test(void);