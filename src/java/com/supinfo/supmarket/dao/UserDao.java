/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.dao;

import com.supinfo.supmarket.entity.User;
import javax.ejb.Local;

/**
 *
 * @author Vincent
 */
@Local
public interface UserDao {
    public User isValidUser(String username, String password);
}
