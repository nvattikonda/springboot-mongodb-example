package com.nv.mongodb.dal;

import com.nv.mongodb.model.Account;

import java.util.List;

public interface AccountDAL {

	List<Account> getAllAccounts();

	Account getAccountById(String accountId);

	Account addNewAccount(Account account);

	void removeAccountById(String userId);
}