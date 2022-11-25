package responsitory;

import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRespontory implements ICategoryRespontory {
    private static Map<String, Category> categoryMap = new HashMap<>();

    static {
        categoryMap.put("CT001",new Category("CT001","Sách giáo khoa"));
        categoryMap.put("CT002",new Category("CT002","Sách anh văn"));
        categoryMap.put("CT003",new Category("CT003","Sách tham khảo"));
        categoryMap.put("CT004",new Category("CT004","Sách khoa học"));
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categoryMap.values());
    }

    @Override
    public Category findById(String id) {
        return categoryMap.get(id);
    }
}
