import java.lang.reflect.Array;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		int data[] = new int[]{2, 6, 5, 9, 8, 1, 5, 0, 4};
		int temp[] = new int[]{11, 22, 33, 44, 55, 66};
		
		Arrays.sort(data);//ÉıĞòÅÅÁĞ
		for (int i = 0; i < data.length; i++)//Ã°Åİ ½µĞòÅÅÁĞ
		{
			for (int j = i; j < data.length; j++)
			{
				if (data[i] < data[j])
				{
					int t = data[i];
					data[i] = data[j];
					data[j] = t;
				}
			}
		}
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
		
		System.arraycopy(data, 3, temp, 2, 2);
		for (int i = 0; i < temp.length; i++)
		{
			System.out.print(temp[i] + " ");
		}
	}
}
