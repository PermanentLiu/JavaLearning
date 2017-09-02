
public class Main
{
	public static void main(String[] args)
    {
    	FrontDoor frontDoor = new FrontDoor();
    	frontDoor.open();
    	frontDoor.alarm();
    	System.out.println();
    	
    	BackDoor backDoor = new BackDoor();
    	backDoor.close();
    	System.out.println();
    	
    	MiddleDoor middleDoor = new MiddleDoor();
    	middleDoor.alarm();
    	System.out.println();
    	
    	String Koenigsegg = "Koenigsegg";
		MyCar myCar = new MyCar(Koenigsegg);
		myCar.introduction();
    }
}
class FrontDoor extends Door implements Alarm
{
	static String Front = "Front";

	public FrontDoor()
	{
		super(Front);
	}

	@Override
	public void alarm()
	{
		// TODO Auto-generated method stub
		System.out.println("Woooooooooooooo~~~~~~~~~~~");
	}

	@Override
	protected void location()
	{
		// TODO Auto-generated method stub
		System.out.println("I'm at the Front");
	}
	
}

class BackDoor extends Door
{

	static String Front = "Back";

	public BackDoor()
	{
		super(Front);
	}


	@Override
	protected void location()
	{
		// TODO Auto-generated method stub
		System.out.println("I'm at the Front");
	}
}

class MiddleDoor implements Alarm
{

	@Override
	public void alarm()
	{
		// TODO Auto-generated method stub
		System.out.println("Middle door wowawowawowawowa!!!!");
	}
	
}

class MyCar extends Car implements Alarm
{

	public MyCar(String Koenigsegg)
	{
		super(brand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alarm()
	{
		// TODO Auto-generated method stub
		System.out.println("The car is alarm inginginginging");
	}

	@Override
	protected void brand()
	{
		// TODO Auto-generated method stub
		System.out.println("Koenigsegg is an expensive car");
		System.out.println("And it is very fast!");
	}
	
}