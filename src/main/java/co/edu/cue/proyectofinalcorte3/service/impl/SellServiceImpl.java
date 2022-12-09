package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import co.edu.cue.proyectofinalcorte3.service.SellService;
import co.edu.cue.proyectofinalcorte3.service.TicketService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Stylesheet;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

public class SellServiceImpl implements SellService {


    private final ArrayList<Food> foodList = new ArrayList<Food>();
    ArrayList<Ticket> clientSeat;
    List<Client> clientList;



    //Funciones de la vista ticket

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
        Food foodAux = new Food(food, price);
        foodList.add(foodAux);
        foodView.add(foodAux);
        foodTbl.setItems(foodView);
        foodTbl.refresh();

    }

    public void getData(){
        clientSeat = TicketServiceImpl.getClientSeat();
        //clientList = ClientServiceImpl.getListClients();
    }




    //Factura
    public void deleteTbl(){
        foodList.clear();
    }

}
