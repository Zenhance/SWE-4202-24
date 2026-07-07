package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Customer;

public class CheckoutEngine {

    private ShowtimeBoard showtimeBoard;
    private ConcessionMenu concessionMenu;

    public CheckoutEngine(ShowtimeBoard showtimeBoard,
                          ConcessionMenu concessionMenu) {
        this.showtimeBoard = showtimeBoard;
        this.concessionMenu = concessionMenu;
    }

    public double checkout(Cart cart) {

        double total = cart.grandSubtotal();

        // Combo discount
        if (cart.hasCode("POP") && cart.hasCode("SODA")) {
            total -= 50.0;
        }

        // Group discount (4+ tickets)
        if (cart.ticketCount() >= 4) {
            total -= total * 0.10;
        }

        // Tier discount
        Customer customer = cart.getCustomer();
        String tier = customer.getTier();

        if (tier.equalsIgnoreCase("SILVER")) {
            total -= total * 0.05;
        }
        else if (tier.equalsIgnoreCase("GOLD")) {
            total -= total * 0.15;
        }

        // Tax 5%
        total += total * 0.05;

        return Math.round(total * 100.0) / 100.0;
    }
}
