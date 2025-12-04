package dss.example.demo.controller;

import dss.example.demo.model.Producto;
import dss.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ApiProductoController {

    @Autowired
    private ProductoService productService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping("/pedido")
    public ResponseEntity<String> realizarPedido(@RequestBody List<Producto> productos) {

        System.out.println("--- NUEVO PEDIDO RECIBIDO ---");
        System.out.println("Cantidad de productos: " + productos.size());
        for (Producto p : productos) {
            System.out.println(" - " + p.getName() + " (" + p.getPrice() + ")");
        }

        return ResponseEntity.ok("Pedido procesado correctamente en el servidor");
    }

    @PostMapping
    public ResponseEntity<Producto> addProduct(@RequestBody Producto product) {
        productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}