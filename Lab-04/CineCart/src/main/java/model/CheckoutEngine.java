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
    }

    public String addConcession(Cart cart, String code, int qty) {

    }

    public double checkout(Cart cart) {

    }

    public String getReceipt(Cart cart) {

    }
}
