package com.vaadin.vaadinarchetypeapplication.frontend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.vaadinarchetypeapplication.Tweet;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static java.awt.AWTEventMulticaster.add;


@PageTitle("ListadoTweets")
@Route(value = "ListadoTweets", layout = MainView.class)

public class ListadoTweets extends VerticalLayout {

    Grid<Tweet> grid=new Grid<>(Tweet.class);

    public ListadoTweets() {

        addClassName("List-view");
        setSizeFull();

        configureGrid(); //Grid de datos
        add(
                getToolbar(),
                getContent()
        );


    }

    private Component getToolbar() {
        Button DeleteTweet = new Button("Eliminar Tweet seleccionado");
        DeleteTweet.addClickListener(e -> eliminarTweetSeleccionado());
        HorizontalLayout toolbar=new HorizontalLayout(DeleteTweet);
        toolbar.addClassName("Toolbar");
        return toolbar;
    }

    private void eliminarTweetSeleccionado() {
        Tweet tweetSeleccionado = grid.getSelectedItems().iterator().next();
        int tweetId = tweetSeleccionado.getId();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/DELETE/{tweetId}", tweetId);


        configureGrid();
    }
    private Component getContent() {
        HorizontalLayout content= new HorizontalLayout(grid);
        content.setFlexGrow(2,grid);
        content.addClassName("contect");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Tweet>> response = restTemplate.exchange("http://localhost:8080/GET", HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Tweet>>() {});
        ArrayList<Tweet> listaTweet = response.getBody();
        grid.addClassName("contact-grid");
        grid.setSizeFull();

        grid.setColumns("id","usuario","tweet","fecha");
        grid.setItems(listaTweet);
    }


}
