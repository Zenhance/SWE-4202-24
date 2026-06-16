package engine;
import data.*;
import model.*;
public class CheckoutEngine {
    public static double checkout(Cart cart) {
        double subtotal = cart.grandSubtotal();
        double comboDiscount = 0;
        if (cart.hasCode("POP") && cart.hasCode("SODA")) {
            comboDiscount = 50.0;
        }
        double preDiscount = subtotal - comboDiscount;
        double groupDiscount = 0;
        if (cart.ticketCount() >= 4) {
            groupDiscount = 0.10 * preDiscount;
        }
        double tierDiscount=cart.getOwner().getTierDiscount()*preDiscount;
        double afterDiscounts= preDiscount - groupDiscount-tierDiscount;
        double tax= afterDiscounts*0.05;
        double finalTotal=afterDiscounts+ tax;




    }
}