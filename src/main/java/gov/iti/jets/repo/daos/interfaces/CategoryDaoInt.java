package gov.iti.jets.repo.daos.interfaces;

import java.util.List;

import gov.iti.jets.repo.entities.CategoryEntity;

public interface CategoryDaoInt {

    List<CategoryEntity> getAllCategories();

    CategoryEntity getCategoryById(int id);

    CategoryEntity getCateoryByName(String name);

    boolean addCategory(CategoryEntity categoryEntity);

    boolean updateCategory(CategoryEntity categoryEntity);

    boolean deleteCategory(int id);
}
