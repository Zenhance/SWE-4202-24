package kenakata;

import kenakata.catalog.*;
import kenakata.exceptions.OutOfStockException;
import kenakata.order.DeliveryCalculator;
import kenakata.order.Zone;
import kenakata.settlement.Marketplace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Full behavioural test suite for the KenaKata engine.
 *
 * <p>The tests check <em>numbers and failures only</em> -- they never inspect how the design is
 * structured. Every monetary figure is a whole number of Taka, and every percentage result is
 * rounded UP to the next whole Taka (ceiling), so the expected values below are computed with
 * that rounding in mind.
 *
 * <p>Reusable sellers are created per test to keep the cases independent (stock is mutable).
 */
class KenaKataTest {

    private Seller seller() {
        return new Seller("Seller");
    }

    // A stocked good priced at 1200 with two units in an order (line value 2400) is the recurring
    // fixture in the worked example, so several tests reuse these exact figures.
    private StockedGood lamp(Seller s) {
        return new StockedGood("SKU-LAMP", "Table Lamp", 1200, 10, s, 1500);
    }

    // ================================================================================
    // 1. Per-item pricing: unit charge, per-unit VAT, and commission by kind.
    // ================================================================================
    @Nested
    @DisplayName("Item pricing")
    class ItemPricing {

        @Test
        @DisplayName("Stocked good: 7.5% VAT and 8% commission, both ceiled")
        void stockedGoodPricing() {
            StockedGood item = lamp(seller());
            assertEquals(1200, item.unitCharge());
            // 1200 * 7.5% = 90 exactly.
            assertEquals(90, item.unitVat());
            // 2400 * 8% = 192 exactly.
            assertEquals(192, item.commissionOn(2400));
        }

        @Test
        @DisplayName("Digital good: 5% VAT and 20% commission")
        void digitalGoodPricing() {
            DigitalGood item = new DigitalGood("SKU-EBK", "E-book", 300, 100, seller());
            assertEquals(300, item.unitCharge());
            assertEquals(15, item.unitVat());        // 300 * 5% = 15
            assertEquals(60, item.commissionOn(300)); // 300 * 20% = 60
        }

        @Test
        @DisplayName("Fresh good: VAT-exempt and 5% commission")
        void freshGoodPricing() {
            FreshGood item = new FreshGood("SKU-HILSA", "Hilsa", 1600, 4, seller(), 1000);
            assertEquals(0, item.unitVat());          // exempt
            assertEquals(80, item.commissionOn(1600)); // 1600 * 5% = 80
        }

        @Test
        @DisplayName("VAT rounds UP: a fractional per-unit VAT is ceiled")
        void vatRoundsUp() {
            // Gift wrap charge 50, VAT 7.5% -> 3.75 -> ceils to 4.
            assertEquals(4, new GiftWrap().unitVat());
            // Express handling charge 120, VAT 7.5% -> 9 exactly.
            assertEquals(9, new ExpressHandling().unitVat());
        }
    }

    // ================================================================================
    // 2. Stock reservation.
    // ================================================================================
    @Nested
    @DisplayName("Stock reservation")
    class Reservation {

        @Test
        @DisplayName("Reserving within stock lowers it by exactly the quantity")
        void reserveLowersStock() throws Exception {
            StockedGood item = new StockedGood("S", "Item", 100, 5, seller(), 100);
            item.reserve(3);
            assertEquals(2, item.remaining());
        }

        @Test
        @DisplayName("Reserving more than stock throws and leaves stock untouched")
        void reserveTooMuchThrows() {
            StockedGood item = new StockedGood("S", "Item", 100, 5, seller(), 100);
            assertThrows(OutOfStockException.class, () -> item.reserve(6));
            assertEquals(5, item.remaining());
        }

        @Test
        @DisplayName("Reserving a non-positive quantity is a construction-style error")
        void reserveNonPositiveThrows() {
            StockedGood item = new StockedGood("S", "Item", 100, 5, seller(), 100);
            assertThrows(IllegalArgumentException.class, () -> item.reserve(0));
            assertThrows(IllegalArgumentException.class, () -> item.reserve(-1));
        }
    }

    // ================================================================================
    // 3. Add-ons, including a warranty computed from its covered item.
    // ================================================================================
    @Nested
    @DisplayName("Add-ons")
    class AddOns {

        @Test
        @DisplayName("Flat add-ons expose their own charge, VAT, and label")
        void flatAddOns() {
            assertEquals(50, new GiftWrap().unitCharge());
            assertEquals(120, new ExpressHandling().unitCharge());
            assertEquals("Gift wrapping", new GiftWrap().label());
        }

        @Test
        @DisplayName("Warranty charge is 10% of the covered item's unit price, VAT 15%")
        void warrantyFromCoveredItem() {
            WarrantyPlan warranty = new WarrantyPlan(lamp(seller()));
            assertEquals(120, warranty.unitCharge());       // 10% of 1200
            assertEquals(18, warranty.unitVat());           // 15% of 120 = 18
            assertTrue(warranty.label().contains("Table Lamp"));
        }

        @Test
        @DisplayName("A warranty cannot cover a null item")
        void warrantyRejectsNull() {
            assertThrows(IllegalArgumentException.class, () -> new WarrantyPlan(null));
        }
    }

    // ================================================================================
    // 4. The full worked example: an order that must total to the taka.
    // ================================================================================
    @Nested
    @DisplayName("Full order pricing")
    class FullOrder {

        // Rebuilds the exact order from the specification's worked example.
        private Order workedExample() {
            Seller a = new Seller("A");
            Seller b = new Seller("B");
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("L", "Lamp", 1200, 10, a, 1500), 2);
            order.addProduct(new DigitalGood("E", "E-book", 300, 100, b), 1);
            order.addProduct(new FreshGood("H", "Hilsa", 1600, 4, a, 1000), 1);
            order.addAddOn(new GiftWrap());
            order.applyCoupon(new Coupon("EID10", 10, 200, 1000, 150));
            return order;
        }

        @Test
        @DisplayName("Every component matches the worked example, grand total 4583")
        void totalsToTheTaka() throws Exception {
            PriceBreakdown b = workedExample().quote(100);
            assertEquals(4350, b.subtotal());
            assertEquals(200, b.discount());     // 10% of 2400 = 240, capped at 200
            assertEquals(199, b.vat());          // 180 + 15 + 0 + 4
            assertEquals(190, b.delivery());     // 140 shipping + 50 cold chain
            assertEquals(0, b.insurance());
            assertEquals(44, b.serviceFee());    // 1% of 4350 = 43.5 -> 44
            assertEquals(4583, b.grandTotal());
        }
    }

    // ================================================================================
    // 5. Delivery: only weighable lines, billed-kg rounds up, cold chain per fresh line.
    // ================================================================================
    @Nested
    @DisplayName("Delivery")
    class Delivery {

        @Test
        @DisplayName("An all-digital order delivers for nothing")
        void allDigitalIsFree() throws Exception {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new DigitalGood("E", "E-book", 300, 100, seller()), 3);
            assertEquals(0, order.quote(1).delivery());
        }

        @Test
        @DisplayName("Weight rounds up to the next whole billed kilogram")
        void billedWeightRoundsUp() throws Exception {
            // One 1200 g line -> 1.2 kg -> billed 2 kg -> 60 + 2*20 = 100 inside Dhaka.
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 500, 10, seller(), 1200), 1);
            assertEquals(100, order.quote(1).delivery());
        }

        @Test
        @DisplayName("Only weighable lines count; digital and add-ons are ignored")
        void ignoresWeightlessLines() throws Exception {
            // Stocked 1000 g (1 kg) plus a digital line and a gift wrap: still just 1 billed kg.
            Order order = new Order(Zone.OUTSIDE, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 500, 10, seller(), 1000), 1);
            order.addProduct(new DigitalGood("E", "E-book", 300, 100, seller()), 1);
            order.addAddOn(new GiftWrap());
            // Outside Dhaka: 120 + 1*35 = 155, no cold chain.
            assertEquals(155, order.quote(1).delivery());
        }

        @Test
        @DisplayName("Each fresh line adds a cold-chain surcharge")
        void coldChainPerFreshLine() throws Exception {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new FreshGood("H", "Hilsa", 1600, 4, seller(), 1000), 1); // 1 kg
            // 60 + 1*20 shipping + 50 cold chain = 130.
            assertEquals(130, order.quote(1).delivery());
        }
    }

    // ================================================================================
    // 6. Coupons.
    // ================================================================================
    @Nested
    @DisplayName("Coupons")
    class Coupons {

        @Test
        @DisplayName("Discount applies to the discountable (stocked) base only, and is capped")
        void discountOnDiscountableBaseCapped() throws Exception {
            // Stocked 1000 x 2 = 2000 discountable; fresh 5000 not discountable.
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 1000, 10, seller(), 500), 2);
            order.addProduct(new FreshGood("H", "Hilsa", 5000, 10, seller(), 1000), 1);
            order.applyCoupon(new Coupon("C", 50, 20000, 0, 200)); // 50%, generous cap
            // 50% of 2000 (stocked only) = 1000, well under the cap.
            assertEquals(1000, order.quote(1).discount());
        }

        @Test
        @DisplayName("An expired coupon is refused")
        void expiredCouponThrows() {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 1000, 10, seller(), 500), 1);
            order.applyCoupon(new Coupon("C", 10, 200, 0, 50)); // valid through day 50
            assertThrows(CouponRejectedException.class, () -> order.quote(51));
        }

        @Test
        @DisplayName("A coupon below its minimum spend is refused")
        void belowMinimumSpendThrows() {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 500, 10, seller(), 500), 1);
            order.applyCoupon(new Coupon("C", 10, 200, 1000, 200)); // needs 1000, subtotal is 500
            assertThrows(CouponRejectedException.class, () -> order.quote(1));
        }

        @Test
        @DisplayName("Coupon percentage must be a valid 0..100")
        void couponConstructionValidated() {
            assertThrows(IllegalArgumentException.class, () -> new Coupon("C", -1, 200, 0, 100));
            assertThrows(IllegalArgumentException.class, () -> new Coupon("C", 101, 200, 0, 100));
        }
    }

    // ================================================================================
    // 7. Insurance abilities.
    // ================================================================================
    @Nested
    @DisplayName("Insurance")
    class Insurance {

        @Test
        @DisplayName("Insuring an insurable line adds a fee of 1% of its value")
        void insurableLineAddsFee() throws Exception {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(lamp(seller()), 2); // value 2400
            order.insure(0);
            // 1% of 2400 = 24, above the 20 minimum.
            assertEquals(24, order.quote(1).insurance());
        }

        @Test
        @DisplayName("Insurance never falls below the 20 Taka minimum")
        void insuranceMinimumApplies() throws Exception {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new StockedGood("S", "Item", 1000, 10, seller(), 500), 1); // value 1000
            order.insure(0);
            // 1% of 1000 = 10, lifted to the 20 minimum.
            assertEquals(20, order.quote(1).insurance());
        }

        @Test
        @DisplayName("Insuring a line that cannot be insured is refused")
        void insuringNonInsurableThrows() {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(new DigitalGood("E", "E-book", 300, 100, seller()), 1); // not insurable
            order.addAddOn(new GiftWrap());                                           // not insurable
            assertThrows(NotInsurableException.class, () -> order.insure(0));
            assertThrows(NotInsurableException.class, () -> order.insure(1));
        }
    }

    // ================================================================================
    // 8. Placement is all-or-nothing.
    // ================================================================================
    @Nested
    @DisplayName("Atomic placement")
    class AtomicPlacement {

        @Test
        @DisplayName("A declined payment reserves no stock and moves no money")
        void declinedPaymentChangesNothing() {
            Seller s = seller();
            StockedGood item = lamp(s); // stock 10
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(item, 2);
            Wallet wallet = new Wallet(100); // far too little
            assertThrows(EmptyWalletException.class,
                    () -> order.place(new MobileWalletPayment(wallet), 1));
            assertEquals(10, item.remaining()); // stock untouched
            assertEquals(100, wallet.balance()); // balance untouched
            assertFalse(order.placed());
        }

        @Test
        @DisplayName("An out-of-stock line reserves nothing and never reaches payment")
        void outOfStockChangesNothing() {
            StockedGood item = new StockedGood("S", "Item", 100, 1, seller(), 500); // stock 1
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(item, 2); // wants 2
            Wallet wallet = new Wallet(1_000_000);
            assertThrows(OutOfStockException.class,
                    () -> order.place(new MobileWalletPayment(wallet), 1));
            assertEquals(1, item.remaining());
            assertEquals(1_000_000, wallet.balance()); // payment was never attempted
        }

        @Test
        @DisplayName("An invalid coupon aborts placement before anything moves")
        void invalidCouponChangesNothing() {
            StockedGood item = lamp(seller());
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(item, 2);
            order.applyCoupon(new Coupon("C", 10, 200, 0, 5)); // expired by day 6
            Wallet wallet = new Wallet(1_000_000);
            assertThrows(CouponRejectedException.class,
                    () -> order.place(new MobileWalletPayment(wallet), 6));
            assertEquals(10, item.remaining());
            assertEquals(1_000_000, wallet.balance());
        }

        @Test
        @DisplayName("A successful placement reserves stock and records the breakdown")
        void successfulPlacement() throws Exception {
            StockedGood item = lamp(seller());
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(item, 2);
            order.place(new CardPayment(1_000_000), 1);
            assertEquals(8, item.remaining());
            assertTrue(order.placed());
            assertNotNull(order.finalBreakdown());
        }
    }

    // ================================================================================
    // 9. Payment methods: distinct refusals, all catchable as the common parent.
    // ================================================================================
    @Nested
    @DisplayName("Payment refusals")
    class PaymentRefusals {

        @Test
        @DisplayName("An empty wallet throws its own kind, catchable as the parent")
        void emptyWallet() {
            PaymentMethod pay = new MobileWalletPayment(new Wallet(50));
            EmptyWalletException e =
                    assertThrows(EmptyWalletException.class, () -> pay.authorise(51));
            assertInstanceOf(PaymentDeclinedException.class, e);
            assertInstanceOf(CheckoutException.class, e);
        }

        @Test
        @DisplayName("A card over its limit throws its own kind")
        void cardOverLimit() {
            CardPayment card = new CardPayment(100);
            assertThrows(CardLimitExceededException.class, () -> card.authorise(101));
            assertEquals(100, card.remainingLimit()); // nothing charged on refusal
        }

        @Test
        @DisplayName("A card exactly at its limit succeeds and draws down to zero")
        void cardExactlyAtLimit() throws Exception {
            CardPayment card = new CardPayment(100);
            card.authorise(100);
            assertEquals(0, card.remainingLimit());
        }

        @Test
        @DisplayName("COD at the ceiling passes; one Taka over is refused")
        void codCeilingBoundary() throws Exception {
            new CashOnDeliveryPayment().authorise(15000); // exactly the ceiling: allowed
            assertThrows(CodCeilingExceededException.class,
                    () -> new CashOnDeliveryPayment().authorise(15001));
        }

        @Test
        @DisplayName("A wallet with exactly enough pays and lands at zero")
        void walletExactBalance() throws Exception {
            Wallet wallet = new Wallet(500);
            new MobileWalletPayment(wallet).authorise(500);
            assertEquals(0, wallet.balance());
        }
    }

    // ================================================================================
    // 10. Returns respect the returnable ability and the window.
    // ================================================================================
    @Nested
    @DisplayName("Returns")
    class Returns {

        private Order placedOrderWith(Chargeable... units) throws Exception {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            for (Chargeable unit : units) {
                if (unit instanceof CatalogItem item) {
                    order.addProduct(item, 1);
                } else {
                    order.addAddOn(unit);
                }
            }
            order.place(new CardPayment(1_000_000), 100);
            return order;
        }

        @Test
        @DisplayName("A returnable line comes back within its window")
        void returnWithinWindow() throws Exception {
            Order order = placedOrderWith(lamp(seller())); // stocked window is 7 days
            order.acceptReturn(0, 105); // placed day 100, within 7 days
            assertTrue(order.lines().get(0).returned());
        }

        @Test
        @DisplayName("A return after the window is refused")
        void returnPastWindowThrows() throws Exception {
            Order order = placedOrderWith(new FreshGood("H", "Hilsa", 1600, 4, seller(), 1000));
            // Fresh window is 2 days; day 103 is past 100 + 2.
            assertThrows(ReturnNotAllowedException.class, () -> order.acceptReturn(0, 103));
        }

        @Test
        @DisplayName("A non-returnable line cannot be returned")
        void nonReturnableThrows() throws Exception {
            Order order = placedOrderWith(new DigitalGood("E", "E-book", 300, 100, seller()));
            assertThrows(ReturnNotAllowedException.class, () -> order.acceptReturn(0, 100));
        }

        @Test
        @DisplayName("The same line cannot be returned twice")
        void doubleReturnThrows() throws Exception {
            Order order = placedOrderWith(lamp(seller()));
            order.acceptReturn(0, 101);
            assertThrows(ReturnNotAllowedException.class, () -> order.acceptReturn(0, 102));
        }
    }

    // ================================================================================
    // 11. Settlement pays each seller correctly and reconciles with the platform.
    // ================================================================================
    @Nested
    @DisplayName("Settlement")
    class Settlement {

        @Test
        @DisplayName("Per-seller payouts and platform revenue, and the whole day reconciles")
        void settlesAndReconciles() throws Exception {
            Seller a = new Seller("A");
            Seller b = new Seller("B");
            StockedGood p1 = new StockedGood("P1", "Widget", 1000, 10, a, 500); // VAT 75, comm 8%
            DigitalGood p2 = new DigitalGood("P2", "Manual", 500, 10, b);       // VAT 25, comm 20%

            Marketplace market = new Marketplace();
            market.register(a);
            market.register(b);

            // Order 1: 2 x p1 (seller A) + 1 x p2 (seller B). Grand total 2780.
            Order o1 = new Order(Zone.DHAKA, new DeliveryCalculator());
            o1.addProduct(p1, 2);
            o1.addProduct(p2, 1);
            o1.place(new CardPayment(1_000_000), 1);
            long grand1 = o1.finalBreakdown().grandTotal();
            assertEquals(2780, grand1);
            market.record(o1);

            // Order 2: 1 x p1 (seller A) + gift wrap. Grand total 1220.
            Order o2 = new Order(Zone.DHAKA, new DeliveryCalculator());
            o2.addProduct(p1, 1);
            o2.addAddOn(new GiftWrap());
            o2.place(new CardPayment(1_000_000), 1);
            long grand2 = o2.finalBreakdown().grandTotal();
            assertEquals(1220, grand2);
            market.record(o2);

            SettlementReport report = market.settle();

            // Seller A: sold 3000, commission 240, payout 2760.
            SellerPayout pa = report.forSeller(a);
            assertEquals(3000, pa.grossSales());
            assertEquals(240, pa.commission());
            assertEquals(2760, pa.payout());

            // Seller B: sold 500, commission 100, payout 400.
            assertEquals(400, report.forSeller(b).payout());

            // Platform keeps commissions + add-ons + delivery + VAT + service fee - discounts.
            assertEquals(840, report.platformRevenue());

            // Nothing is created or lost: seller payouts + platform revenue == what customers paid.
            long paidByCustomers = grand1 + grand2;
            long distributed = pa.payout() + report.forSeller(b).payout() + report.platformRevenue();
            assertEquals(paidByCustomers, distributed);
        }

        @Test
        @DisplayName("A returned line reduces its seller's payout by the line value")
        void returnReducesPayout() throws Exception {
            Seller a = new Seller("A");
            StockedGood p1 = new StockedGood("P1", "Widget", 1000, 10, a, 500);

            Marketplace market = new Marketplace();
            market.register(a);

            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            order.addProduct(p1, 2); // value 2000
            order.place(new CardPayment(1_000_000), 1);
            order.acceptReturn(0, 3); // within the 7-day window
            market.record(order);

            SellerPayout pa = market.settle().forSeller(a);
            // Gross 2000, commission 160, refund 2000 -> payout 2000 - 160 - 2000 = -160.
            assertEquals(2000, pa.refunds());
            assertEquals(-160, pa.payout());
        }
    }

    // ================================================================================
    // 12. Polymorphism: one variable stands in for every payment method.
    // ================================================================================
    @Test
    @DisplayName("A single PaymentMethod variable acts as wallet, card, then COD")
    void onePaymentVariableManyForms() throws Exception {
        PaymentMethod payment;

        payment = new MobileWalletPayment(new Wallet(1000));
        payment.authorise(100);

        payment = new CardPayment(1000);
        payment.authorise(100);

        payment = new CashOnDeliveryPayment();
        payment.authorise(100);
        // No exception from any form: the same slot dispatched to three unrelated implementations.
        assertTrue(true);
    }

    // ================================================================================
    // 13. Construction-time validation: a malformed object must not come into existence.
    // ================================================================================
    @Nested
    @DisplayName("Construction validation")
    class Construction {

        @Test
        @DisplayName("A catalogue item rejects null identity, negative price, and negative stock")
        void catalogItemValidation() {
            Seller s = seller();
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood(null, "T", 100, 1, s, 100));
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood("S", " ", 100, 1, s, 100));
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood("S", "T", 100, 1, null, 100));
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood("S", "T", -1, 1, s, 100));
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood("S", "T", 100, -1, s, 100));
            assertThrows(IllegalArgumentException.class,
                    () -> new StockedGood("S", "T", 100, 1, s, 0)); // non-positive weight
        }

        @Test
        @DisplayName("A wallet cannot start with a negative balance")
        void walletValidation() {
            assertThrows(IllegalArgumentException.class, () -> new Wallet(-1));
        }

        @Test
        @DisplayName("An order line rejects a non-positive quantity")
        void orderLineQuantityValidation() {
            Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
            assertThrows(IllegalArgumentException.class, () -> order.addProduct(lamp(seller()), 0));
            assertThrows(IllegalArgumentException.class, () -> order.addProduct(lamp(seller()), -2));
        }
    }

    // ================================================================================
    // 14. Service fee is capped.
    // ================================================================================
    @Test
    @DisplayName("The service fee is capped at 100 Taka for large orders")
    void serviceFeeIsCapped() throws Exception {
        Order order = new Order(Zone.DHAKA, new DeliveryCalculator());
        order.addProduct(new StockedGood("S", "Big", 20000, 10, seller(), 500), 1);
        // 1% of 20000 = 200, but capped at 100.
        assertEquals(100, order.quote(1).serviceFee());
    }
}
