package engine;
import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.*;
public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }
public static double checkout(Cart cart){
        double subtotal=cart.grandSubtotal();
        double comboDiscount=0;
        if(cart.hasCode("POP") && cart.hasCode("SODA")){
            comboDiscount=50.0;
        }
        double groupDiscount=0;
        if(cart.ticketCount()>=4){
            groupDiscount=0.
        }
}
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
            if (showtime == null) {
                return "Showtime not found";
            }
            if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
                return "Underage for rating " + showtime.getMovie().getRating();
            }
            Seat seat = showtime.getHall().getSeat(row, col);
            if (!seat.isAvailable()) {
                return "Seat unavailable";
            }
            double price = showtime.getMovie().getBasePrice();
            if (seat.isPremium()) {
                price *= 1.30;
            }
            if (showtime.isPeak()) {
                price *= 1.20;
            }
            seat.book();
            Ticket ticket = new Ticket(showtime, row, col, price);
                cart.addTicket(ticket);
                return "OK";
        }

    public String addConcession(Cart cart, String code, int qty) {
        ConcessionItem item = menu.findByCode(code);
        if (item == null) {
            return "Item not found";
        }
        if (qty <= 0) {
            return "Invalid quantity";
        }
        cart.addItem(item, qty);
        return "OK";
    }

    public double checkout(Cart cart) {
        //this part shows error however I do it.
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = 0;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = 0;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        } else {
            System.out.println("0");
        }
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;
        double total = afterDiscounts + tax;
        return Math.round(total * 100.00) / 100.0;
    }

        public String getReceipt(Cart cart){
             double total=checkout(cart);
            String receipt="";
            receipt+="Receipt\n";
            receipt+="Customer: "+cart.getOwner().getName()+"\n";
            receipt+="Discount Applied\n";
            receipt+="Total: BDT"+String.format("%.2f",total)+"\n";
            return receipt;

        }
    }
