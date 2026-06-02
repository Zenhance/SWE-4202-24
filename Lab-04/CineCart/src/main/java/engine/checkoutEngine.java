package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;

public class checkoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public checkoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId)==null){
            System.out.println("Showtime not found");
        }
        return "";
    }



}
