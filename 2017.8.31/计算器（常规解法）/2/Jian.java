
public class Jian
{
	private int x1;
	private int x2;
	private int y;
	
	public void getNumber(int getX1, int getX2)
	{
		x1 = getX1;
		x2 = getX2;
		deal();
	}
	public int setNumber()
	{
		return y;
	}
	
	public void deal()
	{
		y = x1 - x2;
	}
}
