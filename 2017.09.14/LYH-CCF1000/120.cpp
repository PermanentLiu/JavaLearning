#include <stdio.h>
int main(void)
{
	char temp = getchar();

	printf("%c", ('a'+'z'-temp));

	
	return 0;
} 
