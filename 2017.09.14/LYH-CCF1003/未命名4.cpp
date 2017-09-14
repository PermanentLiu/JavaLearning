#include <stdio.h>

int main(void)
{
	int input;
	
	scanf("%d", &input);
	
	int temp = input*7*11*13;
	
	printf("%d", temp/7/11/13);
	
	return 0;
}
