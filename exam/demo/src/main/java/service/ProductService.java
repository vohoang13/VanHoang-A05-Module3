package service;

import model.Product;
import responsitory.IProductRepository;
import responsitory.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public void addNew(Product product) {
        iProductRepository.addNew(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void deleteId(int id) {
        iProductRepository.deleteId(id);
    }

    @Override
    public Product findById(int id) throws SQLException {
        return iProductRepository.findById(id);
    }

    @Override
    public void editId(Product product) {
        iProductRepository.editId(product);
    }
}
