package model;

public class Ticket {
    protected Showtime showtime;
    protected int col;
    protected int row;
    protected int pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.col = col;
        this.row = row;
        this.pricePaid = pricePaid;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public String toString() {
        return String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), row, col, pricePaid);
}

public class StandardTicket extends Ticket{
        double price = showtime.getMovie().getBasePrice();
        double charge;
        if(showtime.isPeak())
            charge = price * 1.20;
        else
            charge = price;
}
public class PremiumTicket extends Ticket{
        double price = showtime.getMovie().getBasePrice();
        double charge = price * 1.30;
        if(showtime.isPeak())
            charge = charge * 1.20;
        else
            charge = charge;
}
public class StudentTicket extends Ticket{
        double price = showtime.getMovie().getBasePrice();
        double charge;
        if(showtime.isPeak())
            charge = price * 0.50 * 1.20;
        else
            charge = price * 0.50;
}
public class VIPTicket extends PremiumTicket{
        if(showtime.isPeak())
            charge = charge * 1.20 + 200.00;
        else
            charge = charge + 200.00;
    }
}
