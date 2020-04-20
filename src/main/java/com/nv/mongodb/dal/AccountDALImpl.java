package com.nv.mongodb.dal;

import com.nv.mongodb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDALImpl implements AccountDAL {

	private final MongoTemplate mongoTemplate;

	public AccountDALImpl(@Qualifier("analyticsMongoTemplate") MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Account> getAllAccounts() {
		return mongoTemplate.findAll(Account.class);
	}

	@Override
	public Account getAccountById(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(accountId));
		return mongoTemplate.findOne(query, Account.class);
	}

	@Override
	public Account addNewAccount(Account account) {
		mongoTemplate.save(account);
		return account;
	}

	@Override
	public void removeAccountById(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(accountId));
		mongoTemplate.remove(query,Account.class);
	}
}
