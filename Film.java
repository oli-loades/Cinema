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
public class Film {

    private int ID;
    private String title;
    private int minAge;

    public Film(int ID, String title, int minAge) {
        this.ID = ID;
        this.title = title;
        this.minAge = minAge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int newMinAge) {
        this.minAge = newMinAge;
    }

    public int getID() {
        return ID;
    }

    public void setID(int newID) {
        this.ID = newID;
    }
    
    @Override
    public String toString(){
        return ID + ": " + title + " - " + minAge;
    }
}
