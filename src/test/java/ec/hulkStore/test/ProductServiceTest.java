package ec.hulkStore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.hulkStore.model.Category;
import ec.hulkStore.model.Product;
import ec.hulkStore.repository.CategoryRepository;
import ec.hulkStore.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class ProductServiceTest {

	@Autowired
	 ProductService productService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
    public void testSaveProduct() {
		Optional <Category> category = categoryRepository.findById(Long.valueOf(2));
		int id = (productService.findAllProducts().size()) + 1;
        Product product = new Product(category.get(), "Producto" + id, " ", "Producto" +id ,new BigDecimal(23),12 );
        productService.saveProduct(product);
         
        Optional <Product> product2 = productService.findById(Long.valueOf(id));
        assertEquals("Producto1", product2.get().getName());
    }
	
	@Test
    public void testUpdateProduct() {
		int id = (productService.findAllProducts().size());
        Product product = productService.findById(Long.valueOf(id)).get();
        product.setName("Product");
        productService.saveProduct(product);      
        Optional <Product> product2 = productService.findById(Long.valueOf(id));
        assertNotEquals("Producto1", product2.get().getName());
    }
	
	
	@Test
	public void testMoveToCategory() {
		Optional <Category> category = categoryRepository.findById(Long.valueOf(2));
		Product product = new Product(category.get(), "Producto", " ", "Producto" ,new BigDecimal(23),0);
		assertFalse(productService.moveToCategory(Long.valueOf(3), product.getId()));
	}
	
	
	 @Test
	    public void testDeleteProduct() {
		    Optional <Category> category = categoryRepository.findById(Long.valueOf(3));
			Product product = new Product(category.get(), "DeleteProduct", " ", "DeleteProduct" ,new BigDecimal(23),12 );
	        productService.saveProduct(product);
	        int idBefore = (productService.findAllProducts().size());
	        productService.deleteProduct(idBefore);
	        int idAfter = (productService.findAllProducts().size());
	        assertNotEquals(idBefore,idAfter);
	        
	    }
	
}
