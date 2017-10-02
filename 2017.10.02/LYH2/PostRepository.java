
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PostRepository
{
	private static ArrayList<Post> posts = new ArrayList<Post>();
//	Iterator<Post> iterator = posts.iterator();

    public static void add(Post post) 
    {
        posts.add(post);
    }

    public static void clear() 
    {
        posts.clear();
    }

    public static Post getPostById(long id) 
    {
        for (Post post : posts) 
        {
            if (post.getId() == id) 
            {
                return post;
            }
        }
        return null;
    }

    /**
     * 删除特定Id的博客
     * @param id
     */
    public static void remove(long id) 
    {
        // your code here
    	
    	for (int i = 0; i < posts.size(); i++)
    	{
    		if (id != posts.get(i).getId())
    		{
    			continue;
    		}
    		else
    		{
    			posts.remove(i);
    			return;
    		}
    	}
    }

    /**
     * 传入一个字符串，返回标题包含该字符串的所有博客
     * @param key
     * @return
     */
    public static List<Post> search(String key) 
    {
        // your code here
    	ArrayList<Post> arrayList = new ArrayList<>();
    	
    	
    	for (int i = 0; i < posts.size(); i++)
    	{
    		if (posts.get(i).getTitle().contains(key))
    		{
    			arrayList.add(posts.get(i));
    		}
    	}
    	

        return arrayList;
    }

    public static ArrayList<Post> getAll()
    {
        return posts;
    }
}
