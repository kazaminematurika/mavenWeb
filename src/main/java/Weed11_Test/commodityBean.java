package Weed11_Test;

import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
public class commodityBean {
    private int ID;
    private String Name;
    private double price;
    private int shopping;
    private Vector vector;

    public int getID() {
        return ID;
    }

    public void setID(int commodityID) {
        ID = commodityID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String commodityName) {
        Name = commodityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double commodityPrice) {
        price = commodityPrice;
    }

    public int getShopping() {
        return shopping;
    }

    public void setShopping(int commodityShopping) {
        shopping = commodityShopping;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector commodityVector) {
        vector = commodityVector;
    }
}
