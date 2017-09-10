class Dept
{
	private int deptno ;
	private String dname;
	private String loc;
	private Emp emps [];
	public void setEmps(Emp [] emps)
	{
		this.emps=emps;
	}
	public Emp[] getEmp()
	{
		return this.emps;
	}
	public Dept (int deptno , String dname , String loc)
	{
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public String getInfo()
	{
		return "部门编号："+this.deptno+",名称："+this.dname+",位置："+this.loc;
	}
}
class Emp
{
	private int empno;
	private String ename ;
	private String job;
	private double sal;
	private double comm;
	private Dept dept;//表示对应部门的信息
	private Emp mgr;//表示雇员对应的领导
	public void setMgr(Emp mgr)
	{
		this.mgr =mgr;
	}
	public Emp getMgr()
	{
		return this.mgr;
	}
	void setDept(Dept dept)
	{
		this.dept =dept;
	}
	public Dept getDept()
	{
		return this.dept;
	}
	
	
	public Emp(int empno , String ename ,String job , double sal ,double comm )
	{
		this.empno=empno;
		this.ename=ename;
		this.job=job;
		this.sal=sal;
		this.comm=comm;
	}
	public String getInfo()
	{
		return "雇员编号 "+this.empno+"姓名 "+this.ename+"职位 "+this.job+"薪水 "+this.sal+"佣金 "+this.comm;
	}
}
public class TextDemo {
	public static void main(String args[])
	{
		//设置数据
		//1.产生各自的独立对象
		Dept dept = new Dept (10,"ACCOUNTING","New York");//部门信息
		Emp ea = new Emp(0001,"lyh","Manger",800.0,0.0);
		Emp eb = new Emp(0002,"fly","Assistant",900.0,0.0);
		Emp ec = new Emp(0003,"zhb","Clean",500.0,0.0);
		Emp ed = new Emp(0004,"ssy","Clerk",800.0,0.0);
		//2.设置雇员和领导的关系
		ea.setMgr(eb);
		eb.setMgr(ec);
		//3.设置雇员和部门的关系
		ea.setDept(dept) ;  // 雇员与部门
		eb.setDept(dept) ;
		ec.setDept(dept) ;
		ed.setDept(dept) ;
		dept.setEmps(new Emp[]{ea,eb,ec,ed});
		//第二部：取出数据
		//1.通过雇员找到领导信息和部门信息
		System.out.println("\t|-"+ea.getInfo());
		System.out.println("领导\t|-"+ea.getMgr().getInfo());
		System.out.println("\t|-"+ea.getDept().getInfo());
		//2.根据部门找到所有雇员并且找到所有雇员与领导的信息
		System.out.println("----------------------------");
		System.out.println(dept.getInfo());
		System.out.println("\n");
		for(int x = 0 ; x<dept.getEmp().length;x++)
		{    
			System.out.println(dept.getEmp()[x].getInfo());
		   if(dept.getEmp()[x].getMgr()!=null)
			{
			   System.out.println("他的领导：");
			   System.out.println(dept.getEmp()[x].getMgr().getInfo());
			}
		   System.out.println("\n");
		}
		
	}
}
