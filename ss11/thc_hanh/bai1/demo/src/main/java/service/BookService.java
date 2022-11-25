package service;

import model.Book;
import responsitory.BookResponsitory;
import responsitory.IBookResponsitory;

import java.util.List;

public class BookService implements IBookService{
    private IBookResponsitory bookResponsitory = new BookResponsitory();
    @Override
    public void create(Book book) {
        bookResponsitory.create(book);
    }

    @Override
    public List<Book> findAll() {
        return bookResponsitory.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookResponsitory.findById(id);
    }

    @Override
    public void delete(String id) {
        bookResponsitory.delete(id);
    }

    @Override
    public void update(String id,Book book) {
        bookResponsitory.update(id,book);
    }
}
