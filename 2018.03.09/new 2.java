//������֪���ж��ٸ�Ԫ�ص�����

public class ArrayNew
{
	public static void main(String[] args
	{
		int[] a;
		
		Random rand = new Random();
		a = new int[rand.nextInt(20)];
		
		System.out.println("length of a = " + a.length);
		System.out.println(Arrays.toString(a));
	)
}

//output:
//length of a = 18
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]