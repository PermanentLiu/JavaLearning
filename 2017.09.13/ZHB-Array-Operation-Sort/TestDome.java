class Array
{
	private int data[];
	private int foot;
	public Array (int length)
	{
		if(length > 0 )
		{
			this.data = new int [length];
		}
		else
		{
			this.data = new int [1];
		}
	}
	public boolean add(int number) 
	{
		if(this.foot < this.data.length)
		{
			this.data[this.foot ++] = number;
			return true;
		}
		return false;
	}
	public int []  getData ()
	{
		return this.data; 
	}
}
class SortArray extends Array
{
    //Array 类中现在现在没有无参构造方法
	public SortArray(int length) {
		super(length);
		//明确的调用父类的有参构造：目的是父类中的Data 数组就可以初始化
	}
	public int []getData()//因为父类中的getData()方法不够用啦，所以使用覆写的方式来补充
	{
	   java.util.Arrays.sort(super.getData());
	   return super.getData();
	}
   	
}
public class TestDome 
{
     public static void main (String args[])
     {
    	 Array arr = new SortArray(4);
    	 arr.add(4);
    	 arr.add(2);
    	 arr.add(1);
    	 arr.add(3); 
    	 int [] temp = arr.getData() ;
    	 for (int x = 0 ;  x < temp.length;x++)
    	 {
    		 System.out.println(temp[x]);
    	 }
     }
}
