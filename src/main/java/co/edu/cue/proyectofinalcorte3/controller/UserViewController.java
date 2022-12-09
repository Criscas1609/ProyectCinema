package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    @FXML
    private Label movie1;

    @FXML
    private Label movie2;

    @FXML
    private Label movie3;

    @FXML
    private Label movie4;

    @FXML
    private Label totalClient;

    @FXML
    private Label totalDetail;

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
    void moviesView(ActionEvent event) throws IOException {
        HelloApplication.moviesViews(event);

    }

    @FXML
    void userView(ActionEvent event) throws IOException {
        HelloApplication.usersView(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showInfo();
    }
    void showInfo() {
        mfc.showInfo(movie1,movie2,movie3,movie4);
        mfc.showClients(totalClient);
        mfc.showTotal(totalDetail);
    }
}