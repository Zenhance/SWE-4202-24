package engine;
import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ConcessionMenu menu;
    private ShowtimeBoard board;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime=board.findById(showtimeId);
        if(showtime.equals(null)){
            return "Showtime not found";
        }
        if(cart.getOwner().getAge()<showtime.getMovie().getMinAge()){
            return "Underage for rating" + showtime.getMovie().getRating();
        }
        Seat seat=showtime.getHall().getSeat(row,col);
        if(seat.isBooked()){
            return "Seat Unavailable";
        }
        double price=showtime.getMovie().getBasePrice();
        if(seat.isPremium()){
            price *=1.30;
        }
        if(showtime.isPeak()){
            price *=1.20;
        }
        seat.book();
        Ticket ticket= new Ticket(showtime,row,col,price);
        cart.addTicket(ticket);
        return "OK";
    }


    public String addConcession(Cart cart,String code,int qty){
        ConcessionItem item=menu.findByCode(code);
        if(item.equals(null)){
            return "Item not found";
        }
        if(qty<=0){
            return "Invalid quantity";
        }
        cart.addItem(item,qty);
        return "OK";
    }


    public double checkout(Cart cart){
        double ticketSubtotal=cart.sumTicketsPaid();
        double concessionSubtotal=cart.sumConcessionsRaw();
        double combo=0;
        if(cart.hasItem("POP") && cart.hasItem("SODA")){
            combo=50.0;
        }
        double preDiscount=ticketSubtotal+concessionSubtotal-combo;
        double group=0;
        if(cart.getTicketCount()>=4){
            group=0.10*preDiscount;
        }
        double tier=cart.getOwner().getTierDiscount()*preDiscount;
        double afterDiscounts= preDiscount-group-tier;
        double tax = 0.05*afterDiscounts;
        double total=afterDiscounts+tax;
        return Math.round(total*100.0)/100.0;
    }
    public String getReceipt(Cart cart){
        double total=checkout(cart);
        String receipt="Receipt";
        receipt+="Customer: " + cart.getOwner().getName()+"\n";
        receipt+="Tickets: ";
        for(int i=0;i<cart.getTicketCount();i++){
            receipt+=cart.getTickets()[i];
        }
        receipt+="Concessions: ";
        for(int i=0;i<cart.getItemCount();i++){
            receipt+=cart.getItems()[i].getName() + "x" + cart.getQtys()[i];
        }
        receipt+="Discount Applied: ";
        receipt+="Total: BDT " + String.format("%.2f",total);
        return receipt;
    }
}
