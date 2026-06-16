package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime,int row ,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return basePrice*0.5*getPeakMultiplier();
    }
    @Override
    public String describe(){
        return super.describe()+ "StudentTicket";
    }

}
}
