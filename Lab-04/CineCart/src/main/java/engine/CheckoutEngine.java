package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Movie;
import model.Showtime;


public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    private Showtime showtime;
    private Movie movie;


    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        board.findById(showtimeId);

        if(cart.getOwner().getAge() < showtime.getMovie().getMinAge()){
            System.out.println("Underage for rating " + showtime.getMovie().getRating());
        }

        showtime.getHall().getSeat(row, col);
        if(showtime.getHall().getSeat(row, col).getIsBooked()){
            System.out.println("Seat unavailable");
        }


        return "OK";
    }


    public String addConcession(Cart cart, String code, int qty) {
        menu.findByCode(code);
        if(menu.findByCode(code) == null) {
            return "Item not found";
        }
        if(qty <= 0) {
            return "Invalid quantity";
        }
        return "OK";
    }

    public double checkout(Cart cart) {
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionRaw();

    }











}
