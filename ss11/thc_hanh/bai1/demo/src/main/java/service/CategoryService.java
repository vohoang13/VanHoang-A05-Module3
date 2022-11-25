package service;

import model.Category;
import responsitory.CategoryRespontory;
import responsitory.ICategoryRespontory;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRespontory categoryRespontory = new CategoryRespontory();
    @Override
    public List<Category> findAll() {
        return categoryRespontory.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryRespontory.findById(id);
    }
}
