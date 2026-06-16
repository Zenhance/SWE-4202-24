package model;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {

    }

    public String addConcession(Cart cart, String code, int qty) {

    }

    public double checkout(Cart cart) {

    }

    public String getReceipt(Cart cart) {

    }
}
