package edu.tallerjava.controladores;

public class Hi {
    private String name;
    private String hi;

    public Hi(String name, String hi){
        this.name = name;
        this.hi = hi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }
}
