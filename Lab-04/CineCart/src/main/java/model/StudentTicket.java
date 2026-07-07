package model;

public  class StudentTicket extends Ticket {
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);

    }

    @Override
    public double subTotal(){
        double isPeak = showtime.isPeak()? 1.20:1.00;
        return basePrice*0.5*isPeak;
    }

    @Override
    public String describe(){
        return String.format("Student Ticket T%d, R%d, C%d", showtime.getId(), row, col);
    }
}
