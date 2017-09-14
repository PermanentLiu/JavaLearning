#include <stdio.h>
#include <math.h>

int main(void)
{
	float R, X, P;
	
	scanf("%f %f %f", &R, &X, &P);
	
	printf("%.2f", X * (pow(((100 + R) / 100), P)));
	
	
	return 0;
}
