package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Seat;
import model.Showtime;
import model.Ticket;

public class CheckoutEngine{

    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime show = board.findById(showtimeId);
        if (show == null) {
            return "Showtime not found";
        }

        int customerAge = cart.getOwner().getAge();

        int minAge = show.getMovie().getMinAge();

        if (customerAge < minAge) {
            return "Underage for rating "
                    + show.getMovie().getRating();
        }
        Seat seat = show.getHall().getSeat(row, col);
        if (seat.isBooked()) {
            return "Seat unavailable";
        }
        double price = show.getMovie().getBasePrice();

        if (seat.isPremium()) {
            price = price * 1.30;
        }
        if (show.isPeak()) {
            price = price * 1.20;
        }
        seat.book();

        Ticket t = new Ticket(show, row, col, price);
        cart.addTicket(t);
        return "OK";
    }
    public String addConcession(Cart cart,String code,int qty){
        ConcessionItem item=menu.findByCode(code);
        if(item==null){
            return "Item not found";
        }
        if(qty<=0){
            return "Invalid quantity";
        }
        cart.addItem(item,qty);
        return "OK";
    }
public double checkout(Cart cart) {
    double ticketSubtotal = cart.sumTicketsPaid();
    double concessionSubtotal = cart.sumConcessionsRaw();
    double combo = 0;
    if (cart.hasItem("POP") == true && cart.hasItem("SODA") == true) {
        combo = 50.0;
    }
    double preDiscount = ticketSubtotal + concessionSubtotal - combo;
    double group = 0;
    if (cart.getTicketCount() >= 4) {
        group = 0.10 * preDiscount;
    }
    double tier = cart.getOwner().getTierDiscount() * preDiscount;
    double afterDiscounts = preDiscount - group - tier;
    double tax = 0.05 * afterDiscounts;
    double total = afterDiscounts + tax;
    total = Math.round(total * 100.0) / 100.0;
    return total;
    }
    public String getReceipt(Cart cart){

        String receipt="";
        receipt+="Receipt\n";
        receipt+="Customer: " +cart.getOwner().getName() +"\n";
        receipt+="Tickets:\n";

        for(int i=0;i<cart.getTicketCount();i++){
            receipt+= cart.getTickets()[i] +"\n";
        }
        receipt+="Items:\n";

        for(int i=0;i<cart.getItemCount();i++){
            receipt+= cart.getItems()[i].getName() +" x " +cart.getQtys()[i] +"\n";
        }

        double ticketSubtotal= cart.sumTicketsPaid();

        double concessionSubtotal= cart.sumConcessionsRaw();

        double combo=0;

        if(cart.hasItem("POP") && cart.hasItem("SODA")){
            combo=50.0;
        }
        double preDiscount= ticketSubtotal+ concessionSubtotal- combo;
        double group=0;
        if(cart.getTicketCount()>=4){
            group=0.10*preDiscount;
        }
        double tier= cart.getOwner().getTierDiscount() *preDiscount;
        double totalDiscount= group+tier;
        receipt+="Discount: BDT " +String.format("%.2f", totalDiscount) +"\n";
        receipt+="Total: BDT " +String.format("%.2f", checkout(cart));
        return receipt;
    }
}