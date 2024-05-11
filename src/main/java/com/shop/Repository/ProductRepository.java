package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
