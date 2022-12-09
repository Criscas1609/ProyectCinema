package co.edu.cue.proyectofinalcorte3.controller;

import co.edu.cue.proyectofinalcorte3.HelloApplication;
import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TicketViewController implements Initializable {

    static ObservableList<Ticket> ticketsView = FXCollections.observableArrayList();

    public static ObservableList<Ticket> getTicketsView() {
        return ticketsView;
    }



    ModelFactoryController mfc= ModelFactoryController.getInstance();

    ArrayList<Button> chairs = new ArrayList<Button>();

    @FXML
    private TableColumn<?, ?> colChair;

    @FXML
    private TableColumn<?, ?> colPrice;


    @FXML
    private Button A1;

    @FXML
    private Button A2;

    @FXML
    private Button A3;

    @FXML
    private Button A4;

    @FXML
    private Button A5;

    @FXML
    private Button A6;

    @FXML
    private Button B1;

    @FXML
    private Button B2;

    @FXML
    private Button B3;

    @FXML
    private Button B4;

    @FXML
    private Button B5;

    @FXML
    private Button B6;

    @FXML
    private Button C1;

    @FXML
    private Button C2;

    @FXML
    private Button C3;

    @FXML
    private Button C4;

    @FXML
    private Button C5;

    @FXML
    private Button C6;

    @FXML
    private Button D1;

    @FXML
    private Button D2;

    @FXML
    private Button D3;

    @FXML
    private Button D4;

    @FXML
    private Button D5;

    @FXML
    private Button D6;
    @FXML
    private Label nameMovie;

    @FXML
    private Label showTime;

    @FXML
    private Label timeOfMovie;


    @FXML
    private TableView<Ticket> tblView;


    @FXML
    void sellView(ActionEvent event) throws IOException {
        chairs.clear();
        HelloApplication.sellsView(event);
    }



    @FXML
    void chair(ActionEvent event) {

        String chair = event.getSource().toString();
        String[] sillas = chair.split("'");
        chair = sillas[1];
        double price = 10000;
        mfc.chairMovie(nameMovie.getText(), chair,price,chairs,tblView,ticketsView);


    }

    @FXML
    void movieView(ActionEvent event) throws IOException {
        mfc.deleteAll(nameMovie.getText(),chairs);
        chairs.clear();
        ticketsView.clear();
        HelloApplication.moviesViews(event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameMovie.setText(MovieViewController.getMovie());
        showTime.setText(MovieViewController.getShowTime());
        timeOfMovie.setText(MovieViewController.getTime());
        colChair.setCellValueFactory(new PropertyValueFactory<>("chair"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        addChairsColumn1();
        addChairsColumn2();
        addChairsColumn3();
        addChairsColumn4();
        loadChair();



    }
    public void addChairsColumn1(){
        chairs.add(A1);
        chairs.add(A2);
        chairs.add(A3);
        chairs.add(A4);
        chairs.add(A5);
        chairs.add(A6);
    }
    public void addChairsColumn2(){
        chairs.add(B1);
        chairs.add(B2);
        chairs.add(B3);
        chairs.add(B4);
        chairs.add(B5);
        chairs.add(B6);
    }
    public void addChairsColumn3(){
        chairs.add(C1);
        chairs.add(C2);
        chairs.add(C3);
        chairs.add(C4);
        chairs.add(C5);
        chairs.add(C6);
    }
    public void addChairsColumn4(){
        chairs.add(D1);
        chairs.add(D2);
        chairs.add(D3);
        chairs.add(D4);
        chairs.add(D5);
        chairs.add(D6);
    }

    public void loadChair(){
        mfc.loadChairs(chairs, nameMovie.getText(),tblView,ticketsView);
    }




    
}
