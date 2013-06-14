/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.web.servlet;

import com.supinfo.supmarket.service.SalesService;
import java.io.IOException;
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
@WebServlet(name = "DashboardServlet", urlPatterns = {"/stats/dashboard"})
public class DashboardServlet extends HttpServlet {

    @EJB
    private SalesService salesService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String countryID = (request.getParameter("country") != "") ? request.getParameter("country") : null;
        String gender = (request.getParameter("gender") != "") ? request.getParameter("gender") : null;
        String maritalStatus = (request.getParameter("maritalStatus") != "") ? request.getParameter("maritalStatus") : null;
        String incomeLevel = (request.getParameter("incomeLevel") != "") ? request.getParameter("incomeLevel") : null;
        
        try{
            request.setAttribute("salesCount", salesService.getSalesCount(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("amountSold", salesService.getAmountSold(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("topProducts", salesService.getTopSelledProducts(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("flopProducts", salesService.getFlopSelledProducts(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("breakdownByChannel", salesService.getBreakdownByChannel(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("breakdownByCountry", salesService.getBreakdownByCountry(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("breakdownByGender", salesService.getBreakdownByGender(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("breakdownByMS", salesService.getBreakdownByMS(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("breakdownByIncomeLevel", salesService.getBreakdownByIncomeLevel(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("topCustomers", salesService.getTopCustomers(countryID, gender, maritalStatus, incomeLevel));
            request.setAttribute("username", httpRequest.getSession().getAttribute("username"));
        } catch(Exception e){
            request.setAttribute("noData", true);
        }

        request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
    }
}
