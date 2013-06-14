/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.web.servlet;

import com.supinfo.supmarket.entity.User;
import com.supinfo.supmarket.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        if(httpRequest.getSession().getAttribute("username") != null) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/stats/dashboard");
        } else {       
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        try{
            User user = userService.isValidUser(username, password);
            
            if(user.toString() != null) {
                httpRequest.getSession().setAttribute("username", username);
                response.sendRedirect(request.getServletContext().getContextPath() + "/stats/dashboard");
            } else {
                doGet(request, response);
            }
        } catch (Exception e){
            request.setAttribute("error", true);
            doGet(request, response);
        }
    }
}
