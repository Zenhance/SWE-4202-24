package model;

public class PremiumTicket extends Ticket {


    public class StudentTicket extends Ticket {
        public VIPTicket(Showtime showtime,row,col);
      super(showtime,row,col);
    }

    @override
    public double subtotoal() {
        return basePrice*0.30*peakMultiplier();
    }
    @override
    public String describe(){
        return syper.describe() + "Student";
    }

}



