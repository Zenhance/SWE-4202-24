package model;

public class StudentTicket extends Ticket {


    public class StudentTicket extends Ticket {
        public StudentTicket(Showtime showtime,int row,int col);
            super(showtime,row,col);
    }

    @override
    public double subtotoal() {
        return basePrice*0.50*peakMultiplier();
    }
    @override
    public String describe(){
        return syper.describe() + "Student";
    }

}


