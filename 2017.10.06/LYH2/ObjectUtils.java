public class ObjectUtils {
    
    /**
     * 将source的属性拷贝到target中
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) 
    {
        // your code here
    }
    
    public static void main(String[] args)
    {
        User source = new User(1);
        source.setName("tianmaying");
        User target = new User(2);
        System.out.println("sourse is: " + source);
        System.out.println("target is: " + target);
        copyProperties(source, target);
        System.out.println("target is: " + target);
    }

}
