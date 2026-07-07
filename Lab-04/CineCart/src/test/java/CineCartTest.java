import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import Model.Cart;
import Model.ConcessionItem;
import Model.Customer;
import Model.Hall;
import Model.Movie;
import Model.Seat;
import Model.Showtime;
import Model.Ticket;
import Data.ConcessionMenu;
import Data.ShowtimeBoard;
import engine.CheckoutEngine;
import io.CsvLoader;

/**
 * CineCartTest.java
 * <p>
 * Test suite for OOP Lab 4 - CineCart.
 * DO NOT MODIFY THIS FILE.
 * <p>
 * Run from the CineCart project root with:
 *     ./gradlew test
 * or from IntelliJ via the Gradle tool window.
 */
public class CineCartTest {

    // ============================================================
    // Part A - Movie, Seat, Hall  [3 marks]
    // ============================================================

    @Test
    void movie_getMinAge_returnsCorrectValueForEachRating() {
        assertEquals(0,  new Movie(1, "T", "G",     90, 100).getMinAge());
        assertEquals(7,  new Movie(2, "T", "PG",    90, 100).getMinAge());
        assertEquals(13, new Movie(3, "T", "PG-13", 90, 100).getMinAge());
        assertEquals(18, new Movie(4, "T", "R",     90, 100).getMinAge());
    }

    @Test
    void movie_storesAllFieldsViaGetters() {
        Movie m = new Movie(7, "Inception", "PG-13", 148, 350.00);
        assertEquals(7,           m.getId());
        assertEquals("Inception", m.getTitle());
        assertEquals("PG-13",     m.getRating());
        assertEquals(148,         m.getDurationMin());
        assertEquals(350.00,      m.getBasePrice(), 1e-9);
    }

    @Test
    void seat_startsAvailable_andCanBeBookedAndReleased() {
        Seat s = new Seat(2, 5, true);
        assertTrue (s.isAvailable());
        assertFalse(s.isBooked());
        s.book();
        assertFalse(s.isAvailable());
        assertTrue (s.isBooked());
        s.release();
        assertTrue (s.isAvailable());
    }

    @Test
    void hall_buildsGridAndMarksFirstRowsPremium() {
        Hall h = new Hall(1, 5, 8, 2);
        assertEquals(5, h.getRows());
        assertEquals(8, h.getCols());
        // Premium rows
        assertTrue (h.getSeat(0, 0).isPremium());
        assertTrue (h.getSeat(1, 7).isPremium());
        assertFalse(h.getSeat(2, 0).isPremium());
        assertFalse(h.getSeat(4, 7).isPremium());
        // All available initially
        assertEquals(5 * 8, h.countAvailable());
    }

    @Test
    void hall_countAvailable_decrementsAfterBooking() {
        Hall h = new Hall(1, 3, 3, 1);
        assertEquals(9, h.countAvailable());
        h.getSeat(0, 0).book();
        h.getSeat(2, 2).book();
        assertEquals(7, h.countAvailable());
    }

    // ============================================================
    // Part B - Showtime, Customer, Ticket, ConcessionItem  [3 marks]
    // ============================================================

    @Test
    void showtime_isPeak_returnsTrueBetween18And21Inclusive() {
        Movie m = new Movie(1, "X", "G", 90, 100);
        Hall  h = new Hall(1, 3, 3, 1);
        assertTrue (new Showtime(1, m, h, 18, "Fri").isPeak());
        assertTrue (new Showtime(1, m, h, 19, "Fri").isPeak());
        assertTrue (new Showtime(1, m, h, 21, "Fri").isPeak());
        assertFalse(new Showtime(1, m, h, 17, "Fri").isPeak());
        assertFalse(new Showtime(1, m, h, 22, "Fri").isPeak());
        assertFalse(new Showtime(1, m, h, 11, "Sat").isPeak());
    }

    @Test
    void customer_defaultTierIsBasic_andTierDiscountIsZero() {
        Customer c = new Customer(1, "Bob", 16);
        assertEquals("BASIC", c.getLoyaltyTier());
        assertEquals(0.0, c.getTierDiscount(), 1e-9);
    }

    @Test
    void customer_getTierDiscount_returnsCorrectValueForEachTier() {
        assertEquals(0.15, new Customer(1, "G", 30, "GOLD"  ).getTierDiscount(), 1e-9);
        assertEquals(0.08, new Customer(2, "S", 30, "SILVER").getTierDiscount(), 1e-9);
        assertEquals(0.00, new Customer(3, "B", 30, "BASIC" ).getTierDiscount(), 1e-9);
    }

    @Test
    void ticket_storesAllFields() {
        Movie m = new Movie(1, "Inception", "PG-13", 148, 350.00);
        Showtime st = new Showtime(17, m, new Hall(2, 6, 10, 2), 19, "Fri");
        Ticket t = new Ticket(st, 0, 0, 546.00);
        assertSame  (st,     t.getShowtime());
        assertEquals(0,      t.getRow());
        assertEquals(0,      t.getCol());
        assertEquals(546.00, t.getPricePaid(), 1e-9);
    }

    @Test
    void concessionItem_storesAllFields() {
        ConcessionItem c = new ConcessionItem("POP", "Popcorn (Large)", 220.00);
        assertEquals("POP",             c.getCode());
        assertEquals("Popcorn (Large)", c.getName());
        assertEquals(220.00,            c.getUnitPrice(), 1e-9);
    }

    // ============================================================
    // Part C - Cart  [2 marks]
    // ============================================================

    @Test
    void cart_addTicketAndAddItem_increaseCounts_andHasItemFindsByCode() {
        Customer alice = new Customer(1, "Alice", 28, "GOLD");
        Cart cart = new Cart(alice);
        assertEquals(0, cart.getTicketCount());
        assertEquals(0, cart.getItemCount());

        Movie m  = new Movie(1, "Inception", "PG-13", 148, 350.00);
        Showtime st = new Showtime(17, m, new Hall(2, 6, 10, 2), 19, "Fri");
        cart.addTicket(new Ticket(st, 0, 0, 546.00));
        cart.addTicket(new Ticket(st, 0, 1, 546.00));
        assertEquals(2, cart.getTicketCount());

        cart.addItem(new ConcessionItem("POP",  "Popcorn", 220.00), 1);
        cart.addItem(new ConcessionItem("SODA", "Soda",    120.00), 2);
        assertEquals(2, cart.getItemCount());
        assertTrue (cart.hasItem("POP"));
        assertTrue (cart.hasItem("SODA"));
        assertFalse(cart.hasItem("NACHO"));
    }

    @Test
    void cart_sums_areCorrect() {
        Customer alice = new Customer(1, "Alice", 28, "GOLD");
        Cart cart = new Cart(alice);
        Movie m  = new Movie(1, "X", "G", 90, 100);
        Showtime st = new Showtime(1, m, new Hall(1, 3, 3, 1), 14, "Sat");
        cart.addTicket(new Ticket(st, 0, 0, 100.00));
        cart.addTicket(new Ticket(st, 0, 1, 200.00));
        assertEquals(300.00, cart.sumTicketsPaid(), 1e-9);

        cart.addItem(new ConcessionItem("POP",   "P", 220.00), 2);
        cart.addItem(new ConcessionItem("WATER", "W",  60.00), 3);
        assertEquals(220 * 2 + 60 * 3, cart.sumConcessionsRaw(), 1e-9);
    }

    // ============================================================
    // Part D - Data layer  [1 mark]
    // ============================================================

    @Test
    void showtimeBoard_findById_returnsHitOrNull() {
        ShowtimeBoard b = new ShowtimeBoard();
        Movie m1 = new Movie(1, "A", "G", 90, 100);
        Movie m2 = new Movie(2, "B", "R", 90, 100);
        Showtime s1 = new Showtime(17, m1, new Hall(1, 3, 3, 1), 19, "Fri");
        Showtime s2 = new Showtime(18, m2, new Hall(2, 3, 3, 1), 21, "Fri");
        b.add(s1);
        b.add(s2);
        assertSame(s1, b.findById(17));
        assertSame(s2, b.findById(18));
        assertNull(b.findById(99));
    }

    @Test
    void concessionMenu_findByCode_returnsHitOrNull() {
        ConcessionMenu menu = new ConcessionMenu();
        ConcessionItem pop  = new ConcessionItem("POP",  "Popcorn", 220.00);
        ConcessionItem soda = new ConcessionItem("SODA", "Soda",    120.00);
        menu.add(pop);
        menu.add(soda);
        assertSame(pop,  menu.findByCode("POP"));
        assertSame(soda, menu.findByCode("SODA"));
        assertNull(menu.findByCode("MISSING"));
    }

    // ============================================================
    // Shared fixture for engine tests
    // ============================================================

    private static class Fixture {
        final ShowtimeBoard  board;
        final ConcessionMenu menu;
        final CheckoutEngine engine;
        final Customer alice;   // GOLD, 28
        final Customer bob;     // BASIC, 16
        final Customer carol;   // SILVER, 35
        final Hall hall1;       // 5x8, premiumRows=1
        final Hall hall2;       // 6x10, premiumRows=2
        final Showtime t17;     // Inception, hall2, 19:00 (peak)
        final Showtime t18;     // Godfather, hall1, 21:00 (peak)
        final Showtime t19;     // Toy Story, hall1, 11:00 (off-peak)

        Fixture() {
            Movie inception = new Movie(1, "Inception",     "PG-13", 148, 350.00);
            Movie godfather = new Movie(2, "The Godfather", "R",     175, 300.00);
            Movie toy       = new Movie(3, "Toy Story 4",   "G",     100, 250.00);

            hall1 = new Hall(1, 5,  8, 1); // row 0 premium
            hall2 = new Hall(2, 6, 10, 2); // rows 0..1 premium

            board = new ShowtimeBoard();
            t17 = new Showtime(17, inception, hall2, 19, "Fri");
            t18 = new Showtime(18, godfather, hall1, 21, "Fri");
            t19 = new Showtime(19, toy,       hall1, 11, "Sat");
            board.add(t17);
            board.add(t18);
            board.add(t19);

            menu = new ConcessionMenu();
            menu.add(new ConcessionItem("POP",   "Popcorn (Large)", 220.00));
            menu.add(new ConcessionItem("SODA",  "Soda (Large)",    120.00));
            menu.add(new ConcessionItem("NACHO", "Nachos",          180.00));

            alice = new Customer(1, "Alice", 28, "GOLD");
            bob   = new Customer(2, "Bob",   16, "BASIC");
            carol = new Customer(3, "Carol", 35, "SILVER");

            engine = new CheckoutEngine(board, menu);
        }
    }

    // ============================================================
    // Part E - Booking flow  [3 marks]
    // ============================================================

    @Test
    void bookTicket_unknownShowtime_returnsErrorAndDoesNotChangeCart() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        String result = f.engine.bookTicket(cart, 999, 0, 0);
        assertTrue(result.toLowerCase().contains("not found"),
                "Expected 'Showtime not found' style message, got: " + result);
        assertEquals(0, cart.getTicketCount());
    }

    @Test
    void bookTicket_underage_isRejected_seatStaysAvailable_cartUnchanged() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.bob); // 16 years old
        String result = f.engine.bookTicket(cart, 18, 0, 0); // Godfather (R)
        assertTrue(result.toLowerCase().contains("underage"),
                "Expected 'Underage ...' style message, got: " + result);
        assertTrue(f.hall1.getSeat(0, 0).isAvailable(),
                "Seat must NOT be booked when booking is rejected");
        assertEquals(0, cart.getTicketCount(),
                "Cart must not receive a ticket when booking is rejected");
    }

    @Test
    void bookTicket_sameSeatTwice_secondAttemptFails_cartCountStaysAtOne() {
        Fixture f = new Fixture();
        Cart cartA = new Cart(f.alice);
        Cart cartB = new Cart(f.carol);
        // First booking: legitimate (Toy Story is G-rated, all OK)
        assertEquals("OK", f.engine.bookTicket(cartA, 19, 1, 0));
        // Second booking by another customer for the SAME seat: must fail
        String r2 = f.engine.bookTicket(cartB, 19, 1, 0);
        assertTrue(r2.toLowerCase().contains("unavailable"),
                "Expected 'Seat unavailable' style message, got: " + r2);
        assertEquals(1, cartA.getTicketCount());
        assertEquals(0, cartB.getTicketCount());
    }

    @Test
    void bookTicket_premiumPlusPeak_priceIsBaseTimes_1_30_times_1_20() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        // Inception @ peak hall 2 row 0 (premium): 350 * 1.30 * 1.20
        assertEquals("OK", f.engine.bookTicket(cart, 17, 0, 0));
        Ticket t = cart.getTickets()[0];
        assertEquals(350.00 * 1.30 * 1.20, t.getPricePaid(), 1e-6);
    }

    @Test
    void bookTicket_offPeakNonPremium_priceEqualsBase() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.bob);
        // Toy Story @ 11:00 (off-peak), hall 1 row 1 (non-premium): 250 * 1 * 1
        assertEquals("OK", f.engine.bookTicket(cart, 19, 1, 0));
        assertEquals(250.00, cart.getTickets()[0].getPricePaid(), 1e-6);
    }

    @Test
    void addConcession_unknownCode_returnsErrorAndDoesNotChangeCart() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        String r = f.engine.addConcession(cart, "GHOST", 1);
        assertTrue(r.toLowerCase().contains("not found"));
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void addConcession_invalidQuantity_returnsErrorAndDoesNotChangeCart() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        String r = f.engine.addConcession(cart, "POP", 0);
        assertTrue(r.toLowerCase().contains("invalid"));
        assertEquals(0, cart.getItemCount());
    }

    // ============================================================
    // Part F - Checkout pipeline + receipt  [2 marks]
    // ============================================================

    @Test
    void checkout_singleBasicTicketOffPeakNonPremium_appliesOnlyTax() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.bob);
        f.engine.bookTicket(cart, 19, 1, 0); // Toy Story 250, off-peak, non-premium
        // pre = 250; tier(BASIC)=0; afterDisc = 250; tax = 12.50; total = 262.50
        assertEquals(262.50, f.engine.checkout(cart), 0.01);
    }

    @Test
    void checkout_silverSingleTicketOffPeakNonPremium_appliesTierDiscountAndTax() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.carol);
        f.engine.bookTicket(cart, 19, 1, 0);
        // pre = 250; tier(SILVER)=20; afterDisc=230; tax=11.50; total=241.50
        assertEquals(241.50, f.engine.checkout(cart), 0.01);
    }

    @Test
    void checkout_goldFourPremiumPeakTicketsWithComboPopAndSoda_appliesAllRules() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        // 4 premium peak tickets at 350 * 1.30 * 1.20 = 546 each
        f.engine.bookTicket(cart, 17, 0, 0);
        f.engine.bookTicket(cart, 17, 0, 1);
        f.engine.bookTicket(cart, 17, 0, 2);
        f.engine.bookTicket(cart, 17, 0, 3);
        f.engine.addConcession(cart, "POP",  1);
        f.engine.addConcession(cart, "SODA", 1);
        // tickets=2184, conc=340, combo=50 => pre=2474
        // group=247.40, tier(GOLD)=371.10 => after=1855.50
        // tax=92.775 => total round2 = 1948.28
        assertEquals(1948.28, f.engine.checkout(cart), 0.01);
    }

    @Test
    void checkout_goldThreeTickets_doesNotApplyGroupDiscount() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        f.engine.bookTicket(cart, 17, 0, 0);
        f.engine.bookTicket(cart, 17, 0, 1);
        f.engine.bookTicket(cart, 17, 0, 2);
        // pre = 1638; group = 0; tier(GOLD)=245.70; after=1392.30
        // tax=69.615; total round2 = 1461.92
        assertEquals(1461.92, f.engine.checkout(cart), 0.01);
    }

    @Test
    void checkout_combo_only_whenBothPopAndSodaPresent() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        f.engine.bookTicket(cart, 19, 1, 0);   // 250
        f.engine.addConcession(cart, "POP", 1); // 220, no SODA so no combo
        // pre = 470; tier(GOLD)=70.50; after=399.50; tax=19.975; total round2 = 419.48
        assertEquals(419.48, f.engine.checkout(cart), 0.01);
    }

    @Test
    void cart_independence_oneCartDoesNotAffectAnother() {
        Fixture f = new Fixture();
        Cart cartA = new Cart(f.alice);
        Cart cartB = new Cart(f.carol);
        f.engine.bookTicket(cartA, 17, 2, 0); // non-premium row 2 of hall 2
        f.engine.bookTicket(cartB, 19, 1, 0);
        assertEquals(1, cartA.getTicketCount());
        assertEquals(1, cartB.getTicketCount());
        // Different tiers and prices => totals must differ
        assertNotEquals(f.engine.checkout(cartA), f.engine.checkout(cartB), 0.01);
    }

    @Test
    void getReceipt_containsKeySubstrings() {
        Fixture f = new Fixture();
        Cart cart = new Cart(f.alice);
        f.engine.bookTicket(cart, 17, 0, 0);
        f.engine.addConcession(cart, "POP", 1);
        String r = f.engine.getReceipt(cart);
        assertTrue(r.contains("Receipt"),  "Receipt must contain 'Receipt'");
        assertTrue(r.contains("Alice"),    "Receipt must contain customer name");
        assertTrue(r.contains("BDT"),      "Receipt must contain 'BDT'");
        assertTrue(r.contains("Total"),    "Receipt must contain 'Total'");
        assertTrue(r.contains("Discount"), "Receipt must contain 'Discount'");
    }

    // ============================================================
    // End-to-end scenario via CSV resources
    // ============================================================

    @Test
    void endToEnd_csvLoad_andFullCheckout() {
        Movie[]        movies    = CsvLoader.loadMovies("movies.csv");
        Hall[]         halls     = CsvLoader.loadHalls("halls.csv");
        ShowtimeBoard  board     = CsvLoader.loadShowtimes("showtimes.csv", movies, halls);
        ConcessionMenu menu      = CsvLoader.loadConcessions("concessions.csv");
        Customer[]     customers = CsvLoader.loadCustomers("customers.csv");

        assertTrue(movies.length    >= 3, "At least 3 movies expected in movies.csv");
        assertTrue(halls.length     >= 2, "At least 2 halls expected in halls.csv");
        assertTrue(customers.length >= 3, "At least 3 customers expected in customers.csv");
        assertNotNull(board.findById(17),     "Showtime 17 expected in showtimes.csv");
        assertNotNull(menu.findByCode("POP"), "POP expected in concessions.csv");

        Customer alice = null;
        for (Customer c : customers) if (c.getId() == 1) { alice = c; break; }
        assertNotNull(alice, "Customer id 1 (Alice) expected in customers.csv");

        Cart cart = new Cart(alice);
        CheckoutEngine engine = new CheckoutEngine(board, menu);

        assertEquals("OK", engine.bookTicket(cart, 17, 0, 0));
        assertEquals("OK", engine.bookTicket(cart, 17, 0, 1));
        assertEquals("OK", engine.bookTicket(cart, 17, 0, 2));
        assertEquals("OK", engine.bookTicket(cart, 17, 0, 3));
        assertEquals("OK", engine.addConcession(cart, "POP",  1));
        assertEquals("OK", engine.addConcession(cart, "SODA", 1));

        assertEquals(1948.28, engine.checkout(cart), 0.01);
    }

    // ============================================================
    // Meta-check: all instance fields private  [1 mark]
    // ============================================================

    @Test
    void allClasses_haveOnlyPrivateInstanceFields() {
        Class<?>[] classes = {
            Movie.class, Seat.class, Hall.class, Showtime.class,
            Customer.class, Ticket.class, ConcessionItem.class, Cart.class,
            ShowtimeBoard.class, ConcessionMenu.class, CheckoutEngine.class
        };
        for (Class<?> cls : classes) {
            for (Field f : cls.getDeclaredFields()) {
                int mod = f.getModifiers();
                if (Modifier.isStatic(mod)) continue; // constants permitted
                assertTrue(Modifier.isPrivate(mod),
                        "Instance field " + cls.getSimpleName() + "." + f.getName()
                        + " must be private");
            }
        }
    }
}
