public class HelloNative
{
	static
	{
		System.loadLibrary("Hello Native");
	}
	
	public static native void sayHello();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		new HelloNative().sayHello();
	}
}