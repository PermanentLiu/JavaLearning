#include "myalg.h"

/*���ַ������м��ȡlength���ַ�*/
//src:Ҫ��ȡ���ַ���
//dest:���ַ���
//startIndex:���ַ�������ʼ�ַ�λ�ã����㿪ʼ����
//ength:���ַ����е��ַ�����
void SubString(u8 *dest, u8 *src, int startIndex, int length)
{
	u8 *p = src;
	u8 *q = dest;
	int len = strlen((char*)src);
	if (length>len) length = len - startIndex;    /*�ӵ�startIndex�������*/
	if (startIndex<0) startIndex = 0;    /*�ӵ�һ����ʼ*/
	//if (startIndex>len) return NULL;
	p += startIndex;
	while (length--) *(q++) = *(p++);
	*(q++) = '\0';
}

//find string in string, return the first start location or -1 if can not find  
int String_IndexOf(const u8 *pSrc, const u8 *pDst)
{
	int i, j;
	for (i = 0; pSrc[i] != '\0'&&pSrc[i+2] != '\0'; i++)
	{
		if (pSrc[i] != pDst[0])
			continue;
		j = 0;
		while (pDst[j] != '\0' && pSrc[i + j] != '\0')
		{
			j++;
			if (pDst[j] != pSrc[i + j])
				break;
		}
		if (pDst[j] == '\0')
			return i;
	}
	return -1;
}
//���ַ������м��ȡ����start�ַ�����ͷ��end�ַ�����β�ĵ�������start��end���ַ���
//src:Ҫ��ȡ���ַ���
//dest:���ַ���
void My_SubString(u8* src, u8* dest,u8* start, u8* end)
{
	SubString(dest,src,String_IndexOf(src,start)+strlen((char*)start), String_IndexOf(src, end)- (String_IndexOf(src, start)+strlen((char*)start)));
}

//���ַ���ת����������
int str2int(const char *str)
{
	int temp = 0;
	const char *ptr = str;  //ptr����str�ַ�����ͷ

	if (*str == '-' || *str == '+')  //�����һ���ַ��������ţ�
	{                      //���Ƶ���һ���ַ�
		str++;
	}
	while (*str != 0)
	{
		if ((*str < '0') || (*str > '9'))  //�����ǰ�ַ���������
		{                       //���˳�ѭ��
			break;
		}
		temp = temp * 10 + (*str - '0'); //�����ǰ�ַ��������������ֵ
		str++;      //�Ƶ���һ���ַ�
	}
	if (*ptr == '-')     //����ַ������ԡ�-����ͷ����ת�������෴��
	{
		temp = -temp;
	}

	return temp;
}

