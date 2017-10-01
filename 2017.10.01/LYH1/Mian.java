
public class Mian
{
	public static void main(String[] args)
	{
		String str1 = "liuyongheng";
		
		
		//search
		System.out.println(str1.indexOf("ng"));
		System.out.println(str1.indexOf('n'));
		System.out.println(str1.lastIndexOf('n'));
		System.out.println(str1.lastIndexOf("heng"));
		System.out.println(str1.startsWith("liuy"));
		System.out.println(str1.endsWith("nng"));
		System.out.println(str1.contains("gh"));
		
		
		//replace
		System.out.println(str1.replace('n', 'q'));
		System.out.println(str1.replace("iuyongheng", "uojialiin"));
		
		//sub
		System.out.println(str1.substring(3, 7));
		
		String str2 = "    l iu yong h e n     g  ";
		System.out.println(str2);
		System.out.println(str2.trim());
		
		
		System.out.println("//////////////////////////////////");
		
		
		
		StringBuffer strb1 = new StringBuffer();
		strb1.append("liu");
		strb1.append('Y');
		strb1.append(str1);
		strb1.append(strb1);
		System.out.println(strb1);
		System.out.println(strb1.length());
		System.out.println(strb1.reverse());
		strb1.setCharAt(1, 'z');
		System.out.println(strb1);
		char[] array = new char[40];
		strb1.getChars(3, 8, array, 0);
		for (int i = 0; i <= 5; i++)
		{
			System.out.print(" " + array[i]);
		}
		
		
	}
}
