/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.dao.jpa;

import com.supinfo.supmarket.dao.UserDao;
import com.supinfo.supmarket.entity.User;
import java.beans.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Vincent
 */
@Stateless
public class JpaUserDao implements UserDao {

    private MessageDigest md;
    @PersistenceContext
    private EntityManager em;

    public JpaUserDao() {
        super();

        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User isValidUser(String username, String password) {
        Query query = em.createQuery("SELECT a FROM User a WHERE a.username = '" + username + "' AND a.password = '" + generateHashCode(password) + "'");
        return (User) query.getSingleResult();
    }

    /**
    * Returns the hash code corresponding to the given input string.
    * @param input: string to be encoded.
    * @return hash code corresponding to the given input string.
    */
   private String generateHashCode(String input){
           return hexToString(md.digest(input.getBytes()));
   }


   /**
    * Given a byte[] array, produces a hex String,
    * such as "234a6f". with 2 chars for each byte in the array.
    * (provided code from HW4)
   */
   public static String hexToString(byte[] bytes) {
           StringBuffer buff = new StringBuffer();
           for (int i=0; i<bytes.length; i++) {
                   int val = bytes[i];
                   val = val & 0xff;  // remove higher bits, sign
                   if (val<16) buff.append('0'); // leading 0
                   buff.append(Integer.toString(val, 16));
           }
           return buff.toString();
   }
}
