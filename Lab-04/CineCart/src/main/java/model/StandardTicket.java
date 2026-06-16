package model;

public  class StandardTicket extends AbstractTicket {
    public StandardTicket(Showtime showtime,int col,int row){
        super(showtime,col,row);
    }
    public String describe(){
        return "Premium Ticket";
    }
    public double subtotal(){
        return (basePrice*1)*getPeakMultiplier();
    }
}
