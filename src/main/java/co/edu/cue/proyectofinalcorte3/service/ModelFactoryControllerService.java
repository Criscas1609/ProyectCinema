package co.edu.cue.proyectofinalcorte3.service;

import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public interface ModelFactoryControllerService {

    //Login
    Boolean login(String userRegis, String passwordRegis);

    //Cliente
    void addClient(String name, String id, String lastName, String birthday, String phoneNumber, String address, ObservableList<Client> clientsView, TableView<Client> tblClient);
    void showTbl(ObservableList<Client> clientsView, TableView<Client> tblClient);
    void selectClient(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday, ObservableList<Client> clientsView, TableView<Client> tblClient);
    void deleteClient(ObservableList<Client> clientsView, TableView<Client> tblClient);
    void editClient(ObservableList<Client> clientsView, TableView<Client> tblClient,Client aux);
    void search(TableView<Client> tblClient, String search);
    void stringId(ArrayList<String> idlist);
    void showClients(Label clientLabel);
    void saveClients() throws IOException;
    void loadClients();

    //Factura
    void informationMovie(Label movie,Label information);

    //Venta
    void tblSell(String movie, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView);
    void foodTbl(String movie, TableView<Food> foodTbl, String food, double price, ObservableList<Food> foodView);
    void validateClient(String member, String id,String name);
    void createDetal(String movie);
    void deleteTbl();
    void showTotal(Label totalDetail);

    //Sillas
    void loadChairs(ArrayList<Button> chairs, String movie, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView);
    void chairMovie(String movie,String chair,double price,ArrayList<Button> chairs,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView) throws IOException;
    void deleteAll(String movie,ArrayList<Button> chair);
    void clearList();
    void showInfo(Label movieLabel1, Label movieLabel2, Label movieLabel3, Label movieLabel4);
    void loadPersistence();
    void savePersistence();

}
