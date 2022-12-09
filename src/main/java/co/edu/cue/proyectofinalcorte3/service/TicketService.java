package co.edu.cue.proyectofinalcorte3.service;

import co.edu.cue.proyectofinalcorte3.model.Ticket;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;

public interface TicketService {
    void loadChairs(ArrayList<Button> chairs, String movie, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView);
    void chairMovie(String movie,String chair,double price,ArrayList<Button> chairs,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView) throws IOException;
    void showTbl(TableView<Ticket> ticketList,ArrayList<Ticket> movie,ObservableList<Ticket> ticketsView);
    void deleteAll(String movie,ArrayList<Button> chair);
    void clearList();
    void showInfo(Label movieLabel1, Label movieLabel2, Label movieLabel3, Label movieLabel4);
    void loadPersistence();
    void savePersistence();
}
