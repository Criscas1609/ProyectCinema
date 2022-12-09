package co.edu.cue.proyectofinalcorte3.controller;
import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import co.edu.cue.proyectofinalcorte3.service.*;
import co.edu.cue.proyectofinalcorte3.service.impl.TheaterServiceImpl;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class ModelFactoryController implements ModelFactoryControllerService {

    TheaterServiceImpl theater;
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        theater = new TheaterServiceImpl();
    }

    //Funciones del Login
    public Boolean login(String userRegis, String passwordRegis){
        return theater.getLoginService().login(userRegis, passwordRegis);
    }

    //Funciones del Cliente
    void addClient(String name, String id, String lastName, String birthday, String phoneNumber, String address, ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().addClient(name, id, lastName, birthday, phoneNumber, address, clientsView, tblClient);
    }
    void showTbl(ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().showTbl(clientsView,tblClient);
    }

    void selectClient(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday, ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().selectClient(nameClient, lastName, idClient, phoneCliente, emailCliente, birthday, clientsView, tblClient);
    }

    void deleteClient(ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().deleteClient(clientsView,tblClient);
    }
    void editClient(ObservableList<Client> clientsView, TableView<Client> tblClient,Client aux){
        theater.getClientService().editClient(clientsView,tblClient,aux);
    }
    void search(TableView<Client> tblClient, String search){
        theater.getClientService().search(tblClient,search);
    }

    //Ticketes
    void loadChairs(ArrayList<Button> chairs, String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView){
        theater.getTicketService().loadChairs(chairs,movie,ticketList,ticketsView);
    }
    void chairMovie(String movie, String chair, double price, ArrayList<Button> chairs, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView ){
        theater.getTicketService().chairMovie(movie,chair,price,chairs,ticketList,ticketsView);
    }
    //Pestaña Venta
    void tblSell(String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView){
        theater.getSellService().tblSell(movie,ticketList,ticketsView);
    }

    void foodTbl(String movie,TableView<Food> foodTbl,String food,double price,ObservableList<Food> foodView){
        theater.getSellService().foodTbl(movie,foodTbl,food,price,foodView);
    }

    void deleteAll(String movie,ArrayList<Button> chair){
        theater.getTicketService().deleteAll(movie,chair);
    }
    void clearList(){
        theater.getTicketService().clearList();
    }

    //Venta Finalizada
    void deleteTbl(){
        theater.getSellService().deleteTbl();
    }

}
