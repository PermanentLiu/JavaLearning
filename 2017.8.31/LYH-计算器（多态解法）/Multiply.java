
public class Multiply extends Calculator
{
	private float x1;
	private float x2;
	private float result;
	
	public Multiply(float x1, float x2)
	{
		super(x1, x2);
		// TODO Auto-generated constructor stub
		this.x1 = x1;
		this.x2 = x2;
	}
	
	@Override
	public float back()
	{
		this.result = this.x1 * this.x2;
		
		return this.result;
	}

}
