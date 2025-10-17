package dss.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dss.example.demo.service.CartService;

@Controller
@SessionAttributes("cartItems")
public class CartController {
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/cart")
	public String viewCart(Model model) {
		model.addAttribute("cartItems", cartService.getCartItems());
		return "cart";
	}

	@PostMapping("/cart/add/{id}")
	public String addToCart(@PathVariable("id") Long id, RedirectAttributes ra) {
		cartService.addProduct(id);
		ra.addFlashAttribute("msg", "Añadido al carrito");
		return "redirect:/cart";
	}

	@PostMapping("/cart/remove/{id}")
	public String removeFromCart(@PathVariable("id") Long id, RedirectAttributes ra) {
		cartService.removeProduct(id);
		ra.addFlashAttribute("msg", "Eliminado del carrito");
		return "redirect:/cart";
	}
}
