package com.shop.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shop.Models.Category;

public interface CategoryService {
	List<Category> getAll();

	Boolean create(Category category);

	Category FindByID(Integer id);

	Boolean Update(Category category);

	Boolean Delete(Integer id);
	List<Category> SearchCategory(String keyword);
	Page<Category> getAll(Integer pageNumber);
	Page<Category> SearchCategory(String keyword , Integer pageNumber);
}
