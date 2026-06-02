package engine;


import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;

public class CheckoutEngine {
    private final ShowtimeBoard board;
    private final ConcessionMenu menu;
  public   CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){
      this.board=board;
      this.menu=menu;
  }
  public  String bookTicket(Cart cart, int showtimeId, int row, int col){
        return null;
    }
    public double checkout(Cart cart){
        return 0.0;
    }

  public String addConcession(Cart cart, String code, int qty){
      return null;
  }
  public String getReceipt(Cart cart){
      return "";
  }
}
