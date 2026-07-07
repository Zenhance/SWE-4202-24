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
        if(seat.isPremium())
        {
            cart.add(new PremiumTicket(showtime, row, col));
        }
        else
        {
            cart.add(new StandardTicket(showtime, row, col));
        }
        double price = showtime.getMovie().getBasePrice()*(seat.isPremium()?1.30:1.00)*(showtime.isPeak()?1.20:1.00);
        seat.book();
        StandardTicket ticket = new StandardTicket(showtime,row,col);
        cart.add(ticket);
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
//        double ticketSubtotal = cart.sumTicketsPaid();
//        double concessionSubtotal = cart.sumConcessionsRaw();
//        double combo = 0.0;
//        if(cart.hasCode("POP") && cart.hasCode("SODA"))
//        {
//            combo=50.0;
//        }
        double preDiscount = cart.grandSubtotal();
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