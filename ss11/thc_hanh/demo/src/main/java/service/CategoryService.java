package service;

import model.Category;
import reponsitory.CategoryResponsitoryImpl;
import reponsitory.ICategory;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategory category = new CategoryResponsitoryImpl();
    @Override
    public Category findById(String id) {
        return category.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return category.findAll();
    }
}
