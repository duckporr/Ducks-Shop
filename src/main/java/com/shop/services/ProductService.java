package com.shop.services;

import java.util.List;

import com.shop.Models.Product;

public interface ProductService {
	List<Product> getAll();

	Boolean create(Product product);

	Product FindByID(Integer id);

	Boolean Update(Product product);

	Boolean Delete(Integer id);
}
