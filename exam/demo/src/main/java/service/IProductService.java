package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public void addNew(Product product);

    public List<Product> findAll();

    public void deleteId(int id);

    public void editId(Product product);

    public Product findById(int id) throws SQLException;
}
