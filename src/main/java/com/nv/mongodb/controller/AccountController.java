package com.nv.mongodb.controller;

import com.nv.mongodb.dal.AccountDAL;
import com.nv.mongodb.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final AccountDAL accountDAL;

    @Autowired
    public AccountController(AccountDAL accountDAL) {
        this.accountDAL = accountDAL;
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Account addNewAccount(@RequestBody Account account) {
        LOG.info("Saving account: {}", account);
        //ignore user id sent by the client
        account.setId(null);
        //ignore account_id sent by the client
        account.setAccount_id(String.valueOf(Instant.now().toEpochMilli()));
        return accountDAL.addNewAccount(account);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        LOG.info("Retrieving all accounts.");
        return accountDAL.getAllAccounts();
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public Account getUser(@PathVariable String accountId) {
        LOG.info("Retrieving account with ID: {}", accountId);
        return accountDAL.getAccountById(accountId);
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String accountId) {
        LOG.info("Deleting account with ID: {}.", accountId);
        accountDAL.removeAccountById(accountId);
    }
}