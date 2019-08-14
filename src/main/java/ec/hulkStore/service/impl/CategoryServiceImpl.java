package ec.hulkStore.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.hulkStore.model.Category;
import ec.hulkStore.repository.CategoryRepository;
import ec.hulkStore.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllCategoriesPageable(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
    
    @Override
    public List<Category> findAllCategories() {
    	return categoryRepository.findAll();
    }

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(Long.valueOf(id));
	}
}
