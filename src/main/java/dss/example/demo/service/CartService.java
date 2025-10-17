package dss.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import dss.example.demo.model.Producto;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class CartService {
	
    private final ProductoService productoService;
	private final List<Producto> cartItems = new ArrayList();
	
	public CartService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	public List<Producto> getCartItems(){
		return cartItems;
	}
	
	public void addProduct(Long productId) {
		Producto product = productoService.getProductById(productId);
		if (product != null) {
			cartItems.add(product);
		}
	}

	public void removeProduct(Long productId) {
        for (Iterator<Producto> it = cartItems.iterator(); it.hasNext();) {
            if (it.next().getId().equals(productId)) {
                it.remove();
                break;
            }
        }
    }

}
