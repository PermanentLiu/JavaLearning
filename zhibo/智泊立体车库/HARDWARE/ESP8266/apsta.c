#include "common.h" 
#include "lcd.h"

	int name=111;
	
void atk_8266_apsta_send(void)
{

	u8 data[200];
		sprintf((char*)data,"mcu&11&0&12345678&%d&����name&50&100.0&#",name);   
		atk_8266_send_data((u8*)data,"OK",100);  //����ָ�����ȵ�����
	delay_ms(1000);
	delay_ms(1000);
	delay_ms(1000);
	delay_ms(1000);
	name++;
}
//ATK-ESP8266 AP+STAģʽ

void atk_8266_init()
{
	u3_printf("AT");
	delay_ms(50);
	u3_printf("ATE0");	
	delay_ms(20);
	u3_printf("AT+CWMODE=3");	
	delay_ms(20);
	u3_printf("AT+CWSAP=\"Smart home\",\"12345678\",1,4");	
	delay_ms(20);
	u3_printf("AT+CWJAP=\"sc\",\"sc71787511\"");
	delay_ms(200);
	u3_printf("AT+CIPMUX=0");
	delay_ms(20);
	u3_printf("AT+CIPSTART=\"TCP\",\"192.168.1.101\",26900");
	delay_ms(200);
	u3_printf("AT+CIPMODE=1");
	delay_ms(20);
	u3_printf("AT+CIPSEND");
	delay_ms(20);
	USART3_RX_STA=0;
}

void atk_8266_apsta_test(void)
{
//	LCD_ShowString(30,130,240,16,16,(u8*)"ATK-ESP8266 WIFI");
//	LCD_ShowString(0,30,"ATK-ESP8266 WIFIģ�����",16,240); 
		while(atk_8266_send_cmd("AT","OK",200))//���WIFIģ���Ƿ�����
	{
		delay_ms(50);		
		atk_8266_quit_trans();//�˳�͸��
		delay_ms(15);
		atk_8266_send_cmd("AT+CIPMODE=0","OK",200);  //�ر�͸��ģʽ	
//	 	printf("WIFI  error");	
		delay_ms(50);
	} 
	while(atk_8266_send_cmd("ATE0","OK",20));//�رջ���
	atk_8266_send_cmd("AT+CWMODE=3","OK",50);		//����WIFI AP+STAģʽ
	
	atk_8266_send_cmd("AT+CWSAP=\"Smart home\",\"12345678\",1,4","OK",1000);					//����APģʽ����
//	atk_8266_send_cmd("AT+CWJAP=\"sc1\",\"1234567890\"","WIFI GOT IP",1000);
	atk_8266_send_cmd("AT+CWJAP=\"sc\",\"sc71787511\"","WIFI GOT IP",1000);						//����Ŀ��·�����������IP
	//while(atk_8266_send_cmd("AT+CIFSR","STAIP",200));   //����Ƿ���STA IP
	 atk_8266_send_cmd("AT+CIPMUX=0","OK",20);   //0�������ӣ�1��������

//	while(atk_8266_send_cmd("AT+CIPSTART=\"TCP\",\"127.0.0.1\",9100","CONNECT",200))	
//	while(atk_8266_send_cmd("AT+CIPSTART=\"TCP\",\"125.217.54.240\",26903","CONNECT",200))//����Ŀ��TCP������,��ID�ţ�STAģʽ��Ϊ0	
	while(atk_8266_send_cmd("AT+CIPSTART=\"TCP\",\"192.168.1.101\",26900","CONNECT",200))//����Ŀ��TCP������,��ID�ţ�STAģʽ��Ϊ0	
	atk_8266_send_cmd("AT+CIPMODE=1","OK",200);      //����ģʽΪ��͸��	
	atk_8266_send_cmd("AT+CIPSEND","OK",20);         //��ʼ͸��
}
