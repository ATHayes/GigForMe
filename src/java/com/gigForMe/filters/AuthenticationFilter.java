/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.filters;

import com.gigForMe.utils.IConstants;
import com.gigForMe.model.Person;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Jsp filter that redirects authenticated requests
 * @author anthonyhayes
 */
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        if (IConstants.AUTHORISATION == true){
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::" + uri);
        HttpSession session = req.getSession(false);
        
        // If there is no user on the session
        if (session == null) {
            //Servlets and jsp pages require authentication
            if (uri.contains("jsp") || uri.contains("Servlet")){
                
                // Always allow access to the Login Servlet
                if(uri.contains("LoginServlet") || uri.contains("RegisterServlet")){
                    fc.doFilter(request, response);
                }
                
                // Otherwise redirect to the login page
                else{
                this.context.log("Unauthorized access request");
                res.sendRedirect("login.html");
                }
            }
            // Otherwise allow access to resources (excluding .jsp and Servlets)
            else{
                fc.doFilter(request, response);
            }
            
        // If there is a user logged in
        
        } else if (session != null) {
            Person currentUser = (Person) session.getAttribute(IConstants.SESSION_KEY_USER);
            //all admin pages contain the word "admin"
            if ("FAN".equals(currentUser.getAuth()) && uri.contains("admin")) {
                res.sendRedirect("fanHome.jsp");
            } else {
                // Allow the request
                fc.doFilter(request, response);
            }
        }
        } else{
        fc.doFilter(request, response);
        }//End if Authentication on
    }

    public void destroy() {
        //close any resources here
    }

}
