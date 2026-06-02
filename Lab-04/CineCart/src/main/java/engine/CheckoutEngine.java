package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;

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

    public String addConcession(Cart cart, String code, int qty)
    {
        ConcessionItem item = menu.findByCode(code);
        if(item==null)
        {
            return "Item not found";
        }
        if(qty<=0)
        {
            return "Invalid quantity";
        }
        cart.addItem(item,qty);
        return "OK";
    }
}