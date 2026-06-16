package mode1;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int seat){
        super(showtime, row, seat);
    }

    public double subtotal(){
        return base * peakMultiplier();
    }

    public String describe(){
        return "Standard " + showtime.getMovie().getTitle() + "R" + row + "S" + seat;
    }
}