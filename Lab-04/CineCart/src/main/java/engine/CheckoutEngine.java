package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Showtime;


public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    private Showtime showtime;


    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        return String.valueOf(board.findById(showtimeId));

        if(cart.getOwner().getAge() < showtime.getMovie().getMinAge()){
            System.out.println("Underage for rating " + showtime.getMovie().getRating());
        }








    }











}
