package co.edu.cue.proyectofinalcorte3.model;

public class Ticket {
    private String chair;
    private double price;

    public Ticket(String chair, double price) {
        this.chair = chair;
        this.price = price;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
