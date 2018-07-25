#ifndef __MYALG_H
#define __MYALG_H	 
#include "sys.h"	
#include "string.h"
	
void SubString(u8 *dest, u8 *src, int startIndex, int length);
void My_SubString(u8* src, u8* dest,u8* start, u8* end);
void num2str(u16 num,u8 *buf,u8 len);
int String_IndexOf(const u8 *pSrc, const u8 *pDst);
int str2int(const char *str);

#endif
