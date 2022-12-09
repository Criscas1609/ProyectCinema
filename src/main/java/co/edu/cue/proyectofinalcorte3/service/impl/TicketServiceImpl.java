package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.Client;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import co.edu.cue.proyectofinalcorte3.service.TicketService;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class TicketServiceImpl implements TicketService {

    private final ArrayList<Ticket> movie1 = new ArrayList<Ticket>(); //Wakanda
    private final ArrayList<Ticket> movie2 = new ArrayList<Ticket>(); //Strange World
    private final ArrayList<Ticket> movie3 = new ArrayList<Ticket>(); //Black Adam
    private final ArrayList<Ticket> movie4 = new ArrayList<Ticket>(); //Avatar
    private static final ArrayList<Ticket> clientSeat = new ArrayList<Ticket>(); //Sillas del cliente

    public static ArrayList<Ticket> getClientSeat() {return clientSeat;}

    Ticket ticket;



    public void loadChairs(ArrayList<Button> chairs, String movie, TableView<Ticket> ticketList, ObservableList<Ticket> ticketsView){
        switch (movie){
            case "Wakanda por siempre":
                showChairs(chairs,movie1);
                showTbl(ticketList,clientSeat,ticketsView);
                break;
            case "Strange world":
                showChairs(chairs,movie2);
                showTbl(ticketList,clientSeat,ticketsView);
                break;
            case "Black Adam":
                showChairs(chairs,movie3);
                showTbl(ticketList,clientSeat,ticketsView);
                break;
            case "Avatar 2":
                showChairs(chairs,movie4);
                showTbl(ticketList,clientSeat,ticketsView);
                break;
        }
    }

    public void chairMovie(String movie,String chair,double price,ArrayList<Button> chairs,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView){
        ticket = new Ticket(chair,price);
        switch (movie) {
            case "Wakanda por siempre":
                movie1.add(ticket);
                clientSeat.add(ticket);
                break;
            case "Strange world":
                movie2.add(ticket);
                clientSeat.add(ticket);
                break;
            case "Black Adam" :
                movie3.add(ticket);
                clientSeat.add(ticket);
                break;
            case "Avatar 2" :
                movie4.add(ticket);
                clientSeat.add(ticket);
                break;
        }
        loadChairs(chairs,movie,ticketList,ticketsView);
    }



    public void showTbl(TableView<Ticket> ticketList,ArrayList<Ticket> movie,ObservableList<Ticket> ticketsView){
        ticketsView.clear();
        for (Ticket tickets :movie) {
            ticketsView.add(tickets);
            ticketList.setItems(ticketsView);
            ticketList.refresh();
        }
    }

    public void showChairs(ArrayList<Button> chair,ArrayList<Ticket> movie) {
        for (Ticket movies : movie) {
            for (Button chairs : chair) {
                if (chairs.getText().equals(movies.getChair())) {
                    chairs.setOpacity(-1);
                }
            }
        }
    }

    public void deleteAll(String movie,ArrayList<Button> chair){
        switch (movie) {
            case "Wakanda por siempre":
                delete(movie1,chair);
                break;
            case "Strange world":
                delete(movie2,chair);
                break;
            case "Black Adam" :
                delete(movie3,chair);
                break;
            case "Avatar 2" :
                delete(movie4,chair);
                break;
        }
    }
    public void delete(ArrayList<Ticket> movie,ArrayList<Button> chair){
        for (Button chairs : chair) {
            for (Ticket client: clientSeat){
                movie.remove(client);
                chairs.setOpacity(1);
            }
        }
        clientSeat.clear();
    }

    public void clearList(){
        clientSeat.clear();
    }


}
