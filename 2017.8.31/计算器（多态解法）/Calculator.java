import javax.print.attribute.standard.RequestingUserName;

public class Calculator
{
	private float x1;
	private float x2;
	private float result;
	private char temp;
	
	public Calculator(float x1, float x2)
	{
		this.x1 = x1;
		this.x2 = x2;
//		this.temp = temp;
	}
	protected float back()
	{
		System.out.println("Error input!");
		System.out.println("Please input again!");
		return result;
	}
}
