package engine;
import data.*;
import model.*;
public class CheckoutEngine {
    public static double checkout(Cart cart){
        double subtotal= cart.grandSubtotal();
        double comboDiscount=0;
        if(cart.hasCode("POP")&& cart.hasCode("SODA")){
            comboDiscount=50.0;
        }
    }
}