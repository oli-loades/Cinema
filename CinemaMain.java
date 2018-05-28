/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qacinema;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Oliver Loades
 */
public class CinemaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int menuOption;
        int ID;
        
        Cinema cinema = new Cinema();
        
        menuOption = mainMenu(sc);
        
        while (menuOption != 0) {

            switch (menuOption) {
                case (1)://new transaction
                    ID = getIDInput(sc);
                    Transaction transaction = makeTransaction(sc, cinema.getFilm(ID));
                    
                    if (transaction != null) {
                        cinema.addTransaction(transaction);
                        System.out.println(transaction.toString());
                    } else {
                        System.out.println("error - invalid transaction");
                    }
                    
                    break;
                case (2)://add film
                    cinema.addFilm(addFilm(sc));
                    break;
                case (3)://remove film
                    ID = getIDInput(sc);
                    cinema.removeFilm(ID);
                    break;
                case (4)://print film info
                    ID = getIDInput(sc);
                    cinema.printFilm(ID);
                    break;
                case (5)://print films
                    cinema.printFilms();
                    break;
                case (6)://print transactions
                    cinema.printTransactions();
                    break;
                default:
                    System.out.println("error - enter option from menu");
                    break;

            }

            menuOption = mainMenu(sc);

        }
    }

    private static Film addFilm(Scanner sc) {
        int ID;
        String title;
        int minAge;
        
        System.out.println("enter film ID");
        ID = sc.nextInt();
        System.out.println("eneterr film title");
        title = sc.next();
        System.out.println("enter film minimum age");
        minAge = sc.nextInt();
        
        return new Film(ID, title, minAge);
    }

    private static int getIDInput(Scanner sc) {
        System.out.println("Enter film ID");
        return sc.nextInt();
    }

    private static Transaction makeTransaction(Scanner sc, Film film) {
        Transaction transaction = null;
        LocalDate date;
        
        if (film == null) {
            System.out.println("Error - film not found");
        } else {

            System.out.println("Is this transaction for today? y/n");
            char ans = sc.next().trim().charAt(0);

            if (ans == 'n') {
                date = inputDate(sc);//create date
            } else {
                date = LocalDate.now();//today
            }
            
            int ticketOption = ticketMenu(sc);

            transaction = new Transaction(date, film);
            
            while (ticketOption != 0) {
                
                Ticket ticket = null;
                boolean valid = true;//used to check if film is approipriate for child ticket;

                switch (ticketOption) {
                    case (1):
                        ticket = new StandardTicket();
                        break;
                    case (2):
                        ticket = new StudentTicket();
                        break;
                    case (3):
                        ticket = new OAPTicket();
                        break;
                    case (4):
                        ticket = new ChildTicket();
                        valid = ticket.ageAppropriate(film.getMinAge());//check if film is below age 12
                        break;
                    default:
                        System.out.println("error - enter option from menu");
                        break;
                }

                if (ticket != null && valid) {
                    transaction.addTicket(ticket);
                } else {
                    System.out.println("error - ticket invalid");
                }
                ticketOption = ticketMenu(sc);
            }
        }
        return transaction;
    }

    static int mainMenu(Scanner sc) {
        System.out.println("Enter an option from the menu");
        System.out.println("1.New Transaction");
        System.out.println("2.Add Film");
        System.out.println("3.Remove Film");
        System.out.println("4.Print Film information");
        System.out.println("5.Print cuurent film list");
        System.out.println("6.Print all Transactions");
        System.out.println("0.Quit");
        return sc.nextInt();//returns option chosen
    }

    static int ticketMenu(Scanner sc) {
        System.out.println("1.Standard");
        System.out.println("2.Student");
        System.out.println("3.OAP");
        System.out.println("4.Child");
        System.out.println("0.no more tickets");
        return sc.nextInt();
    }

    static LocalDate inputDate(Scanner sc) {
        int day, month, year;
        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.println("date format: dd/mm/yyyy");

            System.out.println("enter day");
            day = sc.nextInt();

            System.out.println("enter month");
            month = sc.nextInt();

            System.out.println("enter year");
            year = sc.nextInt();

            try {
                date = LocalDate.of(year, month, day);
                valid = true;
            } catch (DateTimeException e) {
                System.out.println("error - invalid date");
                valid = false;
            }

        }
        return date;
    }
}
