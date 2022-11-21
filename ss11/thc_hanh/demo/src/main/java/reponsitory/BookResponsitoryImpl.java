package reponsitory;

import model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookResponsitoryImpl implements IBookResponsitory{
    private static Map<String,Book> bookList = new HashMap();

    @Override
    public void create(Book book) {
        bookList.put(book.getId(),book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public Book findById(String id) {
        return bookList.get(id);
    }

    @Override
    public void update(Book book) {
    }

    @Override
    public void delete(String id) {
        bookList.remove(id);
    }
}
