package responsitory;

import model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookResponsitory implements IBookResponsitory{
    public static Map<String,Book> bookMap = new HashMap<>();
    @Override
    public void create(Book book) {
        bookMap.put(book.getId(),book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book findById(String id) {
        return bookMap.get(id);
    }

    @Override
    public void delete(String id) {
        bookMap.remove(id);
    }

    @Override
    public void update(String id, Book book) {
        bookMap.replace(id,book);
    }
}
