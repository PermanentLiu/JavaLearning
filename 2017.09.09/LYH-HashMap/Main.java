import java.util.HashMap;

public class Main
{
	public static void main(String[] args)
	{
		HashMap hashMap = new HashMap();
		hashMap.put("a","12345");
		hashMap.put("b", 1);
		hashMap.put("c", 'r');
		hashMap.put(1, "qwe");
		hashMap.put('z', "hello");
		
		System.out.println(hashMap.containsKey("c"));
		System.out.println(hashMap.containsValue(1));
		
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.entrySet());
		System.out.println(hashMap.size());
		System.out.println(hashMap.values());
		System.out.println(hashMap.replace(1, "qwe", "abc"));
		System.out.println(hashMap.get(1));
	}
}
