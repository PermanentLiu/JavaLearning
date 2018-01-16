#include <stdio.h>

int main(void)
{
	int i;
	int sum;
	int n;
	
	while(~scanf("%d", &n))
	{
		sum = 0;
		
		for (i = 1; i <= n; i++)
		{
			sum += i;
		}
		
		printf("%d\n\n", sum);
	}

	
	return 0;
}
