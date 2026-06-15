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

    public String bookTicket(Cart cart, int ShowtimeId, int row, int col) {
        Showtime showtime = board.findById(ShowtimeId);
        if(showtime == null)
        {
            return "Showtime not found";
        }

        Movie movie = showtime.getMovie();
        if(cart.getOwner().getAge() < movie.getMinAge())
        {
            return "Underage for rating " + movie.getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if(seat.isBooked())
        {
            return "Seat unavailable";
        }

        double price = movie.getBasePrice() * (seat.isPremium() ? 1.30 : 1.00) * (showtime.isPeak() ? 1.20 : 1.00);
        seat.book();
        cart.addTicket(new Ticket(showtime, row, col, price));
        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty)
    {
        ConcessionItem item = menu.findByCode(code);
        if(item == null)
        {
            return "Item not found";
        }
        if(qty <= 0)
        {
            return "Invalid quantity";
        }
        cart.addItems(item, qty);
        return "OK";
    }

    public double checkout(Cart cart)
    {
        double ticketSubtotal = cart.sumTicketPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = (cart.hasItem("POP") && cart.hasItem("SODA")) ? 50.0 : 0.0;
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double groupDiscount = (cart.getTicketCount() >= 4) ? 0.10 * preDiscount : 0.0;
        double TierDiscount = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - groupDiscount - TierDiscount;
        double tax = 0.05 * afterDiscounts;
        return Math.round((afterDiscounts + tax) * 100.0) / 100.0;
    }

}
