package com.shop.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.Models.Category;
import com.shop.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public Boolean create(Category category) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category FindByID(Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public Boolean Update(Category category) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean Delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.categoryRepository.delete(FindByID(id));;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	
	}

	@Override
	public List<Category> SearchCategory(String keyword) {
		// TODO Auto-generated method stub
		return this.categoryRepository.searchCategory(keyword);
	}

	@Override
	public Page<Category> getAll(Integer pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber-1, 4);
		return this.categoryRepository.findAll(pageable);
	}

	@Override
	public Page<Category> SearchCategory(String keyword, Integer pageNumber) {
		// TODO Auto-generated method stub
		List list =  this.SearchCategory(keyword);
		Pageable pageable=PageRequest.of(pageNumber-1, 4);
		Integer start =(int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset()+ pageable.getPageSize()) > list.size()?  list.size(): pageable.getOffset()+ pageable.getPageSize());
		list=list.subList(start, end);
		return new PageImpl<Category>(list,pageable,this.SearchCategory(keyword).size());
	}

}
