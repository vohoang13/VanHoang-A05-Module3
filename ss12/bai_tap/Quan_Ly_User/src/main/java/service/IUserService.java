package service;

import model.User;

import java.util.List;

public interface IUserService {
    public void addNew(User user);

    public List<User> findAll();

    public void deleteId(int id);

    public void update(User user);

    public List<User> sort();

    public List<User> searchByCountry(String country);
}