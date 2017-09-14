#include <stdio.h>
#include <math.h> 

int main(void)
{
	float a, b, c, S;
	scanf("%f %f %f", &a ,&b, &c);
	

	printf("%.4f", (sqrt(((a+b+c)/2)*(((a+b+c)/2)-a)*(((a+b+c)/2)-b)*(((a+b+c)/2)-c)))); 	
	return 0;
}
