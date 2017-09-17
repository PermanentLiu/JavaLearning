import java.awt.Button;
import java.awt.Frame;

import javax.swing.BoxLayout;

public class Main
{
	public static void main(String[] args)
	{
		new Main().init();
	}
	
	private Frame frame = new Frame("Test");
	public void init()
	{
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		frame.add(new Button("First Button"));
		frame.add(new Button("Second Button"));
		frame.setVisible(true);
		frame.pack();
	}
}
