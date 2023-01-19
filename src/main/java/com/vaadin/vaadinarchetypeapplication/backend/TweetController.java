package com.vaadin.vaadinarchetypeapplication.backend;

import com.vaadin.vaadinarchetypeapplication.Tweet;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TweetController {

    @GetMapping("/GET")
    public ArrayList<Tweet> GET(){
        ArrayList<Tweet> listaTweet = new LeerJson().leeFicheroJson();
    return listaTweet;
    }

    @PostMapping("/POST")
    public ResponseEntity<Tweet> POST(@RequestBody @NonNull Tweet tweet){
        tweet = new TweetService().AltaTweet(tweet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/DELETE/{tweetId}")
    public ResponseEntity<Tweet> DELETE(@PathVariable int tweetId){
        new TweetService().DeleteTweet(tweetId);
        return ResponseEntity.ok().build();
    }


}
