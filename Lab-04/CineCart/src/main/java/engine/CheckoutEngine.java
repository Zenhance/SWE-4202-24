package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

import static java.lang.Math.round;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    //E. Booking Flow
    //E.1
    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findById(showtimeId);
        if(showtime == null) return "Showtime not found";

        int age = cart.getOwner().getAge();
        int req_age = showtime.getMovie().getMinAge();
        if(age<req_age){
            String rating = showtime.getMovie().getRating();
            String msg = "Underage for rating <"+rating+">";
            return msg;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if(seat.isBooked()) return "Seat unavailable";

        Movie movie = showtime.getMovie();
        double price = movie.getBasePrice() *
                (seat.isPremium() ? 1.30 : 1.00) *
                (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        //Ticket ticket = new Ticket(showtime, row, col, price);
        //cart.addTicket(ticket);

        return "OK";
    }
    /*
    //E.2
    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if(item == null) return "Item not found";

        if (qty <= 0) return "Invalid quantity";

        cart.addItem(item, qty);
        return "OK";
    }*/

    //F. Checkout Pipeline
    //F.1

    public double checkout(Cart cart){
         /*
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();

        boolean pop = false;
        boolean soda = false;

        ConcessionItem[] items = cart.getItems();
        for (int i = 0; i < cart.getItemCount(); i++) {
            ConcessionItem k = items[i];

            if (k.getCode().equals("POP")) pop = true;
            if (k.getCode().equals("SODA")) soda = true;
        }

        double combo = (soda && pop) ? 50.0 : 0.0;

        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        //double group = (cart.getTicketCount() >= 4) ? 0.10 * preDiscount : 0;

        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - tier; //double afterDiscounts = preDiscount - group- tier;
        double tax = 0.05 * afterDiscounts;

        double total = afterDiscounts + tax;

        double rounded = Math.round(total*100.0)/100.0;

        return rounded; */

        return 0;
    }

    //F.2
    public String getReceipt(Cart cart){
        String out = "Receipt : \n Name: " + cart.getOwner().getName()
                + "\nTotal Price: " + String.format("%.2f", checkout(cart))+ " BDT (with Discount)\nList:";
        /*
        Ticket[] tickets = cart.getTickets();
        for (int i = 0; i < cart.getTicketCount(); i++) {
            Ticket k = tickets[i];
            out += k.toString();
        }

        ConcessionItem [] items = cart.getItems();
        for (int i = 0; i < cart.getItemCount(); i++) {
            ConcessionItem k = items[i];
            out += k.toString();
        }
        return out;
        */
        return out;
    }
}
