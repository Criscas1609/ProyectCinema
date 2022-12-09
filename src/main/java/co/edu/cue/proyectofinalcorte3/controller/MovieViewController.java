package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.controller.TicketViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MovieViewController {


    private static String movie;
    private static String time;
    private static String showTime;


    public static String getMovie() {
        return movie;
    }

    public static String getTime() {
        return time;
    }

    public static String getShowTime() {
        return showTime;
    }

    @FXML
    void clientView(ActionEvent event) throws IOException {
        HelloApplication.clientsViews(event);

    }

    @FXML
    void loginView(ActionEvent event) throws IOException {
        HelloApplication.loginViews(event);

    }

    @FXML
    void mainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }

    @FXML
    void movie1(ActionEvent event) throws IOException {
        movie = "Wakanda por siempre";
        time = "Duración: 2h 41m";
        showTime = "Hora de la función: 2:00pm";
        HelloApplication.ticketsView(event);

    }

    @FXML
    void movie2(ActionEvent event) throws IOException {
        movie = "Strange world";
        time = "Duración: 1h 42m";
        showTime = "Hora de la función: 5:00pm";
        HelloApplication.ticketsView(event);

    }

    @FXML
    void movie3(ActionEvent event) throws IOException {
        movie = "Black Adam";
        time = "Duración: 2h 05m";
        showTime = "Hora de la función: 7:00pm";
        HelloApplication.ticketsView(event);

    }

    @FXML
    void movie4(ActionEvent event) throws IOException {
        movie = "Avatar 2";
        time = "Duración: 3h 12m";
        showTime = "Hora de la función: 9:30pm";
        HelloApplication.ticketsView(event);
    }

    @FXML
    void moviesView(ActionEvent event) throws IOException {
        HelloApplication.moviesViews(event);

    }

    @FXML
    void userView(ActionEvent event) {

    }

}

