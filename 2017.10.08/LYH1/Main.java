import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class Main
{
	private Frame f = new Frame("TEST");
	
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
//	protected int a;
//	public int b;
//	default int c;
	public void init()
	{
		horizontal.add(new Button("horizontal 1"));
		horizontal.add(new Button("horizontal 2"));
		vertical.add(new Button("vertical 1"));
		vertical.add(new Button("vertical 2"));
		
		f.setVisible(true);
		f.pack();
		
		f.add(horizontal, BorderLayout.NORTH);
		f.add(vertical);
		
	}
	
	public static void main(String[] args)
	{
		new Main().init();
	}
	
}
