package com.nv.mongodb.dal;

import java.util.List;

import com.nv.mongodb.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	void removeUserById(String userId);
}