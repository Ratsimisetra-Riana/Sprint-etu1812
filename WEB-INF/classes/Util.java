package utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StringContent;

import java.util.HashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import annotations.Anno_test;
import etu1812.framework.Mapping;

public class Util {
    
    public Util(){

    }

    @Anno_test( value = "1")
    public static String treate_url(String url){

//      http://localhost:8080/Sprint/ 
        String ressource = "";
        String host_contexte = url.substring(url.indexOf("/")+2);   //  localhost:8080/Sprint/
        String contexte = host_contexte.substring(host_contexte.indexOf("/")+1);//  Sprint/
        
        ressource = contexte.substring(contexte.indexOf("/")+1);
        
        if(ressource.contains("?"))
        {
            ressource = ressource.split("?")[0];
        }
        else
        {

        }

        return ressource;
    }

    public static ArrayList<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        //directory : path le dossier(package) jerena      packageName : anaranle package
        ArrayList<Class> classes = new ArrayList<Class>();
        if (!directory.exists())
        {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory()) 
            {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName + "." + file.getName()));
            } 
            else if (file.getName().endsWith(".class")) 
            {
                classes.add(Class.forName(packageName+ '.'+ file.getName().substring(0,file.getName().length() - 6)));
                //System.out.println(file.getName());
            }
        }
        return classes;
    }

    public static HashMap<String,Mapping> getHashMap() throws ClassNotFoundException{//maka ny classe sy methodes annotées rehetra
        
        HashMap<String,Mapping> MappingUrls = new HashMap<String,Mapping>();
        
        ArrayList<Class> classes = Util.findClasses(new File("/opt/tomcat/apache-tomcat-10.1.5/webapps/Sprint/WEB-INF/classes/utils"), "utils");
        
        int i=0;
        int j=0;
        ArrayList<Method> methods = null;
        Anno_test anno = null;

        for(i=0;i<classes.size();i++)
        {
            //System.out.println("classe:"+classes.get(i).getName());
            //System.out.println("i="+i);
            methods = new ArrayList<Method>(List.of(classes.get(i).getDeclaredMethods()));
            
            for(j=0;j<methods.size();j++)
            {
                if(methods.get(j).isAnnotationPresent(Anno_test.class))
                {
                    anno = methods.get(j).getAnnotation(Anno_test.class);
                    //System.out.println(anno.value());
                    MappingUrls.put(anno.value(),new Mapping(classes.get(i).getName(),methods.get(j).getName()));
                }
            }
        }

        return MappingUrls;
    }

    public static void afficher_MappingUrls(HashMap<String,Mapping> MappingUrls,PrintWriter out){

        ArrayList<String> keys =  new ArrayList<String>(MappingUrls.keySet());//maka ny keys rehetra ao amn hashmap
        int i=0;
        out.println("MappingUrls:");
        for(i=0;i<keys.size();i++)
        {
            out.println("key:"+keys.get(i)+" , "+"(classname = "+MappingUrls.get(keys.get(i)).getClassName()+" "+"method = "+MappingUrls.get(keys.get(i)).getMethod()+")");
        }
    }

    /*public static void main(String [] args){
        try{
            //ArrayList<Class> classes = Util.findClasses(new File("/opt/tomcat/apache-tomcat-10.1.5/webapps/Sprint/WEB-INF/classes/etu1812/framework/servlet"),"etu1812.framework.servlet");
            //out.println(classes.get(0).getName());
            System.out.println("mety");
            HashMap<String,Mapping> MappingUrls = Util.getHashMap();
            
            Util.afficher_MappingUrls(MappingUrls);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
