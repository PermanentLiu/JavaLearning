import java.util.Arrays;
import java.util.Comparator;

public class Post {

    private Long id;
    public String title;
    private String content;
    private static String DEFAULT_TITLE = "这是一篇未命名博客";

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
        this.title = DEFAULT_TITLE;
    }

    public Post(String title, String content) {
        if (title == null || title.trim().isEmpty()) {
            title = DEFAULT_TITLE;
        }

        this.title = title;
        this.content = content;
    }

    public Post(Long id, String title, String content) {
        if (title == null || title.trim().isEmpty()) {
            title = DEFAULT_TITLE;
        }
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void print() {
        System.out.println(this.id);
        System.out.println(this.title);
        System.out.println(this.content);
    }

    public static Post[] sortById(Post[] posts) {
        Arrays.sort(posts, new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                return o1.getId() < o2.getId() ? -1 : 1;
            }
        });

        return posts;
    }

    public static Post[] sortByTitle(Post[] posts) {
        Arrays.sort(posts, new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return posts;
    }
}
