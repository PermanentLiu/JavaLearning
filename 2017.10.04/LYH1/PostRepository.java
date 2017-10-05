import java.util.List;

public interface PostRepository {

    void add(Post post);

    Post getPostById(long id);

    void remove(long id);

    List<Post> getAll();

    void loadData();

    void saveData();
}