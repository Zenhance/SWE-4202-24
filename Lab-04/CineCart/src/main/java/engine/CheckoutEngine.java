package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Showtime;
import model.AbstractTicket;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    /*public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null){
            return "Showtime not found";
        }

        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()){
            return String.format("Underage for rating <%s>", showtime.getMovie().getRating());
        }

        if (showtime.getHall().getSeat(row, col).isBooked()){
            return "Seat unavailable";
        }

        double price = showtime.getMovie().getBasePrice() * (showtime.getHall().getSeat(row, col).isPremium() ? 1.30 : 1.00) * (showtime.isPeak() ? 1.20 : 1.00);

        showtime.getHall().getSeat(row, col).book();

        //AbstractTicket t = new AbstractTicket(showtime, row, col, price);

        cart.addTicket(t);
        return "OK";
    }*/


    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);

        if (item == null){
            return "Item not found";
        }

        else if (qty <= 0){
            return "Invalid quantity";
        }

        else{
            cart.add(item, qty);
        }

        return "OK";
    }

    public double checkout(Cart cart){
//        double ticketSubtotal = cart.sumTicketsPaid();
//        double concessionSubtotal = cart.sumConcessionsRaw();

        double combo = 0.0;

        boolean pop = cart.hasCode("POP");
        boolean soda = cart.hasCode("SODA");

        if (pop && soda){
            combo = 50.0;
        }

        double preDiscount = cart.grandSubtotal() - combo;

        double group = 0.0;

        if (cart.ticketCount() >= 4) group = 0.10*preDiscount;

        double tier = cart.getOwner().getTierDiscount()*preDiscount;

        double afterDiscounts = preDiscount - group - tier;

        double tax = 0.05*afterDiscounts;

        double res = Math.round((afterDiscounts+tax) * 100) / 100.0;
        return res;
    }

    public String getReceipt(Cart cart){
        return "Receipt" + "BDT" + "Total" + "Discount" + cart.getOwner();


    }
}
