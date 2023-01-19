package com.vaadin.vaadinarchetypeapplication;

import java.util.Date;

public class Tweet {
    private int id;
    private String usuario;
    private String tweet;
    private String fecha;

    public Tweet(int id, String usuario,String tweet, String fecha){
        this.id = id;
        this.usuario = usuario;
        this.tweet = tweet;
        this.fecha = fecha;
    }

    public Tweet(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
