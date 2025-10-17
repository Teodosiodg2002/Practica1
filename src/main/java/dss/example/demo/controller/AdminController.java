package dss.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dss.example.demo.service.DatabaseExportService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final DatabaseExportService databaseExportService;
	
	@Autowired
    public AdminController(DatabaseExportService databaseExportService) {
        this.databaseExportService = databaseExportService;
    }
	
	@GetMapping("/download-db-sql")
	public ResponseEntity<byte[]> downloadDatabaseSql() {
		
		byte[] archivosql = databaseExportService.exportDatabaseToSql();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "DB_Productos.sql");
        
        return new ResponseEntity<>(archivosql, headers, HttpStatus.OK);
	}
	

}
