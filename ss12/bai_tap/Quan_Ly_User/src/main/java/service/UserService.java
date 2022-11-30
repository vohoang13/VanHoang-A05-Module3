package service;

import model.User;
import reponsitory.IUserRepository;
import reponsitory.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository = new UserRepository();
    @Override
    public void addNew(User user) {
        userRepository.addNew(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteId(int id) {
        userRepository.deleteId(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public List<User> sort() {
        return userRepository.sort();
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepository.searchByCountry(country);
    }

    @Override
    public List<User> findID(int id) {
        return userRepository.findId(id);
    }

    @Override
    public void updateByName(User user) {
        userRepository.updateByName(user);
    }

    @Override
    public void deleteByName(String name) {
        userRepository.deleteByName(name);
    }
}
