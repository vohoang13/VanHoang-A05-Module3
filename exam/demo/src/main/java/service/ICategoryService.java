package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();

    public List<Category> findById(int id);
}
