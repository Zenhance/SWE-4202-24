package model;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if(showtime == null)
            return "Showtime not found";

        if(cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            return "Underage for rating <%s>" + showtime.getMovie().getRating();
        }

        Seat seat = showtime.getMovie().getMinAge();
        if(seat.isBooked())
            return "Seat unavailable";

        double price = showtime.getMovie().getBasePrice();
        if(seat.isPremium()) price = price * 1.30;
        else price = price * 1.00;

        if(showtime.isPeak()) price = price * 1.20;
        else price = price * 1.00;


    }

    public String addConcession(Cart cart, String code, int qty) {

    }

    public double checkout(Cart cart) {

    }

    public String getReceipt(Cart cart) {

    }
}
