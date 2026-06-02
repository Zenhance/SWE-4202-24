package engine;

import Data.ShowtimeBoard;
import Data.concessionMenu;
import model.Cart;
import model.Showtime;

public class checkoutEngine {
    private ShowtimeBoard board;
    private concessionMenu menu;

    public checkoutEngine(ShowtimeBoard board,concessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findByID(showtimeId)==null){
            System.out.println("Showtime not found");
        }
        return "";
    }


}
