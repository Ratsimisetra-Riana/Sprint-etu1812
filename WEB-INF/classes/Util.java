package utils;

public class Util {
    
    public Util(){

    }

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
}
