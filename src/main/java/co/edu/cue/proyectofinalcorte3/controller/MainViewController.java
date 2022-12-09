package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainViewController {

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
    void shopView(ActionEvent event) throws IOException {
        HelloApplication.moviesViews(event);

    }

    @FXML
    void userView(ActionEvent event) {

    }

}
