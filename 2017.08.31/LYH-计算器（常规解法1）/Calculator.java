import java.text.DecimalFormat;

public class Calculator
{
	private int x1;
	private int x2;
	private int result;
	private char op;
	
	public Calculator()
	{
		// TODO Auto-generated constructor stub
	}
	public Calculator(int x1, int x2, char op)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.op = op;
		deal();
	}
	
	private void deal()
	{
		switch (this.op)
		{
		case '+':
			result = x1 + x2;
			break;
		case '-':
			result = x1 - x2;
			break;
		case '*':
			result = x1 * x2;
			break;
		case '/':
			result = x1 / x2;
			break;
		default:
			System.out.println("Error input!");
			System.out.println("Please input again");
			break;
		}
	}
	
	public int getResult()
	{
		return this.result;
	}
}
