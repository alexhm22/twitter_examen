package com.vaadin.vaadinarchetypeapplication.frontend;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("AltaTweet")
@Route(value = "AltaTweet", layout = MainView.class)
public class AltaTweet extends VerticalLayout {

    public AltaTweet() {
        formulario.Formulario formulario = new formulario.Formulario();
        add(formulario);
    }
}
