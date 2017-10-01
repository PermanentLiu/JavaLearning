
public class Post
{
		private Long id;
	    private String title;
	    private String content;
	    // your code here
	    private static String DEFAULT_TITLE= "这是一篇未命名博客";
	
	    public String getContent() {
	        return content;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public String getTitle() {
	        return title;
	    }
	
	    public Post() {
	        // your code here
	    	if (this.title == null || this.title.trim().isEmpty())
	    	{
	    		this.title = DEFAULT_TITLE;
	    	}
	    }
	
	    public Post(String title, String content) {
	        // your code here
	        this.title = title;
	        this.content = content;
	        if (this.title == null || this.title.trim().isEmpty())
	        {
	        	this.title = DEFAULT_TITLE;
	        }
	    }
	
	    public Post(Long id, String title, String content) {
	        // your code here
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        if (this.title == null || this.title.trim().isEmpty())
	        {
	        	this.title = DEFAULT_TITLE;
	        }
	    }
	
	    public void print() {
	        System.out.println(this.id);
	        System.out.println(this.title);
	        System.out.println(this.content);
	    }
	
	    public static Post[] sortById(Post[] posts) {
	        // your code here
	    	
	    	for (int i = 0; i < posts.length; i++)
	    	{
	    		for (int j = i; j < posts.length; j++)
	    		{
	    			if (posts[i].id > posts[j].id)
	    			{
	    				long temp;
	    				temp = posts[i].id;
	    				posts[i].id = posts[j].id;
	    				posts[j].id = temp;
	    			}
	    		}
	    	}
	    	
	        return posts;
	    }
	
	    public static Post[] sortByTitle(Post[] posts) {
	        // your code here
	    	
	    	for (int i = 0; i < posts.length; i++)
	    	{
	    		for (int j = 0; j < posts.length; j++)
	    		{
	    			if ((posts[i].title.compareTo(posts[j].title)) < 0)
	    			{
	    				String temp;
	    				temp = posts[i].title;
	    				posts[i].title = posts[j].title;
	    				posts[j].title = temp;
	    			}
	    		}
	    	}
	
	        return posts;
	    }
	    
}
