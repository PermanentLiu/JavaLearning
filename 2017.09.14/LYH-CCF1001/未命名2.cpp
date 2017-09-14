#include <stdio.h>

int main(void)
{
	float input;
	scanf("%f", &input);
	
	printf("%.4f", ((input - 32) * 5 / 9));
	return 0;
}
