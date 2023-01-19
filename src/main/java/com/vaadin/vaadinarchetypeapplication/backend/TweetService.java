package com.vaadin.vaadinarchetypeapplication.backend;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vaadin.vaadinarchetypeapplication.Tweet;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;


public class TweetService {
    
    public Tweet AltaTweet(Tweet tweet) {
        Gson gson = new Gson();
        ArrayList<Tweet> listaTweet = new LeerJson().leeFicheroJson();

        listaTweet = actualizarIds(listaTweet);
        int maxid = listaTweet.size() + 1;
        tweet.setId(maxid);
        listaTweet.add(tweet);


        try {
            FileWriter writer = new FileWriter("./src/main/resources/twitter.json");
            writer.write(gson.toJson(listaTweet));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


            return tweet;
    }

    public void DeleteTweet(int tweetId) {
        Gson gson = new Gson();
        ArrayList<Tweet> listaTweet = new LeerJson().leeFicheroJson();
        ArrayList<Tweet> listaFinal = new ArrayList<Tweet>();


        for (Tweet tweet : listaTweet) {
            if(tweet.getId() != tweetId){
                listaFinal.add(tweet);
            }
        }
        listaFinal = actualizarIds(listaFinal);


        try {
            FileWriter writer = new FileWriter("./src/main/resources/twitter.json");
            writer.write(gson.toJson(listaFinal));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tweet> actualizarIds(ArrayList<Tweet> listaTweets) {
        for (int i = 0; i < listaTweets.size(); i++) {
            listaTweets.get(i).setId(i + 1);
        }
        return listaTweets;
    }
}
