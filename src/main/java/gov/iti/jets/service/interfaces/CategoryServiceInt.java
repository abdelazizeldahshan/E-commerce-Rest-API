package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.Models.category.Category;

public interface CategoryServiceInt {

    List<Category> getCategories();

    Category getCategpryById(int id);

    Category getCategoryByName(String name);

    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int id);
}
