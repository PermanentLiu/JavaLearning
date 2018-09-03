#include "beep.h"
#include "led.h"
#include "pwm.h"
#include "delay.h"
#include "sys.h"
#include "rc522.h"
#include "key.h"             //�������ģ��
#include "usart.h"
#include "usart3.h"
#include "string.h" 
//#include "oled.h"
#include "myiic.h"
#include "OLED_I2C.h"
#include "myalg.h"
#include "common.h"
#include "timer.h"
#define MODE 0    //1����  
//////////////////////////////////////////////////////////
//M1���֞�16���ȅ^��ÿ���ȅ^��4�K���K0���K1���K2���K3���M��
//�҂�Ҳ��16���ȅ^��64���K���^����ַ��̖0~63
//��0�ȅ^�ĉK0�����^����ַ0�K��������춴�ŏS�̴��a���ѽ��̻������ɸ���
//ÿ���ȅ^�ĉK0���K1���K2�锵���K������춴�Ŕ���
//ÿ���ȅ^�ĉK3����ƉK���^����ַ�K3��7��11....�����������ܴaA����ȡ���ơ��ܴaB��

/*******************************
*����˵����RFID
*1--SDA  <----->PB0
*2--SCK <----->PB13
*3--MOSI<----->PB15
*4--MISO<----->PB14
*5--����
*6--GND <----->GND
*7--RST <----->PB1
*8--VCC <----->VCC

	����<----->PA2 PA3
	���<----->PA0  PA1�����ã�

  OLED
  SDA <----->PC1
  SCK <----->PC0
	
	esp8266
	RST<----->PB10
	TS <----->PB11
************************************/
/*ȫ�ֱ���*/
unsigned char CT[2];//������
unsigned char SN[4]; //����
unsigned char RFID_ID[16];
unsigned char RFID[16];			//���RFID 
unsigned char RFID_T[16]="1400370221sc12";
u8 wallet[16]={0x01,0x01,0x01,0x01,0xfe,0xfe,0xfe,0xfe,0x01,0x01,0x01,0x01,0x04,~0x04,0x04,~0x04};
//unsigned char lxl_bit=0;
//unsigned char card1_bit=0;
//unsigned char card2_bit=0;
//unsigned char card3_bit=0;
//unsigned char card4_bit=0;
//unsigned char total=0;
//unsigned char lxl[4]={250,67,149,198};
//unsigned char card_1[4]={66,193,88,0};
//unsigned char RFID1[16]={0x00,0x00,0x00,0x00,0x00,0x00,0xff,0x07,0x80,0x29,0xff,0xff,0xff,0xff,0xff,0xff};
u8 money_add[4]={0x01,0x01,0x01,0x01};
u8 money_dev[4];
u8 KeyA[6] = { 0xff,0xff,0xff,0xff,0xff,0xff };
u8 KeyB[6] = { 0xff,0xff,0xff,0xff,0xff,0xff };
u8 addr = 0x04;//0��
u8 key_addr = 0x07;//β��
/*��������*/
void ShowID(u16 x,u16 y, u8 *p, u16 charColor, u16 bkColor);	 //��ʾ���Ŀ��ţ���ʮ��������ʾ
void PutNum(u16 x,u16 y, u32 n1,u8 n0, u16 charColor, u16 bkColor);	//��ʾ����
void Store(u8 *p,u8 store,u8 cash);//����Ҫ��һ������	

////////////////////////////////////////////////////////////////////////

 u16 led0pwmval=0,led1pwmval=190;   
 u8 dir0=1,dir1=1;	

//PWM���Գ���
void PWM_1()
{

	
//	delay_ms(10);	 
//	if(dir0)led0pwmval++;
//	else led0pwmval--;	 
//  if(led0pwmval>1)dir0=0;
//	if(led0pwmval==0)dir0=1;	   	
	TIM_SetCompare1(TIM2,200);//STM2�ŵ�1����PA0
		 
//	delay_ms(10);
//	if(dir1)led1pwmval++;
//	else led1pwmval--;	 
//  if(led1pwmval>1)dir1=0;
//	if(led1pwmval==0)dir1=1;	   	
//	TIM_SetCompare2(TIM2,led1pwmval);//STM2�ŵ�2����PA1
}
////////////////////////////////////////////////////////////////////
void RFID_detection()
{
	unsigned char status;

//	while(status!=MI_OK)
	status = PcdRequest(PICC_REQALL,CT);/*����*/
	if (status != MI_OK)
	{			
		status = PcdRequest(PICC_REQALL, CT);//Ѱ��
	}
	if(status==MI_OK)//�����ɹ�
	{
		 status=MI_ERR;
		 status = PcdAnticoll(SN);/*����ײ*/							 
		if (status==MI_OK)//���nײ�ɹ�
		{
#if MODE
			sprintf((char*)RFID_ID,"ID:%02x%02x%02x%02x:",SN[0],SN[1],SN[2],SN[3]);
#else 
			sprintf((char*)RFID_ID,"iD:%02x%02x%02x%02x:",SN[0],SN[1],SN[2],SN[3]);
#endif 
//				OLED_ShowString(1,4,RFID_ID);
			u3_printf("%s\r\n",RFID_ID);
			printf("%s\r\n",RFID_ID);
		delay_ms(500);			
		}
	}		
}

int main(void)
{		
	unsigned char status;
	u8 flag = 1;
	u16 money;
	u8 j;
	u8 o;
 	delay_init();	    	 //��ʱ������ʼ��	  
	NVIC_Configuration(); 	 //����NVIC�жϷ���2:2λ��ռ���ȼ���2λ��Ӧ���ȼ�
	uart_init(115200);	

	LED_Init();		  	 	//��ʼ����LED���ӵ�Ӳ���ӿ�
//	BEEP_Init();         	//��ʼ���������˿�	
	KEY_Init();	 
#if MODE
	IIC_Init();
	OLED_Init();
#endif	
	TIM2_PWM_Init();			//PWM��ʼ��
	InitRc522();				//��ʼ����Ƶ��ģ��
	printf("\r\ncpu is OK\r\n");
	OLED_CLS();

	usart3_init(115200);	
	TIM7_Int_Init(1000-1,720-1);
	atk_8266_apsta_test();
//	atk_8266_init();
#if MODE
	u3_printf("stm32");
	OLED_ShowStr(0,0,"ok",2);	
#else 
	u3_printf("guard");
#endif
	USART3_RX_BUF[0]=0;
	USART3_RX_STA=0;
	TIM_SetCompare1(TIM2,200);
	TIM_SetCompare2(TIM2,200);
//	while(1)
//	{
//	RFID_detection();
//	}
		
	while(1)
	{		
		if(USART3_RX_STA&0x8000)  //���緵����Ϣ���
		{
			OLED_ShowStr(0,0,USART3_RX_BUF,1);
			if(USART3_RX_BUF[0]=='8')
			{
				o=1;
			}			
			if(USART3_RX_BUF[0]=='9')
			{
				o=2;
			}
			USART3_RX_BUF[0]=0;
			USART3_RX_STA=0;
		}
#if !MODE
		if(o==1||o==2)
		{
			if(o==1)
				TIM_SetCompare1(TIM2,100);
			else
				TIM_SetCompare2(TIM2,100);
		}
		if(KEY3==0&&(o==1||o==4))								//������
		{
			o+=2;
		}
		if(KEY1==0&&(o==2||o==3))								//������
		{
			o+=2;
		}
		if(o>4)
		{
			o=0;
			TIM_SetCompare1(TIM2,200);
			TIM_SetCompare2(TIM2,200);//��һ��ʱ�����			
		}
#endif
		if(KEY2==0)								//
		{
			OLED_CLS();		
		}		
		delay_ms(200);
		RFID_detection();         //ˢ�����
		delay_ms(50);
	}
}
			



/*************************************
*�������ܣ���ʾ���Ŀ��ţ���ʮ��������ʾ
*������x��y ����
*		p ���ŵĵ�ַ
*		charcolor �ַ�����ɫ
*		bkcolor   ��������ɫ
***************************************/
void ShowID(u16 x,u16 y, u8 *p, u16 charColor, u16 bkColor)	 //��ʾ���Ŀ��ţ���ʮ��������ʾ
{
	u8 num[9];
	u8 i;

	for(i=0;i<4;i++)
	{
		num[i*2]=p[i]/16;
		num[i*2]>9?(num[i*2]+='7'):(num[i*2]+='0');
		num[i*2+1]=p[i]%16;
		num[i*2+1]>9?(num[i*2+1]+='7'):(num[i*2+1]+='0');
	}
	num[8]=0;
//	POINT_COLOR=RED;	  
//	LCD_ShowString(x,y,200,16,16,"The Card ID about 16 is:");	
	//DisplayString(x,y+16,num,charColor,bkColor);
 	for(i=0;i<8;i++)
	{
//		  LCD_ShowNum(x+16*i,y+16,num[i],2,16);
		  //LCD_ShowNum(x,y+32,num[1],2,16);
		 // LCD_ShowNum(x,y+48,num[2],2,16);
		 // LCD_ShowNum(x,y+64,num[3],2,16);
		  
		 // LCD_ShowNum(x,y+80,num[4],2,16);
		 // LCD_ShowNum(x,y+96,num[5],2,16);
		 // LCD_ShowNum(x,y+16*7,num[6],2,16);
		 // LCD_ShowNum(x,y+16*8,num[7],2,16);
		 // LCD_ShowNum(x,y+16*9,num[8],2,16);
		 // LCD_ShowNum(x,y+16*10,num[9],2,16);
	}
	
}
