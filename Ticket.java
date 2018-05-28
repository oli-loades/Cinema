/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qacinema;

/**
 *
 * @author Oliver Loades
 */
public abstract class Ticket {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public boolean ageAppropriate(int minAge) {//no restrictions
        return true;
    }

}
