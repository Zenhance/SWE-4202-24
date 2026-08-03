import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import model.Cart;
import model.ConcessionItem;
import model.Customer;
import model.Hall;
import model.Movie;
import model.Seat;
import model.Showtime;
import model.Ticket;

/**
 * CineCartEncapsulationTest.java
 * <p>
 * Addendum test suite for OOP Lab 4 -- Part G: Self-Defending Classes.
 * Run alongside the original CineCartTest with:
 *     ./gradlew test
 * <p>
 * DO NOT MODIFY THIS FILE.
 * <p>
 * A correct Part G submission passes BOTH this file and the original
 * CineCartTest in full; passing one but failing the other scores zero
 * on the bonus.
 */
@Disabled
public class CineCartEncapsulationTest {

    // ============================================================
    // G.1  Cart returns defensive snapshots
    // ============================================================

    @Test
    void cart_getTickets_lengthEqualsTicketCount() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        Showtime st = sampleShowtime();
        cart.addTicket(new Ticket(st, 0, 0, 100.00));
        cart.addTicket(new Ticket(st, 0, 1, 100.00));

        Ticket[] snapshot = cart.getTickets();
        assertEquals(2, snapshot.length,
                "getTickets() must return an array sized to ticketCount, not MAX_TICKETS");
    }

    @Test
    void cart_getTickets_isDefensiveCopy_writingToItDoesNotChangeCart() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        Showtime st = sampleShowtime();
        cart.addTicket(new Ticket(st, 0, 0, 100.00));
        cart.addTicket(new Ticket(st, 0, 1, 200.00));

        Ticket[] snapshot = cart.getTickets();
        snapshot[0] = null; // an outsider tries to corrupt the cart

        Ticket[] after = cart.getTickets();
        assertEquals(2, after.length, "cart must still contain two tickets");
        assertNotNull(after[0], "writing null into the snapshot must not affect the cart");
        assertNotNull(after[1]);
        assertEquals(300.00, cart.sumTicketsPaid(), 1e-9,
                "the sum of ticket prices must be unaffected by writes to the snapshot");
    }

    @Test
    void cart_getItems_lengthEqualsItemCount() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        cart.addItem(new ConcessionItem("POP",  "Popcorn", 220.00), 1);
        cart.addItem(new ConcessionItem("SODA", "Soda",    120.00), 2);
        assertEquals(2, cart.getItems().length);
        assertEquals(2, cart.getQtys().length);
    }

    @Test
    void cart_getItems_isDefensiveCopy() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        cart.addItem(new ConcessionItem("POP",  "Popcorn", 220.00), 1);
        cart.addItem(new ConcessionItem("SODA", "Soda",    120.00), 1);

        ConcessionItem[] snapshot = cart.getItems();
        snapshot[0] = null;

        ConcessionItem[] after = cart.getItems();
        assertNotNull(after[0], "writing null into the snapshot must not affect the cart");
        assertTrue(cart.hasItem("POP"),
                "the cart must still contain POP after an outsider tried to null it");
    }

    @Test
    void cart_getQtys_isDefensiveCopy_negativeWriteDoesNotPoisonSums() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        cart.addItem(new ConcessionItem("POP",  "Popcorn", 220.00), 1);
        cart.addItem(new ConcessionItem("SODA", "Soda",    120.00), 2);
        double expected = 220.00 * 1 + 120.00 * 2;

        int[] snapshot = cart.getQtys();
        snapshot[0] = -999; // an outsider tries to inject a negative quantity

        assertEquals(expected, cart.sumConcessionsRaw(), 1e-9,
                "concession sum must be unaffected by writes to the qtys snapshot");
    }

    // ============================================================
    // G.2  Identity fields must be declared final
    // ============================================================

    @Test
    void identityFields_areMarkedFinal() {
        assertFieldsAreFinal(Movie.class,
                "id", "title", "rating", "durationMin", "basePrice");
        assertFieldsAreFinal(Seat.class,
                "row", "col", "isPremium");
        assertFieldsAreFinal(Hall.class,
                "id", "rows", "cols", "grid");
        assertFieldsAreFinal(Showtime.class,
                "id", "movie", "hall", "startHour", "dateTag");
        assertFieldsAreFinal(Customer.class,
                "id", "name", "age", "loyaltyTier");
        assertFieldsAreFinal(Ticket.class,
                "showtime", "row", "col", "pricePaid");
        assertFieldsAreFinal(ConcessionItem.class,
                "code", "name", "unitPrice");
        assertFieldsAreFinal(Cart.class,
                "owner", "tickets", "items", "qtys");
    }

    @Test
    void mutableCounters_areNotFinal() {
        // The two counters in Cart, and isBooked in Seat, MUST remain non-final
        // because they change after construction. This guards against students
        // adding "final" everywhere mechanically and breaking the model.
        assertFieldIsNotFinal(Seat.class, "isBooked");
        assertFieldIsNotFinal(Cart.class, "ticketCount");
        assertFieldIsNotFinal(Cart.class, "itemCount");
    }

    // ============================================================
    // G.3  Failing mutators return false; succeeding ones return true
    // ============================================================

    @Test
    void seat_book_returnsTrueOnFreshSeat_andFalseIfAlreadyBooked() {
        Seat s = new Seat(0, 0, false);
        assertTrue(s.book(),
                "book() on a fresh seat must return true");
        assertFalse(s.book(),
                "book() on an already-booked seat must return false");
        assertTrue(s.isBooked(),
                "an already-booked seat must remain booked after a redundant book() call");
    }

    @Test
    void cart_addTicket_returnsTrue_whenAccepted_andFalse_whenFull() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        Showtime st = sampleShowtime();
        for (int i = 0; i < Cart.MAX_TICKETS; i++) {
            assertTrue(cart.addTicket(new Ticket(st, 0, 0, 100.00)),
                    "addTicket #" + (i + 1) + " must return true while cart has room");
        }
        assertFalse(cart.addTicket(new Ticket(st, 0, 0, 100.00)),
                "addTicket beyond MAX_TICKETS must return false");
        assertEquals(Cart.MAX_TICKETS, cart.ticketCount(),
                "ticketCount must not exceed MAX_TICKETS even after a rejected call");
    }

    @Test
    void cart_addItem_returnsTrue_whenAccepted_andFalse_whenQuantityNonPositive() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        ConcessionItem pop = new ConcessionItem("POP", "Popcorn", 220.00);
        assertTrue(cart.addItem(pop, 2),
                "addItem with positive qty must return true");

        assertFalse(cart.addItem(pop, 0),
                "addItem with qty == 0 must return false");
        assertFalse(cart.addItem(pop, -3),
                "addItem with negative qty must return false");

        assertEquals(1, cart.getItemCount(),
                "rejected addItem calls must not change itemCount");
    }

    @Test
    void cart_addItem_returnsFalse_whenCartFull() {
        Cart cart = freshCartFor(new Customer(1, "Alice", 28, "GOLD"));
        ConcessionItem pop = new ConcessionItem("POP", "Popcorn", 220.00);
        for (int i = 0; i < Cart.MAX_ITEMS; i++) {
            assertTrue(cart.addItem(pop, 1),
                    "addItem #" + (i + 1) + " must return true while cart has room");
        }
        assertFalse(cart.addItem(pop, 1),
                "addItem beyond MAX_ITEMS must return false");
        assertEquals(Cart.MAX_ITEMS, cart.getItemCount(),
                "itemCount must not exceed MAX_ITEMS even after a rejected call");
    }

    // ============================================================
    // Helpers
    // ============================================================

    private static Cart freshCartFor(Customer c) {
        return new Cart(c);
    }

    private static Showtime sampleShowtime() {
        Movie m = new Movie(1, "Sample", "G", 90, 100.0);
        Hall h  = new Hall(1, 5, 8, 1);
        return new Showtime(1, m, h, 14, "Sat");
    }

    private static void assertFieldsAreFinal(Class<?> cls, String... names) {
        for (String name : names) {
            Field f;
            try {
                f = cls.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                fail("Class " + cls.getSimpleName()
                        + " is missing the expected field '" + name + "'");
                return;
            }
            assertTrue(Modifier.isFinal(f.getModifiers()),
                    "Field " + cls.getSimpleName() + "." + name
                            + " must be declared final");
        }
    }

    private static void assertFieldIsNotFinal(Class<?> cls, String name) {
        try {
            Field f = cls.getDeclaredField(name);
            assertFalse(Modifier.isFinal(f.getModifiers()),
                    "Field " + cls.getSimpleName() + "." + name
                            + " changes after construction and must NOT be final");
        } catch (NoSuchFieldException e) {
            fail("Class " + cls.getSimpleName()
                    + " is missing the expected field '" + name + "'");
        }
    }
}
