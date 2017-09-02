
public abstract class Car
{
	protected static String brand;
	
    public Car(String brand)
    {
    	Car.brand = brand;
    	introduction();
    	brand();
    }
    
    protected abstract void brand();
    
    protected void introduction()
    {
    	System.out.println("Hello , I'm the " + Car.brand);
    }
}
