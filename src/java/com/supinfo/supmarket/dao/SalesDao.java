/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.dao;

import com.supinfo.supmarket.entity.Products;
import com.supinfo.supmarket.entity.Sales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vincent
 */
@Local
public interface SalesDao {
    public int getSalesCount(String countryID, String gender, String maritalStatus, String incomeLevel);
    public String getAmountSold(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> get100LastSales(int countryID);
    public List<Sales> getTopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getFlopSelledProducts(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getBreakdownByChannel(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getBreakdownByCountry(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getBreakdownByGender(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getBreakdownByMS(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getBreakdownByIncomeLevel(String countryID, String gender, String maritalStatus, String incomeLevel);
    public List<Sales> getTopCustomers(String countryID, String gender, String maritalStatus, String incomeLevel);
}
