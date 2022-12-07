package responsitory;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepository implements ICategoryRepository{
    private List<Category> categoryList = new ArrayList<>();
     private final String SELECT_CATEGORY = "select * from category";

     private final String SELECT_ID = "select * from category where id = ?";
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()){
                category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                categories.add(category);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Category> findById(int id) {
        List<Category> categories = new ArrayList<>();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()){
                category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                categories.add(category);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
