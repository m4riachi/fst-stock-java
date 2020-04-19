package com.fstproject.stock.ws.provided;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstproject.stock.bean.Product;
import com.fstproject.stock.service.facad.ProductService;

@RestController
@RequestMapping("api/stock/product")
@CrossOrigin("http://localhost:4200")
public class ProductRest {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public int save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("/id/{id}")
	public int delete(@PathVariable Long id) {
		return productService.delete(id);
	}
	
	@PutMapping("/")
	public int update(@RequestBody Product product) {
		return productService.update(product);
	}
	
	@GetMapping("/")
	public List<Product> findAll() {
		return productService.getAll();
	}
}
