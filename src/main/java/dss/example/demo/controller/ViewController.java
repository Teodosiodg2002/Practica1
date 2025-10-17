package dss.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dss.example.demo.service.ProductoService;
@Controller
public class ViewController {
	
	private final ProductoService productService;
	 
	public ViewController(ProductoService productService) {
		this.productService = productService;
	}
	 
	@GetMapping({"/", "/index"})
	  public String index(Model model) {
	    return "index";     // templates/index.html
	  }

	  @GetMapping("/admin")
	  public String admin(Model model) {
		model.addAttribute("products", productService.getAllProducts());
	    return "admin";     // templates/admin.html
	  }

	//  @GetMapping("/login")
	//  public String login() {
	 //   return "login";     // templates/login.html
	//  }
}
