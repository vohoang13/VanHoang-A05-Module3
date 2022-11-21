package service;

import model.Book;
import reponsitory.BookResponsitoryImpl;
import reponsitory.IBookResponsitory;

import java.util.List;

public class BookService implements IBookService{
    private IBookResponsitory bookResponsitory = new BookResponsitoryImpl();
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
    public void update(Book book) {

    }

    @Override
    public void delete(String id) {
        bookResponsitory.delete(id);
    }
}
