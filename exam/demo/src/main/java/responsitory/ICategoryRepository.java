package responsitory;

import model.Category;

import java.util.List;

public interface ICategoryRepository {
    public List<Category> findAll();

    public List<Category> findById(int id);
}
