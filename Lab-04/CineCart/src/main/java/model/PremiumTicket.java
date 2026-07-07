public class PremiumTicket  extends AbstractTicket{
    public PremiumTicket (Showtime st,int row,int seat){
        super (st,row,seat);
    }
    public double subtotal() {
        return base * 1.3//works because base is protected
    }
}
