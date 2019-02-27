package com.example.t25alpha;

public class BDModelo {
    private String usuario, password;

    public BDModelo(){

    }

    public BDModelo(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuari(){
        return usuario;
    }

    public void setUsuari(String usuario){
        this.usuario = usuario;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
