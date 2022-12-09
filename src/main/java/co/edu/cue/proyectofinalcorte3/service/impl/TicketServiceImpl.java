package co.edu.cue.proyectofinalcorte3.service.impl;
import co.edu.cue.proyectofinalcorte3.persistence.*;
import co.edu.cue.proyectofinalcorte3.model.Ticket;
import co.edu.cue.proyectofinalcorte3.exeptions.AllExeption;
import co.edu.cue.proyectofinalcorte3.service.TicketService;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.controlsfx.validation.ValidateEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static co.edu.cue.proyectofinalcorte3.persistence.Persistence.*;

public class TicketServiceImpl implements TicketService {

    private ArrayList<Ticket> movie1 = new ArrayList<Ticket>(); //Wakanda
    private ArrayList<Ticket> movie2 = new ArrayList<Ticket>(); //Strange World
    private ArrayList<Ticket> movie3 = new ArrayList<Ticket>(); //Black Adam
    private ArrayList<Ticket> movie4 = new ArrayList<Ticket>(); //Avatar
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

    public void chairMovie(String movie,String chair,double price,ArrayList<Button> chairs,TableView<Ticket> ticketList,ObservableList<Ticket> ticketsView) throws IOException {
        ticket = new Ticket(chair,price);
        switch (movie) {
            case "Wakanda por siempre":
                cloneTicket(movie1,ticket);
                break;
            case "Strange world":
                cloneTicket(movie2,ticket);
                break;
            case "Black Adam" :
                cloneTicket(movie3,ticket);
                break;
            case "Avatar 2" :
                cloneTicket(movie4,ticket);
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
                    chairs.setStyle("-fx-border-color: none");
                    chairs.setStyle("-fx-background-color: red");
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
                chairs.setStyle("-fx-border-color: green");
                chairs.setStyle("-fx-background-color: green");
            }
        }
        clientSeat.clear();
    }

    public void clearList(){
        clientSeat.clear();
    }

    public void showInfo(Label movieLabel1, Label movieLabel2, Label movieLabel3, Label movieLabel4){
        movieLabel1.setText(String.valueOf(movie1.size()));
        movieLabel2.setText(String.valueOf(movie2.size()));
        movieLabel3.setText(String.valueOf(movie3.size()));
        movieLabel4.setText(String.valueOf(movie4.size()));
    }

    //Validar no películas repetidas

    public void cloneTicket(ArrayList<Ticket> movie,Ticket ticket){
        boolean b = AllExeption.validator1(movie,ticket);
        boolean c = AllExeption.validator2(clientSeat);
        if(!b && !c){
            movie.add(ticket);
            clientSeat.add(ticket);
        }

    }


    //Persistencia
    public void loadPersistence() {
        try {
            movie1 = cargarClientes("Wakanda por siempre");
            movie2 = cargarClientes("Strange world");
            movie3 = cargarClientes("Black Adam");
            movie4 = cargarClientes("Avatar 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void savePersistence() {
        try {
            saveMovie(movie1, "Wakanda por siempre");
            saveMovie(movie2, "Strange world");
            saveMovie(movie3, "Black Adam");
            saveMovie(movie4, "Avatar 2");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
