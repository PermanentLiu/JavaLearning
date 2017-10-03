public class HelloWorld {

    public static void main(String args[]) {
        Post post = new TmyPost((long) 100,"天码营的博客", "这是我的第一篇博客"); // 创建博客对象
        post.print();
    }
}
