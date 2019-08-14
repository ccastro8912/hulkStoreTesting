package ec.hulkStore.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.hulkStore.model.Product;
import ec.hulkStore.repository.ProductRepository;
import ec.hulkStore.service.CategoryService;
import ec.hulkStore.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;

    @Override
    public Page<Product> findAllProductsPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    
    @Override
    public List<Product> findAllProducts() {
    	return productRepository.findAll();
    }

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(Long.valueOf(id));
	}

	@Override
	public Boolean moveToCategory(Long idNewCategory, Long idProduct) {
		boolean result = Boolean.FALSE;
		Product product = findById(idProduct).get();
		if(product.getQuantity() != 0) {
			product.setCategory(categoryService.findById(idNewCategory));
			result = Boolean.TRUE;
		}else {
			result = Boolean.FALSE;
		}
		return result;
	}
}
