package service;

import model.Category;
import responsitory.CategoryRepository;
import responsitory.ICategoryRepository;

import java.util.List;

public class CategoryService implements  ICategoryService{
    ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public List<Category> findById(int id) {
        return iCategoryRepository.findById(id);
    }
}
