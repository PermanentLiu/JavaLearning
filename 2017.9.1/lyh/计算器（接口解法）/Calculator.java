
public class Calculator implements Operation
{
	private float result;
	private float x1;
	private float x2;

	@Override
	public void Add(float x1, float x2)
	{
		// TODO Auto-generated method stub
		this.x1 = x1;
		this.x2 = x2;
		
		this.result = this.x1 + this.x2;
		outPut();
	}

	@Override
	public void Minus(float x1, float x2)
	{
		// TODO Auto-generated method stub
		this.x1 = x1;
		this.x2 = x2;
		
		this.result = this.x1 + this.x2;
		outPut();
	}

	@Override
	public void Multiply(float x1, float x2)
	{
		// TODO Auto-generated method stub
		this.x1 = x1;
		this.x2 = x2;
		
		this.result = this.x1 + this.x2;
		outPut();
	}

	@Override
	public void Devide(float x1, float x2)
	{
		// TODO Auto-generated method stub
		this.x1 = x1;
		this.x2 = x2;
		
		this.result = this.x1 / this.x2;
		outPut();
	}
	
	
	private void outPut()
	{
		System.out.println("The result is " + this.result);
	}
}
