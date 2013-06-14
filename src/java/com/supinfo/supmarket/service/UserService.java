/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.service;

import com.supinfo.supmarket.dao.UserDao;
import com.supinfo.supmarket.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Vincent
 */
@Stateless
public class UserService {
    @EJB
    private UserDao userDao;
    
    public User isValidUser(String username, String password) {
        return userDao.isValidUser(username, password);
    }
}
