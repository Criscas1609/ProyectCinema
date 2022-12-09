package co.edu.cue.proyectofinalcorte3.model;

public class Food {
    private String food;
    private double foodPrice;

    public Food(String food, double foodPrice) {
        this.food = food;
        this.foodPrice = foodPrice;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
