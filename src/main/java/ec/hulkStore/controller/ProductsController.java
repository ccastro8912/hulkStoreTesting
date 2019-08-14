package ec.hulkStore.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.hulkStore.model.Product;
import ec.hulkStore.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductsController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/product-list")
	public String listarCliente(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "products/product-list";
	}

	@GetMapping("/add")
	public String addProductFrm(Model model) {	
		model.addAttribute("addStatus", true);
		model.addAttribute("product", new Product());
		return "products/product";
	}


	@GetMapping("/edit") 
	public String editProductFrm(Model model, @RequestParam("id") Integer id){
		Product product = productService.findById(Long.valueOf(id)).get();
		model.addAttribute("product", product);
		model.addAttribute("addStatus", false);	
		return "products/product";
	}

	@PostMapping("/add") 
	public String actionAddUser(Model model, @Valid Product product) {
		productService.saveProduct(product);
		return "redirect:product-list";	
	}


	@PostMapping("/update")
	public String updateCliente(Model model,  @Valid Product product) { 
		productService.updateProduct(product);
		return "redirect:product-list";	
	}


	@GetMapping("/remove")
	public String removeCliente(@RequestParam("id") Integer id){
		productService.deleteProduct(id);
		return "redirect:product-list";	
	}

	
}
