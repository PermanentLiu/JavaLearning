#include <iocc2530.h>
#include "hal_mcu.h"
#include "hal_assert.h"
#include "hal_board.h"
#include "dht11.h"
#include "hal_rf.h"
#include "basic_rf.h"
#include <stdio.h>

extern char recvBuf[256];
extern int recvCnt; 
char a=0;
extern unsigned char data[10][6];
char mo;

void hal_led_init(void)
{
    P1SEL &= ~0x0D;          //����P1.0 p1.2 p1.3Ϊ��ͨ I/O ��
    P1DIR |= 0x0D;          //����P1.0  P1.2 p1.3 Ϊ���

    P2SEL &= ~0x01;
    P2DIR |= 0x01;
    
    P1 |= 0x0D;
    P2_0 |= 0x01;
}

void hal_led_off(int leds)
{
  if (leds & 0x01) {
    P1_0 |= 0x01;
  }
  if (leds & 0x02) {
    P1_2 |= 0x04;
  }
  if (leds & 0x04) {
    P1_3 |= 0x08;
  }
  if (leds & 0x08) {
    P2_0 |= 0x01;
  }
}
void hal_led_on(int leds)
{
    if (leds & 0x01) {
    P1_0 &= ~0x01;
  }
  if (leds & 0x02) {
    P1_2 &= ~0x04;
  }
  if (leds & 0x04) {
    P1_3 &= ~0x08;
  }
  if (leds & 0x08) {
    P2_0 &= ~0x01;
  }
}



/****************************************************************
*�������� ����ʼ������1										
*��ڲ��� ����												
*�� �� ֵ ����							
*˵    �� ��19200-8-n-1						
****************************************************************/
void hal_uart_init(void)
{
    PERCFG = 0x00;				//λ��1 P0��
    P0SEL |= 0x0C;				//P0��������
    P2DIR &= ~0XC0;                             //P0������Ϊ����0

    U0CSR |= 0x80;				//UART��ʽ
    U0CSR |= 0X40;				//�������
    
    U0GCR = 0x09;				//baud_e
    U0BAUD |= 0x3b;				//��������Ϊ19200
    UTX0IF = 0;
    
    IEN0|=0x84;
}

__near_func int putchar(int ch)
{
    U0DBUF = ch;
    while(UTX0IF == 0);
    UTX0IF = 0;
    return ch;
}

/*���ڷ����ֽں���
-------------------------------------------------------*/
void Uart_Send_char(char ch)
{
  U0DBUF = ch;
  while(UTX0IF == 0);
  UTX0IF = 0;
}

/*���ڷ����ַ�������
-------------------------------------------------------*/
void Uart_Send_String(char *Data)
{  
  while (*Data != '\0')
  {
    Uart_Send_char(*Data++);
  }
}

/*���ڽ����ֽں���
-------------------------------------------------------*/
int Uart_Recv_char(void)
{
  int ch;
    
  while (URX0IF == 0);
  ch = U0DBUF;
  URX0IF = 0;
  return ch;
}


void uart_test(void)
{
  unsigned char ch;
    ch = Uart_Recv_char();
    mo=ch;
//    Uart_Send_char(mo);    
  while(ch!=0x0A)
  {     
//    data[mo][recvCnt]=ch;
//    Uart_Send_char(ch);
//    Uart_Send_char(recvCnt);    
    recvBuf[recvCnt++] = ch;
//    printf("%d",recvCnt);
    ch = Uart_Recv_char();
  if (ch == 0X0D || recvCnt >= 256) {         //���ս���
    recvBuf[recvCnt] = 0;
//    Uart_Send_String("\r\n");
//    Uart_Send_String(recvBuf);
//    Uart_Send_String("\r\n");
//    recvCnt = 0;
  } 
//  
//  else {
//    recvBuf[recvCnt++] = ch;
//  }
  }//recvCnt = 0;
}

#pragma vector=URX0_VECTOR 
__interrupt void UART0_ISR(void)
{
  uart_test();  
//  printf("%u %u %u",data[mo][0],data[mo][1],data[mo][2]); 
//  Uart_Send_char(data[mo][0]);
  D7 = !D7;
  URX0IF=0;
//  temp=U0DBUF;  
} 


