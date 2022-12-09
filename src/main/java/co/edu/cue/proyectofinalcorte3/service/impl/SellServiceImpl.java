package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.*;
import co.edu.cue.proyectofinalcorte3.persistence.Persistence;
import co.edu.cue.proyectofinalcorte3.service.SellService;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Objects;

public class SellServiceImpl implements SellService {

    private static final ArrayList<Food> foodList = new ArrayList<Food>();
    private static ArrayList<Detail> detailList = new ArrayList<Detail>();

    public static ArrayList<Detail> getDetailList() {
        return detailList;
    }

    ArrayList<Ticket> clientSeat;
    ArrayList<Client> clientList;
    Person clientDetail;
    Food foodAux;



    public void showTbl(TableView<Ticket> ticketList,ArrayList<Ticket> movie,ObservableList<Ticket> ticketsView){
        ticketsView.clear();
        for (Ticket tickets :movie) {
            ticketsView.add(tickets);
            ticketList.setItems(ticketsView);
            ticketList.refresh();
        }
    }

    //Funciones de la vista Sell

    public void tblSell(String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView) {
        getData();
        showTbl(ticketList,clientSeat,ticketsView);
    }
    public void foodTbl(String movie,TableView<Food> foodTbl,String food,double price,ObservableList<Food> foodView) {
        foodAux = new Food(food, price);
        foodList.add(foodAux);
        foodView.add(foodAux);
        foodTbl.setItems(foodView);
        foodTbl.refresh();

    }

    public void validateClient(String member, String id,String name){
        if(Objects.equals(member, "")){
            clientDetail = new Person(name,id);
        }else{
            for(Client client: clientList){
                if (client.getId().equals(member)){
                    clientDetail = new Person(client.getName(), client.getId());
                }
            }
        }
    }


    public void createDetal(String movie){
        Detail detail = new Detail(clientSeat,foodList,clientDetail,movie);
        detailList.add(detail);
    }

    public void getData(){
        clientSeat = TicketServiceImpl.getClientSeat();
        clientList = ClientServiceImpl.getListClients();
    }



    //Factura
    public void deleteTbl(){
        foodList.clear();
    }

    public void showTotal(Label totalDetail){
        totalDetail.setText(String.valueOf(detailList.size()));
    }



}
