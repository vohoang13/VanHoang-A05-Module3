package responsitory;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SORT = "select * from product order by product_id desc";
    private final String FIND_ID_COLOR = "select * from product where color like ? and category_id = ?";
    private final String FIND_ID = "select * from product where product_id = ?";
    private final String UPDATE_FRODUCT_ID = "update product set product_name = ?, product_price = ?, amount = ?, color = ?, descriptions = ?,category_id = ? where product_id = ?";
    private final String DELETE_PRODUCT_ID = "delete from product where product_id = ?";
    private final String SELECT_PRODUCT = "select * from product";
    private final String INSERT_PRODUCT = "insert into product(product_id, product_name, product_price, amount, color, descriptions,category_id) value (?,?,?,?,?,?,?)";
    BaseRepository baseRepository = new BaseRepository();

    List<Product> productList = new ArrayList<>();

    @Override
    public void addNew(Product product) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setInt(4, product.getAmount());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescriptions());
            preparedStatement.setInt(7, product.getIdCategory());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList1 = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getFloat("product_price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setColor(resultSet.getString("color"));
                product.setDescriptions(resultSet.getString("descriptions"));
                product.setIdCategory(resultSet.getInt("category_id"));
                productList1.add(product);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList1;
    }

    @Override
    public void deleteId(int id) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editId(Product product) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FRODUCT_ID);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescriptions());
            preparedStatement.setInt(6,product.getIdCategory());
            preparedStatement.setInt(7,product.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product = new Product();
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            product.setId(resultSet.getInt("product_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getFloat("product_price"));
            product.setAmount(resultSet.getInt("amount"));
            product.setColor(resultSet.getString("color"));
            product.setDescriptions(resultSet.getString("descriptions"));
            product.setIdCategory(resultSet.getInt("category_id"));
        }
        resultSet.close();
        connection.close();
        return product;
    }

    @Override
    public List<Product> search(String color, int idCategory) {
        List<Product> productList1 = new ArrayList<>();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_COLOR);
            preparedStatement.setString(1,"%" + color + "%");
            preparedStatement.setInt(2,idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()){
                product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getFloat("product_price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setColor(resultSet.getString("color"));
                product.setDescriptions(resultSet.getString("descriptions"));
                product.setIdCategory(resultSet.getInt("category_id"));
                productList1.add(product);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList1;
    }

    @Override
    public  List<Product> sort() {
        List<Product> productList1 = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SORT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getFloat("product_price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setColor(resultSet.getString("color"));
                product.setDescriptions(resultSet.getString("descriptions"));
                product.setIdCategory(resultSet.getInt("category_id"));
                productList1.add(product);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList1;
    }
}
