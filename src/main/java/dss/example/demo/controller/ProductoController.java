package dss.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dss.example.demo.model.Producto;
import dss.example.demo.service.ProductoService;

@Controller
@RequestMapping("/products")
public class ProductoController {
	@Autowired
    private ProductoService productService;
//	@GetMapping
//    public String getProductsPage(Model model) {
//		model.addAttribute("products", productService.getAllProducts());
//        return "products"; // Devuelve products.html desde las plantillas
//    }
	@GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Producto());
        return "product_form"; // templates/product_form.html
    }
	@PostMapping("/add")
	   public String addProduct(@RequestParam String name, @RequestParam double price) {
	        Producto product = new Producto();
	        product.setName(name);
	        product.setPrice(price);
	        productService.saveProduct(product);
	        return "redirect:/admin";  // Redirigir correctamente a /admin
	    }
	@GetMapping("/edit/{id}")
	public String showEditProduct(@PathVariable Long id, Model model) {
		
		Producto product = productService.getProductById(id);
		if (product != null) {
	        model.addAttribute("product", product);
	        return "product_form"; // o "formulario-producto"
	    }
	    return "redirect:/admin";
		
	}
	
	@PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @RequestParam String name, @RequestParam double price) {
        Producto product = productService.getProductById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            productService.saveProduct(product);
        }
        return "redirect:/admin";  // Redirigir correctamente a /admin
    }
	@PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";  // Redirigir correctamente a /admin
    }
	
	@GetMapping
	public String getProductsPage(@RequestParam(required = false) String nombre, Model model) {
	    List<Producto> products;

	    if (nombre != null && !nombre.isEmpty()) {
	        products = productService.searchProducts(nombre);
	    } else {
	
	        products = productService.getAllProducts();
	    }

	    model.addAttribute("products", products);
	    model.addAttribute("nombre", nombre);
	    return "products";
	}
	
	
}