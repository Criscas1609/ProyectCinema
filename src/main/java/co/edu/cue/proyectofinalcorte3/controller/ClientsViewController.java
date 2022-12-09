package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.exeptions.AllExeption;
import co.edu.cue.proyectofinalcorte3.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientsViewController implements Initializable {

    ObservableList<Client> clientsView = FXCollections.observableArrayList();

    ModelFactoryController mfc= ModelFactoryController.getInstance();

    String name;
    String lastName;
    String id;
    String email;
    String birthday;
    String phone;

    @FXML
    private TextField idClient;

    @FXML
    private DatePicker birthdayClient;

    @FXML
    private TableColumn<?, ?> colDay;

    @FXML
    private TableColumn<?, ?> colEmail;


    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private Button createButton;

    @FXML
    private TextField emailClient;

    @FXML
    private TextField inputSearch;

    @FXML
    private TextField lastNameClient;

    @FXML
    private TextField nameClient;

    @FXML
    private TextField phoneClient;



    @FXML
    private TableView<Client> tblClient;

    @FXML
    void ClientsView(ActionEvent event) throws IOException {
        mfc.saveClients();
        HelloApplication.clientsViews(event);

    }

    @FXML
    void MoviesView(ActionEvent event) throws IOException {
        mfc.saveClients();
        HelloApplication.moviesViews(event);
    }

    @FXML
    void loginView(ActionEvent event) throws IOException {
        mfc.saveClients();
        HelloApplication.loginViews(event);
    }

    @FXML
    void mainView(ActionEvent event) throws IOException {
        mfc.saveClients();
        HelloApplication.mainViews(event);
    }

    @FXML
    void userView(ActionEvent event) throws IOException {
        mfc.saveClients();
        HelloApplication.usersView(event);
    }

    @FXML
    void create(ActionEvent event) {
        getData();
        boolean a = AllExeption.fieldClient(name,id,lastName,birthday,phone,email);
        boolean b = AllExeption.birthday(birthday);
        if(a && b) {
            mfc.addClient(name,id,lastName,birthday,phone,email,clientsView,tblClient);
        }

    }

    @FXML
    void delete(ActionEvent event) {
        mfc.deleteClient(clientsView,tblClient);
    }

    @FXML
    void edit(ActionEvent event) {
        getData();
        boolean a = AllExeption.fieldClient(name,id,lastName,birthday,phone,email);
        boolean b = AllExeption.birthday(birthday);
        if(a && b) {
            Client aux = new Client(name, id, lastName, birthday, phone, email);
            mfc.editClient(clientsView, tblClient, aux);
        }

    }
    double x;
    @FXML
    void onlyNumbers(KeyEvent event) {
        try {
            x = Integer.parseInt(idClient.getText());
        } catch (NumberFormatException nfe) {
            idClient.setText("");
        }
        try {
            x = Integer.parseInt(phoneClient.getText());
        } catch (NumberFormatException nfe) {
            phoneClient.setText("");
        }
    }


    @FXML
    void search(ActionEvent event) {
        String search = inputSearch.getText();
        mfc.search(tblClient,search);
    }

    @FXML
    void select(ActionEvent event) {
        mfc.selectClient(nameClient,lastNameClient,idClient,phoneClient,emailClient,birthdayClient,clientsView,tblClient);
    }

    void getData() {
        name = nameClient.getText();
        lastName = lastNameClient.getText();
        id = idClient.getText();
        phone = phoneClient.getText();
        email = emailClient.getText();
        birthday = String.valueOf(birthdayClient.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDay.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("address"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        showTbl();
    }

    void showTbl(){
        mfc.showTbl(clientsView,tblClient);
    }


}

