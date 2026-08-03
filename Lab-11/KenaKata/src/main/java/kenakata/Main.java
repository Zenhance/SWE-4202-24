package kenakata;

import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.Seller;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CheckoutException;
import kenakata.order.Coupon;
import kenakata.order.DeliveryCalculator;
import kenakata.order.Order;
import kenakata.order.PriceBreakdown;
import kenakata.order.Zone;
import kenakata.payment.CardPayment;
import kenakata.payment.CashOnDeliveryPayment;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;
import kenakata.payment.Wallet;
import kenakata.settlement.Marketplace;
import kenakata.settlement.SellerPayout;
import kenakata.settlement.SettlementReport;

/**
 * Driver for the KenaKata engine. This is a hand-written demonstration of "a night in the
 * life of the marketplace": build sellers and a catalogue, assemble a few mixed orders,
 * quote them, place them against different payment methods (one is deliberately refused and
 * caught), process a return, then run the nightly settlement.
 *
 * The classes it uses are deliberately different KINDS of object (stocked/digital/fresh items,
 * non-product add-ons, three payment methods) that the order and settlement treat uniformly
 * through their shared interfaces -- this file never asks "what kind are you?".
 */
public final class Main {

    public static void main(String[] args) throws CheckoutException {
        // ---- Sellers and catalogue -------------------------------------------------------
        Seller alpha = new Seller("Alpha Electronics");
        Seller beta = new Seller("Beta Books");
        Seller gamma = new Seller("Gamma Fresh");

        // Three kinds of catalogue item -- same base type, different money rules.
        StockedGood lamp = new StockedGood("SKU-LAMP", "Table Lamp", 1200, 10, alpha, 1500);
        StockedGood charger = new StockedGood("SKU-CHRG", "USB Charger", 800, 20, alpha, 300);
        StockedGood fridge = new StockedGood("SKU-FRIDGE", "Refrigerator", 20000, 3, alpha, 50000);
        DigitalGood ebook = new DigitalGood("SKU-EBK", "E-book: Clean OOP", 300, 1000, beta);
        FreshGood hilsa = new FreshGood("SKU-HILSA", "Hilsa 1kg", 1600, 4, gamma, 1000);

        Marketplace marketplace = new Marketplace();
        marketplace.register(alpha);
        marketplace.register(beta);
        marketplace.register(gamma);

        DeliveryCalculator delivery = new DeliveryCalculator();
        Coupon eid10 = new Coupon("EID10", 10, 200, 1000, 150);
        int today = 100;

        // ---- Order 1: mixed basket inside Dhaka, paid from a mobile wallet ----------------
        Order order1 = new Order(Zone.DHAKA, delivery);
        order1.addProduct(lamp, 2);        // stocked, weighable, discountable
        order1.addProduct(ebook, 1);       // digital, no weight, not discountable
        order1.addProduct(hilsa, 1);       // fresh, weighable, needs cold chain
        order1.addAddOn(new GiftWrap());   // non-product line, priced like any other
        order1.applyCoupon(eid10);
        printQuote("Order 1 (inside Dhaka)", order1.quote(today));

        Wallet wallet = new Wallet(5000);
        PaymentMethod payment = new MobileWalletPayment(wallet);   // one variable, any payment form
        order1.place(payment, today);
        marketplace.record(order1);
        System.out.println("Order 1 placed. Wallet balance now Tk " + wallet.balance());
        System.out.println();

        // ---- Order 2: outside Dhaka, one insured line, paid by card -----------------------
        Order order2 = new Order(Zone.OUTSIDE, delivery);
        order2.addProduct(charger, 3);
        order2.addAddOn(new ExpressHandling());
        order2.insure(0);                  // insure the charger line (it is insurable)
        printQuote("Order 2 (outside Dhaka)", order2.quote(today));

        payment = new CardPayment(3000);   // same variable, now a card
        order2.place(payment, today);
        marketplace.record(order2);
        System.out.println("Order 2 placed by card.");
        System.out.println();

        // ---- Order 3: a checkout that the business refuses, caught and reported -----------
        Order order3 = new Order(Zone.DHAKA, delivery);
        order3.addProduct(fridge, 1);      // grand total is above the cash-on-delivery ceiling
        printQuote("Order 3 (inside Dhaka)", order3.quote(today));
        try {
            order3.place(new CashOnDeliveryPayment(), today);
            System.out.println("Order 3 placed.");
        } catch (CheckoutException refused) {
            // A refused checkout throws; nothing was reserved or charged. We carry on.
            System.out.println("Order 3 refused: " + refused.getMessage());
            System.out.println("Refrigerator stock is still " + fridge.remaining());
        }
        System.out.println();

        // ---- A return within the window --------------------------------------------------
        order2.acceptReturn(0, today + 5);  // charger returned 5 days later (window is 7)
        System.out.println("Order 2: charger line returned.");
        System.out.println();

        // ---- Nightly settlement ----------------------------------------------------------
        SettlementReport report = marketplace.settle();
        System.out.println("=== Nightly settlement ===");
        for (SellerPayout payout : report.payouts()) {
            System.out.println(payout.seller() + ": sold Tk " + payout.grossSales()
                    + ", commission Tk " + payout.commission()
                    + ", refunds Tk " + payout.refunds()
                    + " -> payout Tk " + payout.payout());
        }
        System.out.println("Platform revenue: Tk " + report.platformRevenue());
    }

    // Prints a full price breakdown for one order's quote.
    private static void printQuote(String heading, PriceBreakdown b) {
        System.out.println(heading);
        System.out.println("  Subtotal    Tk " + b.subtotal());
        System.out.println("  Discount    Tk " + b.discount());
        System.out.println("  Delivery    Tk " + b.delivery());
        System.out.println("  VAT         Tk " + b.vat());
        System.out.println("  Insurance   Tk " + b.insurance());
        System.out.println("  Service fee Tk " + b.serviceFee());
        System.out.println("  Grand total Tk " + b.grandTotal());
    }
}
