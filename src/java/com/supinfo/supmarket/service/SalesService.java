/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.service;

import com.supinfo.supmarket.dao.SalesDao;
import com.supinfo.supmarket.entity.Sales;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Vincent
 */
@Stateless
public class SalesService {
    @EJB
    private SalesDao salesDao;
    
    public int getSalesCount(String countryID, String gender, String maritalStatus, String incomeLevel) {
        return salesDao.getSalesCount(countryID, gender, maritalStatus, incomeLevel);
    }
    
    public String getAmountSold(String countryID, String gender, String maritalStatus, String incomeLevel) {
        return salesDao.getAmountSold(countryID, gender, maritalStatus, incomeLevel);
    }
    
    public List<Sales> get100LastSales(int countryID){
        return salesDao.get100LastSales(countryID);
    }
    
    public List<Sales> getTopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getTopSelledProducts(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getFlopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getFlopSelledProducts(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getBreakdownByChannel(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getBreakdownByChannel(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getBreakdownByCountry(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getBreakdownByCountry(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getBreakdownByGender(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getBreakdownByGender(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getBreakdownByMS(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getBreakdownByMS(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getBreakdownByIncomeLevel(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getBreakdownByIncomeLevel(countryID, gender, maritalStatus, incomeLevel);
    }

    public List<Sales> getTopCustomers(String countryID, String gender, String maritalStatus, String incomeLevel){
        return salesDao.getTopCustomers(countryID, gender, maritalStatus, incomeLevel);
    }
}
