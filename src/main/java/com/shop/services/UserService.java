package com.shop.services;

import com.shop.Models.User;

public interface UserService {
	User findByUserName(String userName);
}
