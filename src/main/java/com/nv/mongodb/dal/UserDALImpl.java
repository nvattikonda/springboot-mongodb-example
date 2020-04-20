package com.nv.mongodb.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nv.mongodb.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	private final MongoTemplate mongoTemplate;

	public UserDALImpl(@Qualifier("mflixMongoTemplate") MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public void removeUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		mongoTemplate.remove(query,User.class);
	}
}
