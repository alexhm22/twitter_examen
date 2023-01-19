package com.vaadin.vaadinarchetypeapplication.backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vaadin.vaadinarchetypeapplication.Tweet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LeerJson {

    public ArrayList<Tweet> leeFicheroJson(){
        try {
            //lee el fichero que le pasamos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/twitter.json"));
            // convierte el array JSON a un arraylist de users
            ArrayList<Tweet> listaTweet = new Gson().fromJson(reader, new TypeToken<ArrayList<Tweet>>() {}.getType());
            reader.close();// close reader
            return listaTweet;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>(); //si no ha leido nada, devuelve un array vacio
        }












    }

}

