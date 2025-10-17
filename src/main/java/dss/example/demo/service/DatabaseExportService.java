package dss.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dss.example.demo.model.Producto;
import dss.example.demo.repository.ProductoRepo;

@Service
public class DatabaseExportService {

	private final ProductoRepo productRepo;

	public ProductoRepo getProductRepo() {
		return productRepo;
	}

	@Autowired
	public DatabaseExportService(ProductoRepo productRepo) {
		this.productRepo = productRepo;
	}

	public byte[] exportDatabaseToSql() {

		StringBuilder sb = new StringBuilder();

		List<Producto> products = productRepo.findAll();

		for (Producto product : products) {
			String insert = String.format(Locale.US,
					"INSERT INTO producto (id, nombre, precio) VALUES (%d, '%s', %.2f);\n", product.getId(),
					product.getName().replaceFirst("'", "''"), product.getPrice());
			sb.append(insert);
		}
		return sb.toString().getBytes(StandardCharsets.UTF_8);
	}

}
