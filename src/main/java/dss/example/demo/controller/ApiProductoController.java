package dss.example.demo.controller;

import dss.example.demo.model.Producto;
import dss.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indica que responde con datos JSON, no HTML
@RequestMapping("/api/products") // URL Base para toda la conexión móvil
public class ApiProductoController {

    @Autowired
    private ProductoService productService;

    // --- ZONA PÚBLICA (Catálogo y Compra) ---

    // 1. GET: Envía la lista de productos al móvil

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si está vacío
        }
        return ResponseEntity.ok(products); // Devuelve 200 OK + JSON
    }

    // 2. POST: Recibe el carrito de compra para procesar el pedido
    @PostMapping("/pedido")
    public ResponseEntity<String> realizarPedido(@RequestBody List<Producto> productos) {
        // Simulación de logistica (Imprime en consola del servidor)
        System.out.println("--- PEDIDO MÓVIL RECIBIDO (" + productos.size() + " items) ---");
        for (Producto p : productos) {
            System.out.println(" * " + p.getName() + " -> " + p.getPrice() + "€");
        }
        return ResponseEntity.ok("Pedido procesado correctamente");
    }

    // --- ZONA ADMIN (Gestión) ---

    // 3. POST: Crea un producto nuevo en la base de datos
    @PostMapping
    public ResponseEntity<Producto> addProduct(@RequestBody Producto product) {
        productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    // 4. DELETE: Elimina un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}