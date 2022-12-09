package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.exeptions.AllExeption;
import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.TextFields;

//import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellViewController implements Initializable {
    ModelFactoryController mfc= ModelFactoryController.getInstance();

    ObservableList<Food> foodView = FXCollections.observableArrayList();
    ArrayList<String> listID = new ArrayList<String>();

    String id;
    String member;
    String name;

    @FXML
    private TableColumn<?, ?> colFood;

    @FXML
    private TableColumn<?, ?> colFoodPrice;
    @FXML
    private TableView<Food> foodTblView;
    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colChair;
    @FXML
    private TableView<Ticket> tblView;
    @FXML
    private Label showTime;

    @FXML
    private Label timeOfMovie;

    @FXML
    private TextField idClient;

    @FXML
    private TextField idMember;

    @FXML
    private TextField nameClient;

    @FXML
    private Label nameMovie;

    @FXML
    void popCorn(ActionEvent event) {
        String name = "Palomitas";
        double price = 7500;
        mfc.foodTbl(nameMovie.getText(),foodTblView,name,price,foodView);
    }

    @FXML
    void deleteAll(ActionEvent event) {
        mfc.deleteTbl();
        foodView.clear();

    }

    @FXML
    void drink(ActionEvent event) {
        String name = "Gaseosa";
        double price = 5000;
        mfc.foodTbl(nameMovie.getText(),foodTblView,name,price,foodView);
    }

    @FXML
    void movieView(ActionEvent event) throws IOException {
        getText();
        boolean a = AllExeption.inputSell(member,id,name);
        if (a) {
            mfc.validateClient(member, id, name);
            mfc.createDetal(nameMovie.getText());
            HelloApplication.invoicesView(event);
        }


    }

    @FXML
    void ticketView(ActionEvent event) throws IOException {
        HelloApplication.ticketsView(event);
    }
    int x;
    @FXML
    void onlyNumber(KeyEvent event) {
        try {
            x = Integer.parseInt(idClient.getText());
        } catch (NumberFormatException nfe) {
            idClient.setText("");
        }
        try {
            x = Integer.parseInt(idMember.getText());
        } catch (NumberFormatException nfe) {
            idMember.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idSearch();
        TextFields.bindAutoCompletion(idMember,listID);
        nameMovie.setText(MovieViewController.getMovie());
        showTime.setText(MovieViewController.getShowTime());
        timeOfMovie.setText(MovieViewController.getTime());
        colChair.setCellValueFactory(new PropertyValueFactory<>("chair"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colFood.setCellValueFactory(new PropertyValueFactory<>("food"));
        colFoodPrice.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
        tblSell();

    }
    void tblSell(){
        mfc.tblSell(nameMovie.getText(),tblView,TicketViewController.getTicketsView());
    }
    void idSearch(){
        mfc.stringId(listID);
    }
    void getText(){
        member = idMember.getText();
        id = idClient.getText();
        name = nameClient.getText();
    }
}
