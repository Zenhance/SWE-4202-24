package model;

public class StudentTicket extends StandardTicket {

    public StudentTicket(Showtime showtime, int row, int seat) {
        super(showtime, row, seat);
    }

    @Override
    public double subtotal() {

        double fare = base * 0.50;

        if (showtime.isPeak()) {
            fare *= 1.20;
        }

        return fare;
    }

    @Override
    public String describe() {
        return super.describe() + " (Student)";
    }
}