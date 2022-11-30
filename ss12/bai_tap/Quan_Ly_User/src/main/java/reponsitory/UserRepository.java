package reponsitory;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private static final String SEARCH_BY_COUNTRY = "select * from users where country like ?";
    private static final String SORT_BY_NAME ="select * from users order by user_name;";
    private static final String UPDATE_FROM_ID = "update users set user_name = ?,email = ?,country = ? where id = ?;";
    private static final String DELETE_FROM_ID = "delete from users where id = ?;";
    private static final String SELECT_FROM_USER = "select * from users";
    private static final String INSERT_USER = "insert into users(id, user_name, email, country) value (?,?,?,?) ";
    private List<User> userList = new ArrayList<>();
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public void addNew(User user) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
//           Statement statement = connection.createStatement();
//           statement.executeUpdate("insert into student(code_student, name_student, gender, point) value ("+student.getCodeStudent()+","+student.getNameStudent()+")")
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
//            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
//            statement.executeQuery("select * from student");
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SELECT_FROM_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteId(int id) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FROM_ID);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> sort() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SEARCH_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findId(int id) {
        List<User> users = new ArrayList<>();
        String query = "{call findbyid(?)}";
            try(Connection connection = this.baseRepository.getConnectionJavaToDB();
                CallableStatement callableStatement = connection.prepareCall(query)
            ){
                callableStatement.setInt(1,id);
                ResultSet resultSet = callableStatement.executeQuery();
                User user;
                while (resultSet.next()){
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCountry(resultSet.getString("country"));
                    users.add(user);
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return users;
    }

    @Override
    public void updateByName(User user) {
        String query = "{call updatebyname(?,?,?)}";
        try(Connection connection = this.baseRepository.getConnectionJavaToDB();
                CallableStatement callableStatement = connection.prepareCall(query)
        ){
            callableStatement.setString(1,"%" + user.getName() + "%");
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void deleteByName(String name) {
        String query = "{call deleteuser(?)}";
        try(Connection connection = this.baseRepository.getConnectionJavaToDB();
            CallableStatement callableStatement = connection.prepareCall(query)
        ){
            callableStatement.setString(1,"%" + name + "%");
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


