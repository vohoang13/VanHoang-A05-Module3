package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    public Category findById(String id);

    public List<Category> findAll();

}
