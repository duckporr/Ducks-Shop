package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.Models.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}
