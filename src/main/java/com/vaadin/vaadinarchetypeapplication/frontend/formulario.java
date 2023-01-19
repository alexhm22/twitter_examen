package com.vaadin.vaadinarchetypeapplication.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.vaadinarchetypeapplication.Tweet;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class formulario {

    public static class Formulario extends VerticalLayout {

        private TextField usuario = new TextField("usuario");
        private TextField tweet = new TextField("tweet");
        private DatePicker fecha = new DatePicker("fecha");

        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        private Button guardar = new Button("Guardar");

        public Formulario() {
            add(usuario, tweet, fecha);
            guardar.addClickListener(e -> guardarTweet());
            add(guardar);
        }




        private void guardarTweet() {
            RestTemplate restTemplate = new RestTemplate();
            Tweet nuevoTweet = new Tweet();
            nuevoTweet.setUsuario(usuario.getValue());
            nuevoTweet.setTweet(tweet.getValue());
            nuevoTweet.setFecha(fecha.getValue().format(formatter).toString());
            restTemplate.postForEntity("http://localhost:8080/POST", nuevoTweet, Tweet.class);
        }
    }



}
