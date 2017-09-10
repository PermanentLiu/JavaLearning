class Member
{
	private int mid ;
	private String name;
	//car有实例化对象表示有车
	//car为null表示没有车
	private Car car;//表示属于人的车
    public Member(int mid ,String name)
	{
		this.mid = mid;
		this.name = name ;
	}

	public String getInfo()
	{
       return "人员编号："+ this.mid +"，姓名 ；"+ this.name ;
	}
	public Car getCar()
	{
		return this.car;
	}
	public void setCar(Car car)
	{
		this.car = car ;
	}
}
class Car
{
	private Member member; //车属于一个人
	private String pname;
	Car(String pname)
	{
	  this.pname = pname;
	}
	public String getInfo()
	{
		return "车的名字：" + this.pname;
	}
	public void setMember (Member member)
	{
		this.member = member;
	}
	public Member getMember()
	{
		return this.member;
	}
}//member和car都是独立产生然后再产生关系
public class Lyhhlj
{
	public static void main (String args[])
	{
		//第一步 设置数据
		Member m = new Member (1 , "刘永蘅");//独立对象
		Car c = new Car("宝马z4");//独立对象
		m.setCar (c);//一个人有一辆车
		c.setMember(m);//一辆车属于一个人
		//第二部 取出关系
		//通过人找到车的关系
		System.out.println(m.getCar().getInfo());
		System.out.println(c.getMember().getInfo());
	}
}