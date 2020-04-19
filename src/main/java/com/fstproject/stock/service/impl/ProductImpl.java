package com.fstproject.stock.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstproject.stock.bean.Product;
import com.fstproject.stock.dao.ProductRepository;
import com.fstproject.stock.service.facad.ProductService;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	public int save(Product product) {
		// if the product is already in the table
		if (productRepository.findByName(product.getName()) != null) {
			return -1;
		} else {
			productRepository.save(product);
			return 1;
		}
	}

	@Transactional
	public int delete(Long id) {
		productRepository.deleteById(id);
		return 1;
	}

	public int update(Product product) {
		// if the product is already in the table and its not the product who will be updated
		if (productRepository.findByNameAndIdNot(product.getName(), product.getId()) != null) {
			return -1;
		} else {
			productRepository.save(product);
			return 1;
		}
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
