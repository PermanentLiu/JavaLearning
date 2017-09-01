
public class Devide extends Calculator
{
	private float x1;
	private float x2;
	private float result;
	
	@Override
	public float operate(float x1, float x2)
	{
		this.x1 = x1;
		this.x2 = x2;
		
		this.result = this.x1 / this.x2;
		
		return this.result;
	}
}
