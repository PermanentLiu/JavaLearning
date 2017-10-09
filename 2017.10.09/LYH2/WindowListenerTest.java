import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest
{
	private Frame frame = new Frame("Test");
	private TextArea textArea = new TextArea(6, 40);
	
	class MyListener implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口被激活！");
			
		}

		@Override
		public void windowClosed(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口被成功关闭！");
		}

		@Override
		public void windowClosing(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n用户关闭窗口！");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口失去焦点！");
		}

		@Override
		public void windowDeiconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口被恢复！");
		}

		@Override
		public void windowIconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口被最小化！");
		}

		@Override
		public void windowOpened(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n窗口被初次打开！");
		}
		
	}
	
	
	public void init()
	{
		frame.addWindowListener(new MyListener());
		
		frame.add(textArea);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new WindowListenerTest().init();
	}
}
