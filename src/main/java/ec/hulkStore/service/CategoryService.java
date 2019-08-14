package ec.hulkStore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.hulkStore.model.Category;

import java.util.List;

public interface CategoryService {

	Category findById(Long id);

    Page<Category> findAllCategoriesPageable(Pageable pageable);
    
    List<Category> findAllCategories();

    void saveCategory(Category category);
    
    void updateCategory(Category category);
    
    void deleteCategory(Integer id);
    
    
    
}
