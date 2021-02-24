package BusinessLogicLayer;

public class Decoration {
    //Decoration ID;Name;Price
    //Used to store decoration aoptions that are available

    //Fields
    String decorationID, name;
    float price;

    //Constructor
    public Decoration(String decorationID, String name, float price) {
        this.decorationID = decorationID;
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getDecorationID() {
        return decorationID;
    }

    public void setDecorationID(String decorationID) {
        this.decorationID = decorationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }    
}
