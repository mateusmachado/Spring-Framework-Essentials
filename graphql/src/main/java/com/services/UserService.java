package com.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.models.User;

public interface UserService {

	List<User> findAllUsers();
	User findOneById(ObjectId id);
	List<User> findByIdIn(List<String> ids);
}
