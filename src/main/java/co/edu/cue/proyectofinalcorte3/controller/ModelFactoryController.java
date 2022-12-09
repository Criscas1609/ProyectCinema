package co.edu.cue.proyectofinalcorte3.controller;
import co.edu.cue.proyectofinalcorte3.model.*;
import co.edu.cue.proyectofinalcorte3.service.*;
import co.edu.cue.proyectofinalcorte3.service.impl.TheaterServiceImpl;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.io.IOException;
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
    public void addClient(String name, String id, String lastName, String birthday, String phoneNumber, String address, ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().addClient(name, id, lastName, birthday, phoneNumber, address, clientsView, tblClient);
    }
    public void showTbl(ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().showTbl(clientsView,tblClient);
    }

    public void selectClient(TextField nameClient, TextField lastName, TextField idClient, TextField phoneCliente, TextField emailCliente, DatePicker birthday, ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().selectClient(nameClient, lastName, idClient, phoneCliente, emailCliente, birthday, clientsView, tblClient);
    }

    public void deleteClient(ObservableList<Client> clientsView, TableView<Client> tblClient){
        theater.getClientService().deleteClient(clientsView,tblClient);
    }
    public void editClient(ObservableList<Client> clientsView, TableView<Client> tblClient,Client aux){
        theater.getClientService().editClient(clientsView,tblClient,aux);
    }
    public void search(TableView<Client> tblClient, String search){
        theater.getClientService().search(tblClient,search);
    }
    public void stringId(ArrayList<String> idlist){
        theater.getClientService().stringId(idlist);
    }

    //Ticketes
    public void loadChairs(ArrayList<Button> chairs, String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView){
        theater.getTicketService().loadChairs(chairs,movie,ticketList,ticketsView);
    }
    public void chairMovie(String movie, String chair, double price, ArrayList<Button> chairs, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView ) throws IOException {
        theater.getTicketService().chairMovie(movie,chair,price,chairs,ticketList,ticketsView);
    }
    //Pestaña Venta
    public void tblSell(String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView){
        theater.getSellService().tblSell(movie,ticketList,ticketsView);
    }

    public void foodTbl(String movie,TableView<Food> foodTbl,String food,double price,ObservableList<Food> foodView){
        theater.getSellService().foodTbl(movie,foodTbl,food,price,foodView);
    }

    public void deleteAll(String movie,ArrayList<Button> chair){
        theater.getTicketService().deleteAll(movie,chair);
    }
    public void clearList(){
        theater.getTicketService().clearList();
    }
    public void validateClient(String member, String id,String name){
        theater.getSellService().validateClient(member, id, name);
    }
    public void createDetal(String movie){
        theater.getSellService().createDetal(movie);
    }

    //Venta Finalizada
    public void informationMovie(Label movie,Label information){
        theater.getInvoiceService().informationMovie(movie,information);
    }
    public void deleteTbl(){
        theater.getSellService().deleteTbl();
    }

    //Reportes
    public void showInfo(Label movieLabel1, Label movieLabel2, Label movieLabel3, Label movieLabel4){
        theater.getTicketService().showInfo(movieLabel1,movieLabel2,movieLabel3,movieLabel4);
    }
    public void showClients(Label clientLabel){
        theater.getClientService().showClients(clientLabel);
    }
    public void showTotal(Label totalDetail){
        theater.getSellService().showTotal(totalDetail);
    }

    //Persistencia
    public void loadPersistence(){
        theater.getTicketService().loadPersistence();
    }
    public void savePersistence(){
        theater.getTicketService().savePersistence();
    }
    public void saveClients() throws IOException {
        theater.getClientService().saveClients();
    }
    public void loadClients(){
        theater.getClientService().loadClients();
    }


}
