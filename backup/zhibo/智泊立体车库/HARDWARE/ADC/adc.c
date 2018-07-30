#include "adc.h"
 #include "delay.h"
//////////////////////////////////////////////////////////////////////////////////	 
//±¾³ÌĞòÖ»¹Ñ§Ï°Ê¹ÓÃ£¬Î´¾­×÷ÕßĞí¿É£¬²»µÃÓÃÓÚÆäËüÈÎºÎÓÃÍ¾
//ALIENTEKÕ½½¢STM32¿ª·¢°å
//ADC ´úÂë	   
//ÕıµãÔ­×Ó@ALIENTEK
//¼¼ÊõÂÛÌ³:www.openedv.com
//ĞŞ¸ÄÈÕÆÚ:2012/9/7
//°æ±¾£ºV1.0
//°æÈ¨ËùÓĞ£¬µÁ°æ±Ø¾¿¡£
//Copyright(C) ¹ãÖİÊĞĞÇÒíµç×Ó¿Æ¼¼ÓĞÏŞ¹«Ë¾ 2009-2019
//All rights reserved									  
////////////////////////////////////////////////////////////////////////////////// 
	   
		   
//³õÊ¼»¯ADC
//ÕâÀïÎÒÃÇ½öÒÔ¹æÔòÍ¨µÀÎªÀı
//ÎÒÃÇÄ¬ÈÏ½«¿ªÆôÍ¨µÀ0~3																	   
void  Adc_Init(void)
{ 	
	ADC_InitTypeDef ADC_InitStructure; 
	GPIO_InitTypeDef GPIO_InitStructure;

	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA |RCC_APB2Periph_ADC1	, ENABLE );	  //Ê¹ÄÜADC1Í¨µÀÊ±ÖÓ
 

	RCC_ADCCLKConfig(RCC_PCLK2_Div6);   //ÉèÖÃADC·ÖÆµÒò×Ó6 72M/6=12,ADC×î´óÊ±¼ä²»ÄÜ³¬¹ı14M

	//PA1 0 ×÷ÎªÄ£ÄâÍ¨µÀÊäÈëÒı½Å                         
	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_1|GPIO_Pin_0;
	GPIO_InitStructure.GPIO_Mode = GPIO_Mode_AIN;		//Ä£ÄâÊäÈëÒı½Å
	GPIO_Init(GPIOA, &GPIO_InitStructure);	

	ADC_DeInit(ADC1);  //¸´Î»ADC1,½«ÍâÉè ADC1 µÄÈ«²¿¼Ä´æÆ÷ÖØÉèÎªÈ±Ê¡Öµ

	ADC_InitStructure.ADC_Mode = ADC_Mode_Independent;	//ADC¹¤×÷Ä£Ê½:ADC1ºÍADC2¹¤×÷ÔÚ¶ÀÁ¢Ä£Ê½
	ADC_InitStructure.ADC_ScanConvMode = ENABLE;	//Ä£Êı×ª»»¹¤×÷ÔÚµ¥Í¨µÀÄ£Ê½
	ADC_InitStructure.ADC_ContinuousConvMode = DISABLE;	//Ä£Êı×ª»»¹¤×÷ÔÚµ¥´Î×ª»»Ä£Ê½
	ADC_InitStructure.ADC_ExternalTrigConv = ADC_ExternalTrigConv_None;	//×ª»»ÓÉÈí¼ş¶ø²»ÊÇÍâ²¿´¥·¢Æô¶¯
	ADC_InitStructure.ADC_DataAlign = ADC_DataAlign_Right;	//ADCÊı¾İÓÒ¶ÔÆë
	ADC_InitStructure.ADC_NbrOfChannel = 2;	//Ë³Ğò½øĞĞ¹æÔò×ª»»µÄADCÍ¨µÀµÄÊıÄ¿
	ADC_Init(ADC1, &ADC_InitStructure);	//¸ù¾İADC_InitStructÖĞÖ¸¶¨µÄ²ÎÊı³õÊ¼»¯ÍâÉèADCxµÄ¼Ä´æÆ÷   

  
	ADC_Cmd(ADC1, ENABLE);	//Ê¹ÄÜÖ¸¶¨µÄADC1
	
	ADC_ResetCalibration(ADC1);	//Ê¹ÄÜ¸´Î»Ğ£×¼  
	 
	while(ADC_GetResetCalibrationStatus(ADC1));	//µÈ´ı¸´Î»Ğ£×¼½áÊø
	
	ADC_StartCalibration(ADC1);	 //¿ªÆôADĞ£×¼
 
	while(ADC_GetCalibrationStatus(ADC1));	 //µÈ´ıĞ£×¼½áÊø
 
//	ADC_SoftwareStartConvCmd(ADC1, ENABLE);		//Ê¹ÄÜÖ¸¶¨µÄADC1µÄÈí¼ş×ª»»Æô¶¯¹¦ÄÜ

}				  
//»ñµÃADCÖµ
//:Í¨µÀÖµ 0~3
u16 Get_Adc(u8 ch)   
{
  	//ÉèÖÃÖ¸¶¨ADCµÄ¹æÔò×éÍ¨µÀ£¬Ò»¸öĞòÁĞ£¬²ÉÑùÊ±¼ä
	ADC_RegularChannelConfig(ADC1, ch, 2, ADC_SampleTime_239Cycles5 );	//ADC1,ADCÍ¨µÀ,²ÉÑùÊ±¼äÎª239.5ÖÜÆÚ	  			    
 // ADC_RegularChannelConfig(ADC1, ADC_Channel_0, 2, ADC_SampleTime_239Cycles5 );	//ADC1,ADCÍ¨µÀ,²ÉÑùÊ±¼äÎª239.5ÖÜÆÚ
	
	ADC_SoftwareStartConvCmd(ADC1, ENABLE);		//Ê¹ÄÜÖ¸¶¨µÄADC1µÄÈí¼ş×ª»»Æô¶¯¹¦ÄÜ	
	 
	while(!ADC_GetFlagStatus(ADC1, ADC_FLAG_EOC ));//µÈ´ı×ª»»½áÊø

	return ADC_GetConversionValue(ADC1);	//·µ»Ø×î½üÒ»´ÎADC1¹æÔò×éµÄ×ª»»½á¹û
}

u16 Get_Adc_Average(u8 ch,u8 times)
{
	u32 temp_val=0;
	u8 t;
	for(t=0;t<times;t++)
	{
		temp_val+=Get_Adc(ch);
		delay_ms(5);
	}
	return temp_val/times;
} 	 





















