package dss.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dss.example.demo.model.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Long> {
	
	List <Producto> findByNameContainingIgnoreCase(String clave);

}
