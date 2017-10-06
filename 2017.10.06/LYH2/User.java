public class User 
{

    private Integer id;
    private String name;

    public User(Integer id)
    {
        super();
        this.id = id;
    }
    public Integer getId()
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    @Override
    public String toString() 
    {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
