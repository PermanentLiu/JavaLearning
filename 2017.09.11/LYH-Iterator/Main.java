import java.awt.List;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList list = new ArrayList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		
		for (Iterator iter = (Iterator) list.iterator();; iter.next())
		{
			System.out.println(iter);
		}
		
	}
}
