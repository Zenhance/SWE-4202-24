package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;

public class CheckoutEngine
{
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu)
    {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col)
    {

        return "OK";
    }


}