package jpa.dao;

import java.util.List;
import jpa.entity.Category;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(int id);
    void create(Category category);
    void update(Category category);
    void delete(int id);
}
