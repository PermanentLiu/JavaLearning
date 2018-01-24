import java.security.cert.TrustAnchor;
import java.security.spec.ECFieldF2m;
import java.util.Scanner;

import javax.swing.plaf.BorderUIResource.LineBorderUIResource;

public class Main
{
	public static void main(String[] args)
	{
		ClassA classA = new ClassA();
		ClassB classB = new ClassB();
		classA.start();
		classB.start();
		
		
		int a = 100;
		while (true)
		{
			a += a;
			System.out.println("Ö÷Ïß³Ì£º" + a);
			try
			{
				Thread.sleep(2000);
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				System.out.println("Error");
			}
		}
		
	}
}
