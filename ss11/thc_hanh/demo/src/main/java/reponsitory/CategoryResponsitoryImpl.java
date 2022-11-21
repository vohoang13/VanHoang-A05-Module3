package reponsitory;

import model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryResponsitoryImpl implements ICategory{
    private static Map<String,Category> categoryList = new HashMap<>();

    static {
        categoryList.put("CT001",new Category("CT001","Sách giáo khoa"));
        categoryList.put("CT002",new Category("CT002","Sách tham khảo"));
        categoryList.put("CT003",new Category("CT003","Sách khoa học"));
        categoryList.put("CT004",new Category("CT004","Sách anh văn"));
    }
    @Override
    public Category findById(String id) {
        return categoryList.get(id);
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categoryList.values());
    }
}
