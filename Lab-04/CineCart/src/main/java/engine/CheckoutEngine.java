package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

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
        Showtime showtime = board.findById(showtimeId);
        if(showtime==null)
        {
            return "Showtime not found";
        }
        if(cart.getOwner().getAge()<showtime.getMovie().getMinAge())
        {
            return "Underage for rating "+showtime.getMovie().getRating();
        }
        Seat seat = showtime.getHall().getSeat(row, col);
        if(seat.isBooked())
        {
            return "Seat unavailable";
        }
        seat.book();
        if(seat.isPremium())
        {
            cart.add(new PremiumTicket(showtime, row, col));
        }
        else
        {
            cart.add(new StandardTicket(showtime, row, col));
        }
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
        cart.add(item,qty);
        return "OK";
    }

    public double checkout(Cart cart)
    {
        double preDiscount = cart.grandSubtotal();
        if(cart.hasCode("POP") && cart.hasCode("SODA"))
        {
            preDiscount=preDiscount-50.0;
        }
        double groupDiscount = 0.0;
        if(cart.ticketCount()>=4)
        {
            groupDiscount=0.10*preDiscount;
        }
        double tierDiscount = cart.getOwner().getTierDiscount()*preDiscount;
        double afterDiscount = preDiscount-groupDiscount-tierDiscount;
        double tax = 0.05*afterDiscount;
        double total = afterDiscount+tax;
        return Math.round(total*100.0)/100.0;
    }

    public String getReceipt(Cart cart)
    {
        String receipt="=== Receipt ===\n";
        receipt=receipt+"Customer : "+cart.getOwner().getName();
        receipt=receipt+"\nTickets\n";
        for(LineItem line : cart.getLines())
        {
            receipt=receipt+line.describe();
            receipt=receipt+"\nBDT"+String.format("%.2f",line.describe())+"\n";
        }
        receipt=receipt+"\nPayable : ";
        double amount = checkout(cart);
        receipt=receipt+"BDT : "+String.format("%.2f",amount);
        return receipt;
    }
}