package reponsitory;

import model.Book;

import java.util.List;

public interface IBookResponsitory {
    public void create(Book book);

    public List<Book> findAll();

    public Book findById(String id);

    public void update(Book book);

    public void delete(String id);
}
