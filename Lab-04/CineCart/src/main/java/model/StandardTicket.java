package model;

public class extends Ticket {


    public class StudentTicket extends Ticket {
        public StandardTicket(Showtime showtime,int row,int col);
        super(showtime,row,col);
    }

    @override
    public double subtotoal() {
        return basePrice*peakMultiplier();
    }


}


