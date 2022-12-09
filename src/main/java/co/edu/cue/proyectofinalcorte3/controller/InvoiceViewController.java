package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InvoiceViewController implements Initializable {

    ModelFactoryController mfc= ModelFactoryController.getInstance();

    @FXML
    private Label client;

    @FXML
    private Label invoice;

    @FXML
    void loginView(ActionEvent event) throws IOException {
        mfc.deleteTbl();
        mfc.clearList();
        mfc.savePersistence();
        HelloApplication.mainViews(event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showInvoice();
    }

    void showInvoice() {
        mfc.informationMovie(invoice,client);
    }

}

