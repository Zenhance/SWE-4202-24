package mode1;

public class PremiumTicket extends AbstractTicket{
        public PremiumTicket (Showtime showtime, int row, int seat){
            super(showtime, row, seat);
        }

        public double subtotal(){
            return base * 1.30 * peakMultiplier();
        }
        public String describe (){
            return "Premium " + showtime.getMovie().getTitle + "R" + row + "S" + seat;
        }
}