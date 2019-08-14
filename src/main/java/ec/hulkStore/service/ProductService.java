package ec.hulkStore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.hulkStore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	Optional<Product> findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);
    
    List<Product> findAllProducts();

    void saveProduct(Product product);
    
    void updateProduct(Product product);
    
    void deleteProduct(Integer id);
    
    Boolean moveToCategory(Long idNewCategory, Long idProduct);
    
}
