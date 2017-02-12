/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.google.gson.Gson;
import com.gigForMe.manager.BandManager;
import com.gigForMe.model.Band;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Returns an ArrayList of all Bands on the database and converts them to a JSON object
 * @author anthonyhayes
 */
public class GetAllBandsAJAXServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    /**
     *
     */
    public GetAllBandsAJAXServlet() {
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
               
                BandManager bmg = BandManager.getInstance();
                ArrayList<Band> bArray = bmg.getAllBands();
                //convert to json using Google's GSON library
                String json = new Gson().toJson(bArray);
                response.setContentType("application/json");
                response.getWriter().write(json);
        }
}