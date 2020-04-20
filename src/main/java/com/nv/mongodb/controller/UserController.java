package com.nv.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nv.mongodb.dal.UserDAL;
import com.nv.mongodb.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserDAL userDAL;

    @Autowired
    public UserController(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user) {
        LOG.info("Saving user.");
        return userDAL.addNewUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        LOG.info("Retrieving all users.");
        return userDAL.getAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        LOG.info("Retrieving user with ID: {}.", userId);
        return userDAL.getUserById(userId);
    }
}