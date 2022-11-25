package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();

    public Category findById(String id);

}
