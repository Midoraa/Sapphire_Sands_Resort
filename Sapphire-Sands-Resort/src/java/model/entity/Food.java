package model.entity;

public class Food {
    private String foodID, foodName;
    private double foodPrice;

    public Food() {
    }

    public Food(String foodID, String foodName, double foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return '{' + " foodID: " + foodID + ", foodName: " + foodName + ", foodPrice: " + foodPrice + '}' + "\n";
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
    
}