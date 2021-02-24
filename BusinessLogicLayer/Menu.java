package BusinessLogicLayer;

public class Menu {
    //FoodID;Name;Normal Price;Child Price
    //Storing various menus that are an option for event

    //Fields
    String foodID, name;
    float normalPrice, childPrice;

    //Constructor
    public Menu(String foodID, String name, float normalPrice, float childPrice) {
        this.foodID = foodID;
        this.name = name;
        this.normalPrice = normalPrice;
        this.childPrice = childPrice;
    }

    //Getters and Setters
    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(float normalPrice) {
        this.normalPrice = normalPrice;
    }

    public float getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(float childPrice) {
        this.childPrice = childPrice;
    }
}
