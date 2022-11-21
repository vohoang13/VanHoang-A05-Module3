package service;

import model.Book;

import java.util.List;

public interface IBookService {
    public void create(Book book);

    public List<Book> findAll();

    public Book findById(String id);

    public void update(Book book);

    public void delete(String id);
}