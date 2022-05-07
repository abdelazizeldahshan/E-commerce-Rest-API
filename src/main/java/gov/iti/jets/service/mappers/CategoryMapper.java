package gov.iti.jets.service.mappers;

import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.Models.category.Category;
import gov.iti.jets.repo.entities.CategoryEntity;

public class CategoryMapper {

    public Category categoryEntityTCategory(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setDescription(categoryEntity.getDescription());
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getValue());
        return category;
    }

    public Set<Category> categoryEntitySetTCategorySet(Set<CategoryEntity> categoryEntity) {
        Category category = new Category();
        Set<Category> categoryList = new HashSet<>();
        for (CategoryEntity category2 : categoryEntity) {
            category.setDescription(category2.getDescription());
            category.setId(category2.getId());
            category.setName(category2.getValue());
            categoryList.add(category);
        }
        return categoryList;
    }

    public Set<CategoryEntity> CategorySetToCategoryEntitySet(Set<Category> categories) {
        CategoryEntity category = new CategoryEntity();
        Set<CategoryEntity> categoryList = new HashSet<>();
        for (Category category2 : categories) {
            category.setDescription(category2.getDescription());
            category.setId(category2.getId());
            category.setValue(category2.getName());
            categoryList.add(category);
        }
        return categoryList;
    }

    public CategoryEntity CategoryToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setDescription(category.getDescription());
        categoryEntity.setValue(category.getName());
        return categoryEntity;
    }
}
