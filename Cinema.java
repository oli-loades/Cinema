/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qacinema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver Loades
 */
public class Cinema {

    private final List<Transaction> transactions;
    private final List<Film> films;

    public Cinema() {
        transactions = new ArrayList<>();
        films = new ArrayList<>();
    }

    public void addFilm(Film newFilm) {
        if (!filmExists(newFilm.getID())) {
            films.add(newFilm);
        } else {
            System.out.println("Error - film already exists");
        }
    }

    public void removeFilm(int ID) {
        if (filmExists(ID)) {
            Film removedFilm = films.get(findFilmPos(ID));//tempory store for film to be removed for printing purposes
            films.remove(findFilmPos(ID));
            System.out.println("Film removed = " + removedFilm.toString());
        } else {
            System.out.println("Error - Film not found");
        }
    }
    
    public Film getFilm(int ID){
        Film film = null;
        if(filmExists(ID)){
            film = films.get(findFilmPos(ID));
        }
        return film;//returns null if not found
    }

    public void addTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    public void printFilms() {
        for (Film film : films) {
            System.out.println(film.toString());
        }
    }

    public void printFilm(int ID) {
        if (filmExists(ID)) {
            System.out.println(films.get(findFilmPos(ID)).toString());
        } else {
            System.out.println("Error - Film not found");
        }
    }

    private int findFilmPos(int ID) {//film already exists
        int pos = 0;
        int filmID;
        for (int i = 0; i < films.size() - 1; i++) {
            filmID = films.get(i).getID();
            if (filmID == ID) {
                pos = i;
            }
        }
        return pos;
    }

    private boolean filmExists(int ID) {
        boolean found = false;
        for (Film film : films) {
            if (film.getID() == ID) {
                found = true;
            }
        }
        return found;
    }

}
