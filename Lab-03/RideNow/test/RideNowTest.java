import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * RideNowTest.java
 * <p>
 * Test suite for OOP Lab 3 – RideNow Trip Manager.
 * DO NOT MODIFY THIS FILE.
 * <p>
 * Run with:  javac *.java && java -cp .:junit-platform-console-standalone.jar
 *            org.junit.platform.console.ConsoleLauncher --select-class=RideNowTest
 * Or via your IDE's built-in JUnit support.
 */
public class RideNowTest {

    // ─────────────────────────────────────────────────────────────────────────
    // Part A – Location
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    void locationFullConstructorStoresAllFields() {
        Location loc = new Location("Airport", 3.0, 7.5);
        assertEquals("Airport", loc.getLabel());
        assertEquals(3.0,  loc.getX(), 1e-9);
        assertEquals(7.5,  loc.getY(), 1e-9);
    }

    @Test
    void locationConvenienceConstructorDefaultsLabel() {
        Location loc = new Location(1.0, 2.0);
        assertEquals("Unknown", loc.getLabel());
        assertEquals(1.0, loc.getX(), 1e-9);
        assertEquals(2.0, loc.getY(), 1e-9);
    }

    @Test
    void locationDistanceToSelf() {
        Location loc = new Location("Home", 5.0, 5.0);
        assertEquals(0.0, loc.distanceTo(loc), 1e-9);
    }

    @Test
    void locationDistanceKnownValues() {
        // (0,0) to (3,4) = 5.0 exactly
        Location origin = new Location("O", 0.0, 0.0);
        Location far    = new Location("F", 3.0, 4.0);
        assertEquals(5.0, origin.distanceTo(far), 1e-9);
    }

    @Test
    void locationDistanceIsSymmetric() {
        Location a = new Location("A", 2.0, 3.0);
        Location b = new Location("B", 5.0, 7.0);
        assertEquals(a.distanceTo(b), b.distanceTo(a), 1e-9);
    }

    @Test
    void locationToString() {
        Location loc = new Location("Airport", 3.0, 7.5);
        assertEquals("Airport (3.00, 7.50)", loc.toString());
    }

    @Test
    void locationToStringConvenienceConstructor() {
        Location loc = new Location(1.5, 2.0);
        assertEquals("Unknown (1.50, 2.00)", loc.toString());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Part B – Passenger
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    void passengerFullConstructor() {
        Passenger p = new Passenger(42, "Alice", 4.8);
        assertEquals(42,    p.getId());
        assertEquals("Alice", p.getName());
        assertEquals(4.8,   p.getRating(), 1e-9);
    }

    @Test
    void passengerDefaultRatingIsFive() {
        Passenger p = new Passenger(1, "Bob");
        assertEquals(5.0, p.getRating(), 1e-9);
    }

    @Test
    void passengerUpdateRating() {
        Passenger p = new Passenger(1, "Carol");
        p.updateRating(3.5);
        assertEquals(3.5, p.getRating(), 1e-9);
    }

    @Test
    void passengerUpdateRatingMultipleTimes() {
        Passenger p = new Passenger(2, "Dave", 4.0);
        p.updateRating(3.0);
        p.updateRating(2.5);
        assertEquals(2.5, p.getRating(), 1e-9);
    }

    @Test
    void passengerToString() {
        Passenger p = new Passenger(42, "Alice", 4.8);
        assertEquals("Passenger[42] Alice (4.80)", p.toString());
    }

    @Test
    void passengerToStringDefaultRating() {
        Passenger p = new Passenger(7, "Eve");
        assertEquals("Passenger[7] Eve (5.00)", p.toString());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Part C – Driver
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    void driverThreeArgConstructorAvailableByDefault() {
        Driver d = new Driver(7, "Bob", "DHA-1234");
        assertEquals(7,          d.getId());
        assertEquals("Bob",      d.getName());
        assertEquals("DHA-1234", d.getLicencePlate());
        assertTrue(d.isAvailable(), "New driver should be available by default");
    }

    @Test
    void driverFourArgConstructorSetsAvailability() {
        Driver d = new Driver(8, "Frank", "CTG-5678", false);
        assertFalse(d.isAvailable());
    }

    @Test
    void driverSetAvailable() {
        Driver d = new Driver(9, "Grace", "SYL-9999");
        d.setAvailable(false);
        assertFalse(d.isAvailable());
        d.setAvailable(true);
        assertTrue(d.isAvailable());
    }

    @Test
    void driverToStringAvailable() {
        Driver d = new Driver(7, "Bob", "DHA-1234");
        assertEquals("Driver[7] Bob (DHA-1234) [AVAILABLE]", d.toString());
    }

    @Test
    void driverToStringBusy() {
        Driver d = new Driver(7, "Bob", "DHA-1234", false);
        assertEquals("Driver[7] Bob (DHA-1234) [BUSY]", d.toString());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Part D – Trip  (composition, delegation, fare logic)
    // ─────────────────────────────────────────────────────────────────────────

    private Trip makeTrip() {
        Passenger p    = new Passenger(42, "Alice", 4.8);
        Driver    d    = new Driver(7, "Bob", "DHA-1234");
        Location  from = new Location("Airport",    3.0, 7.5);
        Location  to   = new Location("University", 8.0, 4.0);
        return new Trip(p, d, from, to, 50.0);
    }

    @Test
    void tripGettersReturnCorrectObjects() {
        Passenger p    = new Passenger(42, "Alice", 4.8);
        Driver    d    = new Driver(7, "Bob", "DHA-1234");
        Location  from = new Location("Airport",    3.0, 7.5);
        Location  to   = new Location("University", 8.0, 4.0);
        Trip trip = new Trip(p, d, from, to, 50.0);

        assertSame(p,    trip.getPassenger());
        assertSame(d,    trip.getDriver());
        assertSame(from, trip.getFrom());
        assertSame(to,   trip.getTo());
        assertEquals(50.0, trip.getBaseFare(), 1e-9);
    }

    @Test
    void tripStartsNotCompleted() {
        Trip trip = makeTrip();
        assertFalse(trip.isCompleted());
    }

    @Test
    void tripConstructorMarkesDriverBusy() {
        Trip trip = makeTrip();
        assertFalse(trip.getDriver().isAvailable(),
                "Driver should be marked BUSY when trip is created");
    }

    @Test
    void tripGetDistance() {
        // (3,7.5) to (8,4) => sqrt(25 + 12.25) = sqrt(37.25) ≈ 6.1033
        Trip trip = makeTrip();
        assertEquals(Math.sqrt(37.25), trip.getDistance(), 1e-6);
    }

    @Test
    void tripCalculateFare() {
        // baseFare=50, distance=sqrt(37.25), rate=15
        Trip   trip     = makeTrip();
        double expected = 50.0 + 15.0 * Math.sqrt(37.25);
        assertEquals(expected, trip.calculateFare(), 1e-6);
    }

    @Test
    void tripCalculateFareZeroDistance() {
        Passenger p    = new Passenger(1, "Zara");
        Driver    d    = new Driver(2, "Hasan", "XX-0000");
        Location  same = new Location("Mall", 4.0, 4.0);
        Trip trip = new Trip(p, d, same, same, 30.0);
        assertEquals(30.0, trip.calculateFare(), 1e-9);
    }

    @Test
    void tripCompleteTripMarksCompletedAndFreesDriver() {
        Trip trip = makeTrip();
        trip.completeTrip();
        assertTrue(trip.isCompleted());
        assertTrue(trip.getDriver().isAvailable(),
                "Driver should be AVAILABLE after trip is completed");
    }

    @Test
    void tripGetSummaryInProgress() {
        Trip trip = makeTrip();
        String summary = trip.getSummary();

        assertTrue(summary.contains("Trip Summary"),         "Missing 'Trip Summary'");
        assertTrue(summary.contains("Alice"),                "Missing passenger name");
        assertTrue(summary.contains("Bob"),                  "Missing driver name");
        assertTrue(summary.contains("DHA-1234"),             "Missing licence plate");
        assertTrue(summary.contains("Airport"),              "Missing from label");
        assertTrue(summary.contains("University"),           "Missing to label");
        assertTrue(summary.contains("IN PROGRESS"),         "Status should be IN PROGRESS");
        // Fare and distance appear as formatted numbers
        assertTrue(summary.contains("6.10") || summary.contains("6.1"),
                "Distance not formatted correctly in summary");
    }

    @Test
    void tripGetSummaryCompleted() {
        Trip trip = makeTrip();
        trip.completeTrip();
        String summary = trip.getSummary();
        assertTrue(summary.contains("COMPLETED"), "Status should be COMPLETED");
    }

    @Test
    void tripGetSummaryFareLinePresent() {
        Trip   trip     = makeTrip();
        String summary  = trip.getSummary();
        // Fare = 50 + 15*sqrt(37.25) ≈ 141.55 – just check "BDT" appears
        assertTrue(summary.contains("BDT"), "Fare line should start with BDT");
    }

    @Test
    void tripMultipleTripsIndependent() {
        Passenger p1 = new Passenger(1, "Ann");
        Passenger p2 = new Passenger(2, "Ben");
        Driver    d1 = new Driver(10, "Carl", "A-111");
        Driver    d2 = new Driver(11, "Dana", "B-222");
        Location  l1 = new Location("Start", 0, 0);
        Location  l2 = new Location("End",   3, 4);

        Trip t1 = new Trip(p1, d1, l1, l2, 100.0);
        Trip t2 = new Trip(p2, d2, l2, l1, 200.0);

        t1.completeTrip();
        assertTrue(t1.isCompleted());
        assertFalse(t2.isCompleted());
        assertTrue(d1.isAvailable());
        assertFalse(d2.isAvailable());
    }
}