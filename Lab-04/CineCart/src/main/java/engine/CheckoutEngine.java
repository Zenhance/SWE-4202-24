package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;

    }

    public ShowtimeBoard getBoard() {
        return board;
    }

    public ConcessionMenu getMenu() {
        return menu;
    }
    public String bookTicket(Cart cart, int showTimeId, int row, int col){
        Showtime showtime=board.findById(showTimeId);
        if(showtime == null){
            return "Showtime not Found";
        }
        Movie movie=showtime.getMovie();
        if(cart.getOwner().getAge()<movie.getMinAge()){
            return "Underage for rating"+movie.getRating();

        }
        Seat seat=showtime.getHall().getSeat(row, col);
        if(!seat.isAvailable()){
            return "Seat unavailable";
        }
        double price=movie.getBasePrice()*(seat.isPremium()?1.30:1.00)*(showtime.isPeak()?1.20:1.00);
        seat.book();
        Ticket ticket=new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);
        return "OK";

    }
    public String addConcession(Cart cart, String code, int qty){
            if(menu.findByCode(code)==null){
                return "Item not found";
            }
            else if(qty<=0){
                return "Invalid quantity";
            }
            else{
                return "OK";
            }



    }
    public double checkout(Cart cart){
     double ticketSubtotal= cart.sumTicketsPaid();
     double concessionSubtotal= cart.sumConcessionsRaw();
     double combo=0.0;
     if(cart.hasItem("POP") && cart.hasItem("SODA")){
         combo=50.0;
     }
     else{
          combo=0.0;
     }
     double preDiscount=ticketSubtotal+concessionSubtotal-combo;
     double group=0.0;
     if(cart.getTicketCount()>=4){
         group=0.10*preDiscount;
     }
     else{
         group=0.0;
     }
     double tier=0.0;
     tier=cart.getOwner().getTierDiscount()*preDiscount;

     double afterDiscounts=preDiscount-group-tier;
     double tax=0.05*afterDiscounts;
     double round2=afterDiscounts+tax;

     return round2;




        }
    public String getReceipt(Cart cart){
        return "Receipt" + "BDT" + "Total" + "Discount" + cart.getOwner();


    }






    }



