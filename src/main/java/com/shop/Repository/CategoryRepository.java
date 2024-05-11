package com.shop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.Models.Category;

import jakarta.persistence.Id;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query("Select c from Category c Where c.categoryName like %?1% ")
	List<Category>  searchCategory(String keyword);
	
}
