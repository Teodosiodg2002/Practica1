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

}