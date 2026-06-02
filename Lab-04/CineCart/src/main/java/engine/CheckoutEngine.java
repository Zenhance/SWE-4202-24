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












    }











}
