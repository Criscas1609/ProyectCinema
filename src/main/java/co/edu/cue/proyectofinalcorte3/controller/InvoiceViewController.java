package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class InvoiceViewController {

    ModelFactoryController mfc= ModelFactoryController.getInstance();

    @FXML
    private Label client;

    @FXML
    private Label invoice;

    @FXML
    void loginView(ActionEvent event) throws IOException {
        mfc.deleteTbl();
        mfc.clearList();
        HelloApplication.mainViews(event);

    }

}

