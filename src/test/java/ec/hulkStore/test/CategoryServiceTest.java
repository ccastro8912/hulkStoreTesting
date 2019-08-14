package ec.hulkStore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import ec.hulkStore.model.Category;
import ec.hulkStore.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	@Autowired
	CategoryService categoryService;
	
	@Test
    public void testSaveCategory() {
		Category category = new Category("Category", "Category");
		int id = (categoryService.findAllCategories().size())+1;
		categoryService.saveCategory(category);
		Category category2 = categoryService.findById(Long.valueOf(id));
        assertEquals("Category", category2.getName());
    }
	
	
	@Test
    public void testUpdateCategory() {
		int id = (categoryService.findAllCategories().size())+1;
		Category category = categoryService.findById(Long.valueOf(id));
		category.setName("NewCategory");
		categoryService.saveCategory(category);      
		Category category2 = categoryService.findById(Long.valueOf(id));
        assertNotEquals("Category", category2.getName());
    }
	
}
