
public class Main
{
	public static void main(String[] args)
	{
		int sum = 0;//总素数个数
		int temp = 0;//因子的个数
		
		for (int i = 101; i <= 200; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				if ((i % j) == 0)
				{
					temp++;
				}
			}
			if (temp == 2)//只有两个因子的数为素数
			{
				sum++;
				System.out.println(i);
			}
			temp = 0;//千万别忘了清零
//			sum = 0;
		}
		System.out.println("The total is " + sum);
	}
}
