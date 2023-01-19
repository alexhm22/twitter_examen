package com.vaadin.vaadinarchetypeapplication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeerJson {

    public ArrayList<Tweet> leeFicheroJson(){
        try {
            //lee el fichero que le pasamos y lo carga en un reader
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(getClass().getClassLoader().getResourceAsStream("pokemonConId.json")));
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
