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

	
	GPIO_InitStructure.GPIO_Pin=GPIO_Pin_1|GPIO_Pin_0;//配置PA.0口
	GPIO_InitStructure.GPIO_Mode=GPIO_Mode_AF_PP;//复用推挽输出
	GPIO_InitStructure.GPIO_Speed=GPIO_Speed_50MHz;//输出速度50Mhz
	GPIO_Init(GPIOA,&GPIO_InitStructure);//初始化PD.2口
	
	//1KHZ	
	TIM_TimeBaseStructure.TIM_Period=1999;//自动重装载值
	TIM_TimeBaseStructure.TIM_Prescaler=719;//预分频值
	TIM_TimeBaseStructure.TIM_ClockDivision =0;//设置时钟分割
	TIM_TimeBaseStructure.TIM_CounterMode =TIM_CounterMode_Up;//向上计数模式
	TIM_TimeBaseInit(TIM2,&TIM_TimeBaseStructure);//初始化定时器

	//定时器TIM2为PWM1模式
	TIM_OCInitStructure.TIM_OCMode=TIM_OCMode_PWM1;
	TIM_OCInitStructure.TIM_OutputState=TIM_OutputState_Enable;
	TIM_OCInitStructure.TIM_Pulse=0;
	TIM_OCInitStructure.TIM_OCIdleState=TIM_OCIdleState_Set;
	
	TIM_OCInitStructure.TIM_OCPolarity=TIM_OCPolarity_High;//高电平
	TIM_OC1Init(TIM2,&TIM_OCInitStructure);
	TIM_OC1PreloadConfig(TIM2, TIM_OCPreload_Enable);  //CH1预装载使能	
	
	TIM_OCInitStructure.TIM_OCPolarity=TIM_OCPolarity_High;//高电平
	TIM_OC2Init(TIM2,&TIM_OCInitStructure);
	TIM_OC2PreloadConfig(TIM2, TIM_OCPreload_Enable);  //CH2预装载使能	
	
	TIM_CtrlPWMOutputs(TIM2,ENABLE);	//MOE 主输出使能		
	TIM_ARRPreloadConfig(TIM2, ENABLE); //使能TIMx在ARR上的预装载寄存器
	TIM_Cmd(TIM2,ENABLE);//使能定时器
}
