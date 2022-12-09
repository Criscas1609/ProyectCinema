package co.edu.cue.proyectofinalcorte3.model;

import java.util.ArrayList;

public class Detail {
    private ArrayList<Ticket> clientSeat;
    private ArrayList<Food> foodList;
    private Person client;
    private String movie;

    public Detail(ArrayList<Ticket> clientSeat, ArrayList<Food> foodList, Person client, String movie) {
        this.clientSeat = clientSeat;
        this.foodList = foodList;
        this.client = client;
        this.movie = movie;
    }

    public Detail() {
        super();
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public ArrayList<Ticket> getClientSeat() {
        return clientSeat;
    }

    public void setClientSeat(ArrayList<Ticket> clientSeat) {
        this.clientSeat = clientSeat;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

}
