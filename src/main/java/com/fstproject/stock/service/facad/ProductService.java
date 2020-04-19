package com.fstproject.stock.service.facad;

import java.util.List;

import com.fstproject.stock.bean.Product;

public interface ProductService {
	int save(Product product);
	int delete(Long id);
	int update(Product product);
	List<Product> getAll();
}
