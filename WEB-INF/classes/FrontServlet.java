package etu1812.framework.servlet;

import jakarta.servlet.*; 
import jakarta.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import utils.Util;
import etu1812.framework.Mapping;


public class FrontServlet extends HttpServlet{

    HashMap<String,Mapping> MappingUrls = null;

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
      
        //sprint1
        String domaine=Util.treate_url(String.valueOf(req.getRequestURL()));
        PrintWriter out = res.getWriter();
        out.println("sprint1 : maka ny ressources(texte) ao amn URL ");
        out.println(domaine);
        out.println("");

        //sprint2
        
        //sprint3
        this.init(out);
    }

    public void init(PrintWriter out){

        out.println("sprint3 : maka ny classes rehetra ao amn selected package , maka ny value an'ny annotation an'ny methode ze annoté 'Anno_test' de atao anaty MappingURl");
        try{
            this.MappingUrls = Util.getHashMap();
            Util.afficher_MappingUrls(this.MappingUrls,out);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
