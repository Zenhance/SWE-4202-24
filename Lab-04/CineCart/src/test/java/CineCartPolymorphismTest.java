import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import model.Cart;
import model.ComboLine;
import model.ConcessionItem;
import model.ConcessionLine;
import model.Customer;
import model.Hall;
import model.LineItem;
import model.Movie;
import model.PremiumTicket;
import model.Showtime;
import model.StandardTicket;
import model.StudentTicket;
import model.VIPTicket;
import data.ConcessionMenu;
import data.ShowtimeBoard;
import engine.CheckoutEngine;

/**
 * CineCartPolymorphismTest.java
 * <p>
 * Test suite for OOP Lab 4 Extension II — Polymorphism &amp; Inheritance.
 * DO NOT MODIFY THIS FILE.
 * <p>
 * Run from the CineCart project root with:
 *     ./gradlew test
 * <p>
 * Passing every test here is necessary but not sufficient — the design marks
 * (one interchangeable family answering a shared call, rather than instanceof
 * ladders) are assessed by inspection and viva. A few of those structural
 * properties are pinned below as reflection checks.
 */
public class CineCartPolymorphismTest {

    private static final double EPS = 1e-9;

    // ------------------------------------------------------------------
    // Fixture: one peak showtime (base 350) and one off-peak (base 200)
    // ------------------------------------------------------------------
    private static final Movie PEAK_MOVIE = new Movie(1, "Inception", "PG-13", 148, 350.00);
    private static final Movie OFF_MOVIE  = new Movie(3, "Toy Story 4", "G", 100, 200.00);
    private static final Hall  HALL       = new Hall(2, 6, 10, 2);

    private static Showtime peakShow() { return new Showtime(17, PEAK_MOVIE, HALL, 19, "Fri"); }
    private static Showtime offShow()  { return new Showtime(19, OFF_MOVIE,  HALL, 11, "Sat"); }

    private static ConcessionItem pop()   { return new ConcessionItem("POP",   "Popcorn (Large)", 220.00); }
    private static ConcessionItem soda()  { return new ConcessionItem("SODA",  "Soda (Large)",    120.00); }
    private static ConcessionItem nacho() { return new ConcessionItem("NACHO", "Nachos",          180.00); }

    private static Cart cartFor(String tier) {
        return new Cart(new Customer(1, "Alice", 28, tier));
    }

    // ==================================================================
    // The four fares — each its own rule, at peak and off-peak
    // ==================================================================

    @Test
    void standardFare_isBaseTimesPeak() {
        assertEquals(350.00 * 1.20, new StandardTicket(peakShow(), 0, 0).subtotal(), EPS);
        assertEquals(200.00,        new StandardTicket(offShow(),  0, 0).subtotal(), EPS);
    }

    @Test
    void premiumFare_is130PercentOfBase() {
        assertEquals(350.00 * 1.30 * 1.20, new PremiumTicket(peakShow(), 0, 0).subtotal(), EPS);
        assertEquals(200.00 * 1.30,        new PremiumTicket(offShow(),  0, 0).subtotal(), EPS);
    }

    @Test
    void studentFare_isHalfBase() {
        assertEquals(350.00 * 0.50 * 1.20, new StudentTicket(peakShow(), 0, 0).subtotal(), EPS);
        assertEquals(200.00 * 0.50,        new StudentTicket(offShow(),  0, 0).subtotal(), EPS);
    }

    // ==================================================================
    // VIP is a special premium — and tracks it
    // ==================================================================

    @Test
    void vipFare_equalsPremiumPlusLounge() {
        Showtime st = peakShow();
        PremiumTicket premium = new PremiumTicket(st, 2, 4);
        VIPTicket     vip     = new VIPTicket(st, 2, 4);
        assertEquals(premium.subtotal() + 200.00, vip.subtotal(), EPS);

        // A different base: VIP must still be exactly premium + lounge, with no
        // VIP-specific arithmetic of its own — proof it reuses the premium charge.
        Showtime other = offShow();
        assertEquals(new PremiumTicket(other, 1, 1).subtotal() + 200.00,
                     new VIPTicket(other, 1, 1).subtotal(), EPS);
    }

    @Test
    void vipDescription_extendsPremiumDescription() {
        Showtime st = peakShow();
        String premiumDesc = new PremiumTicket(st, 2, 4).describe();
        String vipDesc     = new VIPTicket(st, 2, 4).describe();
        assertTrue(vipDesc.contains(premiumDesc),
                "VIP description must contain the premium description as a substring, got: " + vipDesc);
        assertTrue(vipDesc.toLowerCase().contains("lounge"),
                "VIP description must add a lounge marker, got: " + vipDesc);
    }

    @Test
    void studentDescription_extendsStandardDescription() {
        Showtime st = peakShow();
        String standardDesc = new StandardTicket(st, 1, 1).describe();
        String studentDesc  = new StudentTicket(st, 1, 1).describe();
        assertTrue(studentDesc.contains(standardDesc),
                "Student description must build on the standard description, got: " + studentDesc);
    }

    // ==================================================================
    // Snack lines
    // ==================================================================

    @Test
    void concessionLine_isUnitPriceTimesQty() {
        assertEquals(220.00 * 3, new ConcessionLine(pop(), 3).subtotal(), EPS);
    }

    @Test
    void comboLine_isPairMinusFifty() {
        assertEquals((220.00 + 120.00) - 50.00, new ComboLine(pop(), soda()).subtotal(), EPS);
    }

    // ==================================================================
    // One collection, one pass — heterogeneous lines under one type
    // ==================================================================

    @Test
    void lineItem_commonType_holdsAnyChargeableLine() {
        // A single variable of the common type stands in for any of the six.
        LineItem[] batch = {
            new StandardTicket(peakShow(), 0, 0),
            new PremiumTicket(peakShow(), 0, 1),
            new StudentTicket(offShow(), 1, 0),
            new VIPTicket(peakShow(), 1, 1),
            new ConcessionLine(pop(), 2),
            new ComboLine(pop(), soda())
        };
        double sum = 0.0;
        for (LineItem line : batch) sum += line.subtotal();   // one call name, six behaviours
        assertEquals(6, batch.length);
        assertTrue(sum > 0.0);
    }

    @Test
    void cart_holdsMixedLines_inOneCollection() {
        Cart cart = cartFor("BASIC");
        cart.add(new StandardTicket(peakShow(), 0, 0));
        cart.add(new VIPTicket(peakShow(), 0, 1));
        cart.add(new ConcessionLine(pop(), 1));
        cart.add(new ComboLine(pop(), soda()));
        assertEquals(4, cart.getLines().length,
                "getLines() length must equal the number of lines added");
    }

    @Test
    void cart_getLines_isDefensiveCopy() {
        Cart cart = cartFor("BASIC");
        cart.add(new StandardTicket(peakShow(), 0, 0));
        cart.add(new ConcessionLine(pop(), 1));
        double before = cart.grandSubtotal();

        LineItem[] snapshot = cart.getLines();
        snapshot[0] = null;   // an outsider tries to corrupt the cart

        LineItem[] after = cart.getLines();
        assertEquals(2, after.length);
        assertNotNull(after[0], "writing null into the snapshot must not affect the cart");
        assertEquals(before, cart.grandSubtotal(), EPS,
                "grand subtotal must be unaffected by writes to the snapshot");
    }

    @Test
    void cart_grandSubtotal_equalsSumOfEachLinesOwnRule() {
        Cart cart = cartFor("BASIC");
        LineItem a = new StandardTicket(offShow(), 0, 0);   // 200
        LineItem b = new PremiumTicket(peakShow(), 0, 1);   // 546
        LineItem c = new StudentTicket(peakShow(), 0, 2);   // 210
        LineItem d = new ConcessionLine(pop(), 2);          // 440
        LineItem e = new ComboLine(pop(), soda());          // 290
        cart.add(a); cart.add(b); cart.add(c); cart.add(d); cart.add(e);

        double handSummed = a.subtotal() + b.subtotal() + c.subtotal()
                          + d.subtotal() + e.subtotal();
        assertEquals(handSummed, cart.grandSubtotal(), EPS,
                "grandSubtotal must equal the sum of each element's own subtotal()");
        assertEquals(1686.00, cart.grandSubtotal(), EPS);   // the concrete figure
    }

    // ==================================================================
    // Overloaded add: one name, two input shapes, resolved at the call site
    // ==================================================================

    @Test
    void cart_add_isOverloaded() {
        Cart single = cartFor("BASIC");
        single.add(pop());            // short form: quantity one
        Cart explicitOne = cartFor("BASIC");
        explicitOne.add(pop(), 1);    // full form: quantity stated
        assertEquals(single.grandSubtotal(), explicitOne.grandSubtotal(), EPS,
                "add(item) and add(item, 1) must charge the same");

        Cart triple = cartFor("BASIC");
        triple.add(pop(), 3);
        assertEquals(3 * single.grandSubtotal(), triple.grandSubtotal(), EPS,
                "add(item, 3) must charge triple");
    }

    // ==================================================================
    // Queries the engine needs — answered by the lines, not an if-ladder
    // ==================================================================

    @Test
    void cart_ticketCount_countsOnlyTickets() {
        Cart cart = cartFor("BASIC");
        cart.add(new StandardTicket(peakShow(), 0, 0));
        cart.add(new VIPTicket(peakShow(), 0, 1));
        cart.add(new StudentTicket(offShow(), 1, 0));
        cart.add(new ConcessionLine(pop(), 1));
        cart.add(new ComboLine(pop(), soda()));
        assertEquals(3, cart.ticketCount(),
                "ticketCount must count fares only, not snack lines");
    }

    @Test
    void cart_hasCode_findsBundledAndSingleSnacks() {
        Cart cart = cartFor("BASIC");
        cart.add(new ConcessionLine(pop(), 1));      // single POP
        cart.add(new ComboLine(nacho(), soda()));    // SODA bundled inside a combo
        assertTrue(cart.hasCode("POP"),   "hasCode must find a single snack line");
        assertTrue(cart.hasCode("SODA"),  "hasCode must find a code carried inside a bundle");
        assertTrue(cart.hasCode("NACHO"), "hasCode must find the other bundled item too");
        assertFalse(cart.hasCode("WATER"), "hasCode must return false for an absent code");
    }

    // ==================================================================
    // End-to-end: the unified pipeline reproduces the Lab 4 numbers
    // ==================================================================

    @Test
    void checkout_total_matchesLab4Pipeline() {
        Cart cart = cartFor("GOLD");
        // 4 premium peak fares at 350*1.30*1.20 = 546 each
        cart.add(new PremiumTicket(peakShow(), 0, 0));
        cart.add(new PremiumTicket(peakShow(), 0, 1));
        cart.add(new PremiumTicket(peakShow(), 0, 2));
        cart.add(new PremiumTicket(peakShow(), 0, 3));
        cart.add(pop(), 1);
        cart.add(soda(), 1);

        // tickets 2184 + snacks 340 = 2524; combo -50 => 2474
        // group 247.40, tier(GOLD) 371.10 => after 1855.50; tax 92.775 => 1948.28
        CheckoutEngine engine = new CheckoutEngine(new ShowtimeBoard(), new ConcessionMenu());
        assertEquals(1948.28, engine.checkout(cart), 0.01);
    }

    @Test
    void checkout_groupDiscountNeedsFourTickets() {
        Cart cart = cartFor("GOLD");
        cart.add(new PremiumTicket(peakShow(), 0, 0));
        cart.add(new PremiumTicket(peakShow(), 0, 1));
        cart.add(new PremiumTicket(peakShow(), 0, 2));
        // 3 tickets => no group discount: pre 1638; tier(GOLD) 245.70; after 1392.30; tax 69.615 => 1461.92
        CheckoutEngine engine = new CheckoutEngine(new ShowtimeBoard(), new ConcessionMenu());
        assertEquals(1461.92, engine.checkout(cart), 0.01);
    }

    // ==================================================================
    // Structural / design properties (inspection, pinned as reflection)
    // ==================================================================

    @Test
    void design_commonTypesAreAbstract_soNoRuleLessLineCanExist() {
        assertTrue(Modifier.isAbstract(LineItem.class.getModifiers()),
                "LineItem must be abstract: a charge-less line must not be instantiable");
        assertTrue(Modifier.isAbstract(AbstractTicket.class.getModifiers()),
                "The shared ticket base must be abstract: a rule-less ticket must not exist");
    }

    @Test
    void design_everySaleableTypeIsALineItem() {
        assertTrue(LineItem.class.isAssignableFrom(StandardTicket.class));
        assertTrue(LineItem.class.isAssignableFrom(PremiumTicket.class));
        assertTrue(LineItem.class.isAssignableFrom(StudentTicket.class));
        assertTrue(LineItem.class.isAssignableFrom(VIPTicket.class));
        assertTrue(LineItem.class.isAssignableFrom(ConcessionLine.class));
        assertTrue(LineItem.class.isAssignableFrom(ComboLine.class));
    }

    @Test
    void design_vipIsASpecialisationOfPremium() {
        assertTrue(PremiumTicket.class.isAssignableFrom(VIPTicket.class),
                "VIPTicket must extend PremiumTicket (is-a), not merely know its formula");
    }

    @Test
    void design_comboIsOwnershipNotKinship() {
        assertFalse(ConcessionLine.class.isAssignableFrom(ComboLine.class),
                "ComboLine must NOT extend ConcessionLine — a bundle is not a kind of single item");
        assertTrue(LineItem.class.isAssignableFrom(ComboLine.class),
                "ComboLine is still a chargeable line");
    }

    @Test
    void design_baseFigureIsSealedToTheTicketFamily() throws Exception {
        Field base = AbstractTicket.class.getDeclaredField("base");
        int mod = base.getModifiers();
        assertTrue(Modifier.isProtected(mod),
                "base must be protected: reachable by descendants, sealed against outsiders");
        assertFalse(Modifier.isPublic(mod), "base must not be public");
    }
}
