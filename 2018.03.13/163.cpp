#include <stdio.h>
#include <math.h>

int main(void)
{
	int num;
	int length;
	int temp_length;
	int temp_num;
	int i; 
	int j;
	
	printf("Please input the number.\n");
	scanf("%d", &num);
	
	
	for (length = 0, temp_num = num; temp_num > 0; temp_num = temp_num / 10)
	{
		length++;
	}
	
	for (temp_num = num, temp_length = length; temp_length > 0; temp_length--)
	{

		printf("%d", temp_num % 10);
		
		temp_num = (temp_num - temp_num % 10) / 10;
	}
	
	return 0;
} 
