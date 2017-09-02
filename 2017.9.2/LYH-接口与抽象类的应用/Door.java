
public abstract class Door
{
	protected static String location;
	
	public Door(String location)
	{
		setLocation(location);
	}
	
	protected abstract void location();
	
	private void setLocation(String location)
	{
		Door.location = location;
	}
	
	protected void open()
	{
		System.out.println("This " + Door.location + " door is opened!");
	}
	
	protected void close()
	{
		System.out.println("This " + Door.location + " door is closed!");
	}
}
