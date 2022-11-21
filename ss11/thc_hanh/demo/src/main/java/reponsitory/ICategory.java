package reponsitory;

import model.Category;

import java.util.List;

public interface ICategory {
    public Category findById(String id);

    public List<Category> findAll();

}
