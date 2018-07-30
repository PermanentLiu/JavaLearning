#include "myalg.h"

/*从字符串的中间截取length个字符*/
//src:要截取的字符串
//dest:子字符串
//startIndex:子字符串的起始字符位置（从零开始）。
//ength:子字符串中的字符数。
void SubString(u8 *dest, u8 *src, int startIndex, int length)
{
	u8 *p = src;
	u8 *q = dest;
	int len = strlen((char*)src);
	if (length>len) length = len - startIndex;    /*从第startIndex个到最后*/
	if (startIndex<0) startIndex = 0;    /*从第一个开始*/
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
//从字符串的中间截取在以start字符串开头和end字符串结尾的但不包含start和end的字符串
//src:要截取的字符串
//dest:子字符串
void My_SubString(u8* src, u8* dest,u8* start, u8* end)
{
	SubString(dest,src,String_IndexOf(src,start)+strlen((char*)start), String_IndexOf(src, end)- (String_IndexOf(src, start)+strlen((char*)start)));
}

//把字符串转换成整型数
int str2int(const char *str)
{
	int temp = 0;
	const char *ptr = str;  //ptr保存str字符串开头

	if (*str == '-' || *str == '+')  //如果第一个字符是正负号，
	{                      //则移到下一个字符
		str++;
	}
	while (*str != 0)
	{
		if ((*str < '0') || (*str > '9'))  //如果当前字符不是数字
		{                       //则退出循环
			break;
		}
		temp = temp * 10 + (*str - '0'); //如果当前字符是数字则计算数值
		str++;      //移到下一个字符
	}
	if (*ptr == '-')     //如果字符串是以“-”开头，则转换成其相反数
	{
		temp = -temp;
	}

	return temp;
}

