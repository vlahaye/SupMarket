/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.web.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.supinfo.supmarket.entity.Sales;
import com.supinfo.supmarket.service.SalesService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "JsonServlet", urlPatterns = {"/stats/api/export.json"})
public class JsonServlet extends HttpServlet {
    
    @EJB
    private SalesService salesService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Sales> sales = salesService.get100LastSales(52772);
        
        JsonObject topSales = new JsonObject();
        
        for (int i = 0; i < sales.size(); i++) {
            
            Sales getSale = sales.get(i);
            
            JsonObject channel = new JsonObject();
            channel.addProperty("channelId", getSale.getChannelId().getChannelId());
            channel.addProperty("channelDesc", getSale.getChannelId().getChannelDesc());
            channel.addProperty("channelClass", getSale.getChannelId().getChannelClass());
            channel.addProperty("channelClassId", getSale.getChannelId().getChannelClassId());
            channel.addProperty("channelTotal", getSale.getChannelId().getChannelTotal());
            channel.addProperty("channelTotalId", getSale.getChannelId().getChannelTotalId());
            
            JsonObject customer = new JsonObject();
            customer.addProperty("custId", getSale.getCustId().getCustId());
            customer.addProperty("custFirstName", getSale.getCustId().getCustFirstName());
            customer.addProperty("custLastName", getSale.getCustId().getCustLastName());
            customer.addProperty("custGender", getSale.getCustId().getCustGender());
            customer.addProperty("custYearOfBirth", getSale.getCustId().getCustYearOfBirth());
            customer.addProperty("custMaritalStatus", getSale.getCustId().getCustMaritalStatus());
            customer.addProperty("custStreetAddress", getSale.getCustId().getCustStreetAddress());
            customer.addProperty("custPostalCode", getSale.getCustId().getCustPostalCode());
            customer.addProperty("custCity", getSale.getCustId().getCustCity());
            customer.addProperty("custCityId", getSale.getCustId().getCustCityId());
            customer.addProperty("custStateProvince", getSale.getCustId().getCustStateProvince());
            customer.addProperty("custStateProvinceId", getSale.getCustId().getCustStateProvinceId());
            customer.addProperty("custMainPhoneNumber", getSale.getCustId().getCustMainPhoneNumber());
            customer.addProperty("custIncomeLevel", getSale.getCustId().getCustIncomeLevel());
            customer.addProperty("custCreditLimit", getSale.getCustId().getCustCreditLimit());
            customer.addProperty("custEmail", getSale.getCustId().getCustEmail());
            customer.addProperty("custTotal", getSale.getCustId().getCustTotal());
            customer.addProperty("custTotalId", getSale.getCustId().getCustTotalId());
            customer.addProperty("custSrcId", getSale.getCustId().getCustSrcId());
            customer.addProperty("CustEffFrom", ""); //getSale.getCustId().getCustEffFrom().getTime());
            customer.addProperty("custEffTo", ""); //getSale.getCustId().getCustEffTo().getTime());
            customer.addProperty("custValid", getSale.getCustId().getCustValid());
            customer.addProperty("countryId", getSale.getCustId().getCountryId().getCountryId());
            
            
            JsonObject product = new JsonObject();
            product.addProperty("prodId", getSale.getProdId().getProdId());
            product.addProperty("prodName", getSale.getProdId().getProdName());
            product.addProperty("prodDesc", getSale.getProdId().getProdDesc());
            product.addProperty("prodSubcategory", getSale.getProdId().getProdSubcategory());
            product.addProperty("prodSubcategoryId", getSale.getProdId().getProdSubcategoryId());
            product.addProperty("prodSubcategoryDesc", getSale.getProdId().getProdSubcategoryDesc());
            product.addProperty("prodCategory", getSale.getProdId().getProdCategory());
            product.addProperty("prodCategoryId", getSale.getProdId().getProdCategoryId());
            product.addProperty("prodCategoryDesc", getSale.getProdId().getProdCategoryDesc());
            product.addProperty("prodWeightClass", getSale.getProdId().getProdWeightClass());
            product.addProperty("prodUnitOfMeasure", getSale.getProdId().getProdUnitOfMeasure());
            product.addProperty("prodPackSize", getSale.getProdId().getProdPackSize());
            product.addProperty("supplierId", getSale.getProdId().getSupplierId());
            product.addProperty("prodStatus", getSale.getProdId().getProdStatus());
            product.addProperty("prodListPrice", getSale.getProdId().getProdListPrice());
            product.addProperty("prodMinPrice", getSale.getProdId().getProdMinPrice());
            product.addProperty("prodTotal", getSale.getProdId().getProdTotal());
            product.addProperty("prodTotalId", getSale.getProdId().getProdTotalId());
            product.addProperty("prodSrcId", getSale.getProdId().getProdSrcId());
            product.addProperty("prodEffFrom", ""); //getSale.getProdId().getProdEffFrom());
            product.addProperty("prodEffTo", ""); //getSale.getProdId().getProdEffTo());
            product.addProperty("prodValid", getSale.getProdId().getProdValid());
            
            JsonObject promotion = new JsonObject();
            promotion.addProperty("promoId", getSale.getPromoId().getPromoId());
            promotion.addProperty("promoName", getSale.getPromoId().getPromoName());
            promotion.addProperty("promoSubcategory", getSale.getPromoId().getPromoSubcategory());
            promotion.addProperty("promoSubcategoryId", getSale.getPromoId().getPromoSubcategoryId());
            promotion.addProperty("promoCategory", getSale.getPromoId().getPromoCategory());
            promotion.addProperty("promoCategoryId", getSale.getPromoId().getPromoCategoryId());
            promotion.addProperty("promoCost", getSale.getPromoId().getPromoCost());
            promotion.addProperty("promoBeginDate", ""); //getSale.getPromoId().getPromoBeginDate());
            promotion.addProperty("promoEndDate", ""); //getSale.getPromoId().getPromoEndDate());
            promotion.addProperty("promoTotal", getSale.getPromoId().getPromoTotal());
            promotion.addProperty("promoTotalId", getSale.getPromoId().getPromoTotalId());
            
            JsonObject currentSale = new JsonObject();
            currentSale.add("channel", channel);
            currentSale.add("customer", customer);
            currentSale.addProperty("timeId", getSale.getTimeId().toString());
            currentSale.add("product", product);
            currentSale.add("promotion", promotion);
            currentSale.addProperty("quantitySold", getSale.getQuantitySold());
            currentSale.addProperty("amountSold", getSale.getAmountSold());
            currentSale.addProperty("saleId", getSale.getSaleId());
            
            topSales.add(String.valueOf(i), currentSale);
	}
        
        response.setContentType("application/json");       
        Gson gson = new Gson();
        
        response.getOutputStream().print(gson.toJson(topSales));
        response.getOutputStream().flush();
    }
}
