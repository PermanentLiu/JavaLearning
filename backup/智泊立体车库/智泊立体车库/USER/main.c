#include "led.h"
#include "delay.h"
#include "key.h"
#include "sys.h"
#include "lcd.h"
#include "usart.h"	 
#include "dht11.h" 	 
#include "adc.h"
#include "timer.h"
#include "common.h"
#include "myalg.h"
#include "usart3.h"
//ALIENTEK战舰STM32开发板实验31
//DHT11数字温湿度传感器 实验  
//技术支持：www.openedv.com
//广州市星翼电子科技有限公司  
u8 sendflag;
struct car
{
	u8 x;
	u8 y;
	u8 flag;//1取 2存
};
struct car carflag;
struct car carnow;
void get_S()   //PA1
{		
	u16 adcx;
	adcx=Get_Adc_Average(ADC_Channel_1,20)+1;
	LCD_ShowNum(60+40,50,adcx,4,16);	
}
u16 get_G()  //PA0
{
  u16 adcx; 
	adcx=Get_Adc_Average(ADC_Channel_0,20)+1;
	LCD_ShowNum(60+40,70,adcx,4,16);
	return adcx;
}


void up()
{
	TIM_SetCompare1(TIM4,1500);
	LCD_ShowString(90,250,230,16,16,"up   ");
}

void down()
{
	TIM_SetCompare1(TIM4,1890);
	LCD_ShowString(90,250,230,16,16,"down ");
}

void stop_ud()
{
	TIM_SetCompare1(TIM4,2000);
}

void left()
{
	TIM_SetCompare4(TIM4,1852);
	LCD_ShowString(90,250,230,16,16,"left ");
}

void rigth()
{
	TIM_SetCompare4(TIM4,1858);
	LCD_ShowString(90,250,230,16,16,"right");
}

void stop_lr()
{
	TIM_SetCompare4(TIM4,2000);
}

void get_ur3()
{
	u8 j;
	if(USART3_RX_STA|0x8000)
	{
		LCD_ShowString(0,0,200,16,16,USART3_RX_BUF);		
		j=String_IndexOf(USART3_RX_BUF,"size:");
		if(j>0)
		{
			if((USART3_RX_BUF[j+5]>'0')&&(USART3_RX_BUF[j+6]==',')&&(USART3_RX_BUF[j+7]>='0'))
			{
				carflag.x=USART3_RX_BUF[j+5]-'0';
				carflag.y=USART3_RX_BUF[j+7]-'0';
				if(String_IndexOf(USART3_RX_BUF,"cun")>=0) carflag.flag=2;		
				else if(String_IndexOf(USART3_RX_BUF,"qu")>=0)carflag.flag=1;				
			}
		}
	}
}

void shen()
{
	u8 t;
	for(t=30;t>0;t--)
	{
		TIM_SetCompare1(TIM3,1809+t);
		TIM_SetCompare2(TIM3,1839-t);
//			set_PWM(190-t,165+t,0,0);
		delay_ms(10);
	}	
	LCD_ShowString(90,250,230,16,16,"shen");	
}
	
void shuo()
{
	u8 t;
	for(t=0;t<=31;t++)
	{
		t++;
		TIM_SetCompare1(TIM3,1809+t);
		TIM_SetCompare2(TIM3,1839-t);
//			set_PWM(190-t,165+t,0,0);
		delay_ms(10);
	}
	LCD_ShowString(90,250,230,16,16,"shou");	
}

void U_D(u8 t)
{
	if(t==1)
	{
		LED0=1;
		LCD_ShowString(90,250,230,16,16,"tai");	
	}
	else if(t==2)
	{
		LED0=0;
		LCD_ShowString(90,250,230,16,16,"fang");	
	}
}

void cont(u8 t)
{
	shen();
	delay_ms(500);
	U_D(t);
	delay_ms(500);
	shuo();
	delay_ms(500);
	carnow.flag++;
}

void carflaginit()
{
	carflag.flag=0;
	carflag.x=0;
	carflag.y=0;
}

void run()
{
	if(carflag.flag==1)  //jin车
	{
		LCD_ShowString(0,0,230,16,16,"jin");	
		if(carnow.flag==0)
		{
			cont(1);
		}
		else if(carnow.flag==1)
		{
			if(carnow.y!=carflag.y)
			{
				up();
				if(hong1==0)
				{
					delay_ms(10);
					if(hong1==0)
					{
						delay_ms(300);
						carnow.y++;
						if(carnow.y==carflag.y)
							stop_ud();
					}
				}
			}
			else if(carnow.x!=carflag.x)
			{
				left();
				if(hong2==0)
				{					
					delay_ms(10);
					if(hong2==0)
					{
						delay_ms(300);
						carnow.x++;
					}
				}
				if(carnow.x==carflag.x)
					stop_lr();
			}
			else carnow.flag++;				
		}
		else if(carnow.flag==2)
		{
			cont(2);
		}
		else if(carnow.flag==3)
		{
			if(carnow.y!=1)
			{
				down();
				if(hong1==0)
				{
					delay_ms(10);
					if(hong1==0)
					{
						delay_ms(300);
						carnow.y--;
						if(carnow.y==1)
						{
//							delay_ms(1000);
							stop_ud();
						}
					}	
				}
			}
			else if(carnow.x!=1)
			{
				rigth();
				if(hong2==0)
				{
					delay_ms(10);
					if(hong2==0)
					{
						delay_ms(300);
						carnow.x--;
					}
				}
				if(carnow.x==1)
					stop_lr();
			}
			else carnow.flag++;				
		}
		else if(carnow.flag==4)
		{
			carnow.flag=0;
			LCD_ShowString(90,290,230,16,16,"jin success");		
			u3_printf("success");
			carflaginit();
		}
	}
	
	else if(carflag.flag==2)  //chu车
	{
		LCD_ShowString(0,0,230,16,16,"chu");	
		if(carnow.flag==0)
		{
			if(carnow.y!=carflag.y)
			{
				up();
				if(hong1==0)
				{
					delay_ms(10);
					if(hong1==0)
					{						
						delay_ms(300);
						carnow.y++;
						if(carnow.y==carflag.y)
							stop_ud();
					}
				}
			}
			else if(carnow.x!=carflag.x)
			{
				left();
				if(hong2==0)
				{
					delay_ms(10);
					if(hong2==0)
					{						
						carnow.x++;
						delay_ms(300);
					}
				}
				if(carnow.x==carflag.x)
					stop_lr();
			}
			else carnow.flag++;				
		}
		else if(carnow.flag==1)
		{
			cont(1);
		}
		else if(carnow.flag==2)
		{
			if(carnow.y!=1)
			{
				down();
				if(hong1==0)
				{
					delay_ms(10);
					if(hong1==0)
					{						
						carnow.y--;
						delay_ms(300);
						if(carnow.y==1)
						{
//							delay_ms(300);
							stop_ud();
						}
					}
				}
			}
			else if(carnow.x!=1)
			{
				rigth();
				if(hong2==0)
				{
					delay_ms(10);
					if(hong2==0)
					{						
						carnow.x--;
						delay_ms(300);
					}
				}
				if(carnow.x==1)
					stop_lr();
			}
			else carnow.flag++;							
		}
		else if(carnow.flag==3)
		{
			cont(2);
		}
		else if(carnow.flag==4)
		{
			carnow.flag=0;
			LCD_ShowString(90,290,230,16,16,"chu success");		
			u3_printf("success");
			carflaginit();		
		}
	}
	
	LCD_ShowNum(60+40,0,carnow.x,2,16);
	LCD_ShowNum(60+56,0,carnow.y,2,16);
	LCD_ShowNum(60+72,0,carnow.flag,2,16);
}

 int main(void)
 {	 
	u8 t=0;			    
	u8 temperature1,temperature2;	    
	u8 humidity1,humidity2;    	 
	u8 flag;
	u16 gas;
	delay_init();	    	 //延时函数初始化	  
	NVIC_Configuration(); 	 //设置NVIC中断分组2:2位抢占优先级，2位响应优先级
	uart_init(9600);	 	//串口初始化为9600
 	LED_Init();			     //LED端口初始化
	LCD_Init();	
	KEY_Init();	 	
	Adc_Init();
	usart3_init(115200);	
	TIM7_Int_Init(1000-1,720-1);	 
 	while(DHT11_Init())	//DHT11初始化	
	{
		LCD_ShowString(60,130,200,16,16,"DHT11 Error");
		delay_ms(200);
		LCD_Fill(60,130,239,130+16,WHITE);
 		delay_ms(200);
	}			
// 	while(DHT12_Init())	//DHT11初始化	
//	{
//		LCD_ShowString(60,180,200,16,16,"DHT12 Error");
//		delay_ms(200);
//		LCD_Fill(60,180,239,130+16,WHITE);
// 		delay_ms(200);
//	}				
	
	LCD_ShowString(60,130,200,16,16,"DHT11|DHT12 OK");
	POINT_COLOR=BLUE;//设置字体为蓝色 
	LCD_ShowString(60,50,200,16,16,"adc1:    %");
	LCD_ShowString(60,70,200,16,16,"adc2:    %");		
 	LCD_ShowString(60,150,200,16,16,"Temp:  C");	 
 	LCD_ShowString(60,170,200,16,16,"Humi:  %");	
	LCD_ShowString(60,190,200,16,16,"Temp:  C");	 
 	LCD_ShowString(60,210,200,16,16,"Humi:  %");	
//	LCD_ShowString(60,0,200,16,16,"KEY:");

	TIM2_Int_Init(19999,7199);
	TIM3_PWM_Init(1999,719);
	TIM4_PWM_Init(1999,719);		
	atk_8266_apsta_test();	
	u3_printf("park");
	TIM_Cmd(TIM2, ENABLE);  //使能TIMx外设
	USART3_RX_STA=0;
//	while(1)
//	{
//		if(USART3_RX_STA&0x8000) 
//		{
//			USART3_RX_STA=0;
//			switch(USART3_RX_BUF[0]-'0')
//			{
//				case 1:up();delay_ms(1000);break;
//				case 2:down();delay_ms(1000);break;
//				case 3:left();delay_ms(1000);break;
//				case 4:rigth();delay_ms(1000);break;
//				case 5:shen();break;
//				case 6:shuo();break;
//			}
//			stop_lr();
//			stop_ud();
//////			u3_printf("bezy");
//		}		
//	}
LED0=0;
carnow.x=1;
carnow.y=1;
	while(1)
	{	    
		if((USART3_RX_STA&0x8000)&&(carflag.flag==0))
		{
			USART3_RX_STA=0;
			LCD_ShowString(0,230,200,16,16,USART3_RX_BUF);
			if(String_IndexOf(USART3_RX_BUF,"jin")>=0)
			{
				carflag.flag=1;
				carflag.x=USART3_RX_BUF[3]-'0';
				carflag.y=USART3_RX_BUF[5]-'0';
				u3_printf("start");
			}
			else if(String_IndexOf(USART3_RX_BUF,"chu")>=0)
			{
				carflag.flag=2;
				carflag.x=USART3_RX_BUF[3]-'0';
				carflag.y=USART3_RX_BUF[5]-'0';		
				u3_printf("start");
			}
		}
		else if(USART3_RX_STA&0x8000) 
		{
			USART3_RX_STA=0;
			u3_printf("bezy");
		}
		if(carflag.flag>0)
			run();
 		if(sendflag>=5)//每100ms读取一次
		{									  
			DHT11_Read_Data(&temperature1,&humidity1);		//读取温湿度值					    
			LCD_ShowNum(60+40,150,temperature1,2,16);		//显示温度	   		   
			LCD_ShowNum(60+40,170,humidity1,2,16);			//显示湿度	 	
			gas=get_G();
			sendflag=0;
			u3_printf("environment:%d:%d:%d",temperature1,humidity1,gas);
//			DHT12_Read_Data(&temperature2,&humidity2);		//读取温湿度值					    
//			LCD_ShowNum(60+40,190,temperature2,2,16);		//显示温度	   		   
//			LCD_ShowNum(60+40,210,humidity2,2,16);			//显示湿度				
		}				   
		
		t++;
	}
}

void TIM2_IRQHandler(void)
{ 	
	if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET)//是更新中断
	{	 			   
		sendflag++;
		TIM_ClearITPendingBit(TIM2, TIM_IT_Update  );  //清除TIM7更新中断标志  
	}	    
}


