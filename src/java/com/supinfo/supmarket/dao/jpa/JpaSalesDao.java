/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.dao.jpa;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.supinfo.supmarket.dao.SalesDao;
import com.supinfo.supmarket.entity.Products;
import com.supinfo.supmarket.entity.Sales;
import com.supinfo.supmarket.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Vincent
 */
@Stateless
public class JpaSalesDao implements SalesDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public String buildQuery(String countryID, String gender, String maritalStatus, String incomeLevel){
        String query = "";
        boolean isInit = false; 
        
        if(countryID != null || gender != null || maritalStatus != null || incomeLevel != null){
            query += " WHERE";
        }
        
        if(countryID != null){
            query += " s.custId.countryId.countryId = '" + countryID + "'";
            isInit = true;
        }
        
        if(gender != null){
            if(isInit == true){
                query += " AND";
            } else {
                isInit = true;
            }
            
            query += " s.custId.custGender = '" + gender + "'";
        }
        
        if(maritalStatus != null){
            if(isInit == true){
                query += " AND";
            } else {
                isInit = true;
            }
            
            query += " s.custId.custMaritalStatus LIKE '%" + maritalStatus + "%'";
        }
        
        if(incomeLevel != null){
            if(isInit == true){
                query += " AND";
            } else {
                isInit = true;
            }
            
            query += " s.custId.custIncomeLevel LIKE '%" + incomeLevel + "%'";
        }
        
        return query;
    }
    
    @Override
    public int getSalesCount(String countryID, String gender, String maritalStatus, String incomeLevel){
        return Integer.parseInt(em.createQuery("SELECT COUNT(s) FROM Sales s" + buildQuery(countryID, gender, maritalStatus, incomeLevel)).getSingleResult().toString());
    }
    
    @Override
    public String getAmountSold(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT SUM(s.amountSold) FROM Sales s" + buildQuery(countryID, gender, maritalStatus, incomeLevel)).getSingleResult().toString();
    }
    
    @Override
    public List<Sales> get100LastSales(int countryID){
        return em.createQuery("SELECT s FROM Sales s WHERE s.custId.countryId.countryId = " + countryID + " ORDER BY s.saleId DESC").setMaxResults(100).getResultList();
    }
        
    @Override
    public List<Sales> getTopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, SUM(s.quantitySold) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.prodId.prodId ORDER BY total DESC").setMaxResults(5).getResultList();
    }

    @Override
    public List<Sales> getFlopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, SUM(s.quantitySold) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.prodId.prodId ORDER BY total ASC").setMaxResults(5).getResultList();
    }
    
    @Override
    public List<Sales> getBreakdownByChannel(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.channelId.channelId").getResultList();
    }

    @Override
    public List<Sales> getBreakdownByCountry(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.custId.countryId.countryId").getResultList();
    }

    @Override
    public List<Sales> getBreakdownByGender(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.custId.custGender").getResultList();
    }
    
    @Override
    public List<Sales> getBreakdownByMS(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.custId.custMaritalStatus").getResultList();
    }
    
    @Override
    public List<Sales> getBreakdownByIncomeLevel(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.custId.custIncomeLevel").getResultList();
    }

    @Override
    public List<Sales> getTopCustomers(String countryID, String gender, String maritalStatus, String incomeLevel){
        return em.createQuery("SELECT s, COUNT(s) AS total FROM Sales s"+ buildQuery(countryID, gender, maritalStatus, incomeLevel)+" GROUP BY s.custId.custId ORDER BY total DESC").setMaxResults(20).getResultList();
    }
}
