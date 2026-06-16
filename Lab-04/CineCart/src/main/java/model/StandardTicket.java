package model;

public class StandardTicket extends AbstractTicket{


    public StandardTicket(Showtime id, int row, int col) {
        super(id, row, col);
    }
    public double subtotal(){
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
}
