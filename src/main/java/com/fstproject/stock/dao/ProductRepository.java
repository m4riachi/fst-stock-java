package com.fstproject.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstproject.stock.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Product findByNameAndIdNot(String name, Long id);
}
