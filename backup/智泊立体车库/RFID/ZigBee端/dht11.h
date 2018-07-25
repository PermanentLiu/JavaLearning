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

#define D7    P1_0              //定义D7为P1_0口控制
#define D6    P1_1              //定义D6为P1_1口控制

#define moto1    P0_3     //定义电机驱动引脚
#define moto2    P0_5    

typedef struct    //传感器返回数据结构体
{
    unsigned char head[2];  //头帧
    unsigned char length;//有效数据位长度
    unsigned char type;  //类型
    unsigned char Sensor_Hig;   //传感器数据
    unsigned char Sensor_Low;   //传感器数据
    unsigned char checksum;  //校验和
    unsigned char sendflag;  //AA，代表发送的标志
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