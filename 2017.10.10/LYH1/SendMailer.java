import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

public class SendMailer
{
	private Frame frame = new Frame("Test");
	private TextField textField = new TextField(40);
	private Button send = new Button("Send");
	
	public void init()
	{
		send.addActionListener(new MailerListener(textField));
		
		frame.add(textField);
		frame.add(send, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SendMailer().init();
	}
}
