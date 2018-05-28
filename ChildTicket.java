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
public class ChildTicket extends Ticket {

    public ChildTicket() {//below 12 years old
        setPrice(4);
    }

    @Override
    public boolean ageAppropriate(int age) { // age is the age restriction of the film
       return age <=12; //assume that child ticket is for people of age 12 or below
    }
}
