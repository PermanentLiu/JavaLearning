import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

public class Main
{
	public static void main(String[] args)
	{
		Frame frame = new Frame("TestWindow");
		frame.setVisible(true);
		frame.setSize(1500, 1200);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 50));
		for (int i = 0; i < 10; i++)
		{
			frame.add(new Button("Button" + i));
		}
		
		frame.pack();
		
		ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		scrollPane.add(new TextField(20));
		scrollPane.add(new Button("Click Me"));
		
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.add(new TextField(20));
		panel.add(new Button("Click Me"));
		panel.add(scrollPane);
		
		
		Label label = new Label("Hello Java");
		
		frame.add(label);
		frame.add(panel);
//		frame.add(scrollPane);
	}
}
