/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qacinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver Loades
 */
public class Transaction {

    private final List<Ticket> tickets;
    private LocalDate date;
    private Film film;

    public Transaction(LocalDate date, Film film) {
        tickets = new ArrayList();
        this.date = date;
        this.film = film;
    }

    public void addTicket(Ticket newTicket) {
        tickets.add(newTicket);
    }

    private double calcDiscount() {
        double discount = 0;
        String dayOfWeek = date.getDayOfWeek().name();
        if (dayOfWeek.equalsIgnoreCase("wednesday")) {
            discount = tickets.size() * 2;
        }
        return discount;
    }

    private double calcTotal() {
        double total = 0;
        for (Ticket ticket : tickets) {
            total = total + ticket.getPrice();
        }
        return total - calcDiscount();
    }

    @Override
    public String toString() {
        return "The price for " + tickets.size() + " tickets is £" + calcTotal();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film newfilm) {
        this.film = newfilm;
    }
}
