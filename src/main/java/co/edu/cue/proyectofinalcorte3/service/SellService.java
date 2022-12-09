package co.edu.cue.proyectofinalcorte3.service;

import co.edu.cue.proyectofinalcorte3.model.Food;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public interface SellService {
    void tblSell(String movie,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView);

    void showTbl(TableView<Ticket> ticketList,ArrayList<Ticket> movie,ObservableList<Ticket> ticketsView);

    //Vista de la Venta
    void foodTbl(String movie,TableView<Food> foodTbl,String food,double price,ObservableList<Food> foodView);

    //Venta finalizada
    void deleteTbl();
}
