import model.Seat;
import model.Showtime;

public abstract class AbstractTicket {


    public boolean isPremium;
    public Seat seat;

    public abstract double subtotal();
    public abstract double describe();
    public AbstractTicket(Showtime pop, int i, int j) {
        seat = new Seat(i,j,isPremium);


    }
}
