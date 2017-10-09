import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;

import javax.swing.Box;

public class Main
{
	private Frame f = new Frame("Test");
	private TextArea textArea = new TextArea(6, 40);
	private Button button1 = new Button("Button 1");
	private Button button2 = new Button("Button 2");
	
	class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			textArea.append("\nThe fist ActionListener is acted, the source is: " + e.getActionCommand());
		}
	}
	
	class SecondListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			textArea.append("\nClicked the " + e.getActionCommand() + " button.");
		}
	}
	
	
	public void init()
	{
		FirstListener firstListener = new FirstListener();
		button1.addActionListener(firstListener);
		button1.addActionListener(new SecondListener());
		
		
		button2.addActionListener(firstListener);
		
		f.add(textArea);
		
		Panel panel = new Panel();
		
		panel.add(button1);
		panel.add(button2);

		f.add(panel, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Main().init();
	}
	
}
