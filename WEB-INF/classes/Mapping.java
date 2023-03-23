package etu1812.framework;

public class Mapping {
    
    String className=null;
    String Method=null;

    public Mapping(String c,String m){
        this.className = c;
        this.Method = m;
    }

    public String getClassName() {
        return className;
    }

    public String getMethod() {
        return Method;
    }
}
