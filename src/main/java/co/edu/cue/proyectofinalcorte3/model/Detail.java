package co.edu.cue.proyectofinalcorte3.model;

import java.util.List;

public class Detail {
    private List<Ticket> clientSeat;
    private List<Food> foodList;
    private Person client;

    public Detail(List<Ticket> clientSeat, List<Food> foodList, Person client) {
        this.clientSeat = clientSeat;
        this.foodList = foodList;
        this.client = client;
    }

    public List<Ticket> getClientSeat() {
        return clientSeat;
    }

    public void setClientSeat(List<Ticket> clientSeat) {
        this.clientSeat = clientSeat;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }
}
