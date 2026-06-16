package model;

public class VIPTicket extends Ticket {
    public VIPTicket(Showtime showtime,int row,int col);
      super(showtime,row,col);
}

    @override
    public double subtotoal() {
    return super.subtotal() + 200;
}
    @override
    public String describe(){
    return syper.describe()+"VIP Lounge";
    }

}
