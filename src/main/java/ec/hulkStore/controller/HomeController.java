package ec.hulkStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ec.hulkStore.service.CategoryService;
import ec.hulkStore.service.ProductService;
import ec.hulkStore.service.ShoppingCartService;


@Controller
public class HomeController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	private  ShoppingCartService shoppingCartService;

	//@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("total", shoppingCartService.getTotal().toString());
		model.addAttribute("productsInCart", shoppingCartService.getProductsInCart());
		model.addAttribute("totalItems", shoppingCartService.getProductsInCart().size());
		model.addAttribute("products", productService.findAllProducts());
		return "index";
	}

	@GetMapping("/")
	public String indexAdmin(Model model) {
		return "indexAdmin";
	}


	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/addProduct/{productId}")
	public String addProductToCart(Model model,@PathVariable("productId") Long productId) {
		shoppingCartService.addProduct(productService.findById(productId).get());
		return "index";	
	}
	
	 @GetMapping("/removeProduct/{productId}")
	    public String removeProductFromCart(@PathVariable("productId") Integer productId) {
		 shoppingCartService.removeProduct(productService.findById(Long.valueOf(productId)).get());
	        return "redirect:index";
	    }

	@GetMapping("/checkout")
	public String checkout() {
		shoppingCartService.checkout();
		return "redirect:index";
	}
}
