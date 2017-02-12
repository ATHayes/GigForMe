/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.model.Person;

import java.util.ArrayList;

/**
 * Returns an ArrayList of all Users on the database and converts them to a JSON object
 * @author anthonyhayes
 */
public class GetAllUsersAJAXServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    /**
     *
     */
    public GetAllUsersAJAXServlet() {
                super();
        }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
        protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
                
                PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
                ArrayList<Person> pArray = personDAO.getAllUsers();
                String json = new Gson().toJson(pArray);
                response.setContentType("application/json");
                response.getWriter().write(json);
        }
}