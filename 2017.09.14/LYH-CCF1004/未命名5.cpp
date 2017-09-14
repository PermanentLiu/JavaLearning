#include <stdio.h>

int main(void)
{
	long long int n, m, a;
	scanf("%lld %lld %lld", &n, &m, &a);
	
	printf("%d", ((n / a) * (m / a)));
	
	return 0;
} 
