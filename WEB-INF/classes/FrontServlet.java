package etu1812.framework.servlet;

import java.io.*;
import jakarta.servlet.*; 
import jakarta.servlet.http.*;
import utils.Util;

public class FrontServlet extends HttpServlet{

    public FrontServlet(){

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
 
        res.setContentType("text/plain");
        processRequest(req,res);
        
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/plain");
        processRequest(req,res);
        
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
      
        String domaine=Util.treate_url(String.valueOf(req.getRequestURL()));
        PrintWriter out = res.getWriter();
        out.println(domaine); 
    }

}
