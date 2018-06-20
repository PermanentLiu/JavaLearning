#include "pwm.h"
#include "delay.h"

void TIM2_PWM_Init(void)
{
	GPIO_InitTypeDef  GPIO_InitStructure;
	TIM_OCInitTypeDef TIM_OCInitStructure;
	TIM_TimeBaseInitTypeDef TIM_TimeBaseStructure;
	
	//RCC_APB2PeriphClockCmd(RCC_APB2Periph_TIM1,ENABLE);
	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM2,ENABLE);
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA,ENABLE);

	
	GPIO_InitStructure.GPIO_Pin=GPIO_Pin_1|GPIO_Pin_0;//����PA.0��
	GPIO_InitStructure.GPIO_Mode=GPIO_Mode_AF_PP;//�����������
	GPIO_InitStructure.GPIO_Speed=GPIO_Speed_50MHz;//����ٶ�50Mhz
	GPIO_Init(GPIOA,&GPIO_InitStructure);//��ʼ��PD.2��
	
	//1KHZ	
	TIM_TimeBaseStructure.TIM_Period=1999;//�Զ���װ��ֵ
	TIM_TimeBaseStructure.TIM_Prescaler=719;//Ԥ��Ƶֵ
	TIM_TimeBaseStructure.TIM_ClockDivision =0;//����ʱ�ӷָ�
	TIM_TimeBaseStructure.TIM_CounterMode =TIM_CounterMode_Up;//���ϼ���ģʽ
	TIM_TimeBaseInit(TIM2,&TIM_TimeBaseStructure);//��ʼ����ʱ��

	//��ʱ��TIM2ΪPWM1ģʽ
	TIM_OCInitStructure.TIM_OCMode=TIM_OCMode_PWM1;
	TIM_OCInitStructure.TIM_OutputState=TIM_OutputState_Enable;
	TIM_OCInitStructure.TIM_Pulse=0;
	TIM_OCInitStructure.TIM_OCIdleState=TIM_OCIdleState_Set;
	
	TIM_OCInitStructure.TIM_OCPolarity=TIM_OCPolarity_High;//�ߵ�ƽ
	TIM_OC1Init(TIM2,&TIM_OCInitStructure);
	TIM_OC1PreloadConfig(TIM2, TIM_OCPreload_Enable);  //CH1Ԥװ��ʹ��	
	
	TIM_OCInitStructure.TIM_OCPolarity=TIM_OCPolarity_High;//�ߵ�ƽ
	TIM_OC2Init(TIM2,&TIM_OCInitStructure);
	TIM_OC2PreloadConfig(TIM2, TIM_OCPreload_Enable);  //CH2Ԥװ��ʹ��	
	
	TIM_CtrlPWMOutputs(TIM2,ENABLE);	//MOE �����ʹ��		
	TIM_ARRPreloadConfig(TIM2, ENABLE); //ʹ��TIMx��ARR�ϵ�Ԥװ�ؼĴ���
	TIM_Cmd(TIM2,ENABLE);//ʹ�ܶ�ʱ��
}
