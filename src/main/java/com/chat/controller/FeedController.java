package com.chat.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.chat.jsonDTO.FeedEntry;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "FeedController", urlPatterns = { "/" }, loadOnStartup = 1)
public class FeedController extends HttpServlet {
	

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	 ServletContext context = getServletContext();
    	 String filePath = context.getRealPath("/WEB-INF/feeds.json");
    	
    	
    	   // Get the real path to the feeds.json file located in WEB-INF
    	File jsonFile = new File(filePath);
    	

    	System.out.println("Path to feeds.json: " + jsonFile.getAbsolutePath());
        // Read the JSON file and map it to a List of FeedEntry objects
        List<FeedEntry> feeds = objectMapper.readValue(jsonFile, objectMapper.getTypeFactory().constructCollectionType(List.class, FeedEntry.class));    	
    	
    	request.setAttribute("feedsList", feeds);
    	
    	String view = request.getParameter("view");
        if ("custom".equalsIgnoreCase(view)) {
        	request.getRequestDispatcher("/WEB-INF/feedListCustomTag.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/feedListJSTL.jsp").forward(request, response);
        }

    }
}
