import java.util.stream.IntStream;

public class Main
{
	public static void main(String[] args)
	{
		String string = "LiuYongHeng";
//		Character[] str = new Character[];
		IntStream c;
//		int hcstring = 0;
		
		System.out.println(string.getClass().getName());
		System.out.println(string.getClass().getSimpleName());
		
		String string2 = "luojialin";
		
		System.out.println(string.equalsIgnoreCase(string2));
		
		System.out.println(string.hashCode());
		c = string.chars();
		System.out.println(c);
		System.out.println("******************");
		System.out.println(string.codePointAt(2));
		System.out.println(string.codePointBefore(2));
		System.out.println(string.codePointCount(2, 5));
		System.out.println(string.intern());
		System.out.println(string.substring(3));
		System.out.println(string.substring(3, 7));
		System.out.println(string.concat(string2));
		System.out.println(string.trim());//È¥³ýÁ½¶Ë¿Õ°×
		System.out.println(string.replaceFirst("Liu", "123"));
		System.out.println(string.toLowerCase());
		System.out.println(string.toUpperCase());
		System.out.println(string.matches("LiuYongheng"));
		System.out.println(string.endsWith("eng"));
		System.out.println(string.join(string2, null));
		
		
	}
}
