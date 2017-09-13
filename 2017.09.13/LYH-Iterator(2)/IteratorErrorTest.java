import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorErrorTest
{
	public static void main(String[] args)
	{
		Collection books = new HashSet<>();
		books.add("轻量级Javaee企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");
		
		books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
		
		System.out.println();
		
		Iterator iterator = books.iterator();
		iterator.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));
		
		System.out.println();
		
		Iterator it = books.iterator();
		while (it.hasNext())
		{
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("疯狂Java讲义"))
			{
				it.remove();
			}
			book = "测试字符串";
			
		}
		System.out.println();
		System.out.println(books);
	}
}
