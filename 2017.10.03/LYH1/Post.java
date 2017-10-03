public class Post {

    protected Long id;
    protected String title;
    protected String content;

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void print() {
        System.out.println(id);
        System.out.println(title);
        System.out.println(content);
    }
}










