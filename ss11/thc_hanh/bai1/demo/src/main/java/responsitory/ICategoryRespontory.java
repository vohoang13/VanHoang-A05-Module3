package responsitory;

import model.Category;

import java.util.List;

public interface ICategoryRespontory {
    public List<Category> findAll();

    public Category findById(String id);

}
