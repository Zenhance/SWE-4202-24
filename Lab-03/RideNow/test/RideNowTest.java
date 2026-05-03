import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Lab 3 – City Navigation System
 * JUnit 5 test suite (JDK 17)
 * <p>
 * DO NOT MODIFY THIS FILE.
 * <p>
 * Run with your IDE's JUnit runner, or:
 *   mvn test
 *   gradle test
 * <p>
 * Every test method documents WHY it exists so that you understand
 * what your implementation must do, not just whether it compiles.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RideNowTest {

    // =========================================================
    //  PART A  –  Location
    // =========================================================

    @Nested
    @DisplayName("Part A – Location")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class LocationTests {

        @Test
        @Order(1)
        @DisplayName("getX and getY return the values given to the constructor")
        void coordinatesAreStoredCorrectly() {
            Location loc = new Location(3.5, 7.2);
            assertEquals(3.5, loc.getX(), 1e-9,
                    "getX() should return the x value passed to the constructor");
            assertEquals(7.2, loc.getY(), 1e-9,
                    "getY() should return the y value passed to the constructor");
        }

        @Test
        @Order(2)
        @DisplayName("distanceTo returns 0 for the same point")
        void distanceToSelf() {
            Location loc = new Location(4.0, 4.0);
            assertEquals(0.0, loc.distanceTo(loc), 1e-9,
                    "Distance from a point to itself must be 0");
        }

        @Test
        @Order(3)
        @DisplayName("distanceTo computes Euclidean distance correctly")
        void distanceToKnownPoints() {
            Location a = new Location(0.0, 0.0);
            Location b = new Location(3.0, 4.0);
            // 3-4-5 right triangle → distance = 5
            assertEquals(5.0, a.distanceTo(b), 1e-9,
                    "Distance from (0,0) to (3,4) should be 5.0 (3-4-5 triangle)");
        }

        @Test
        @Order(4)
        @DisplayName("distanceTo is symmetric")
        void distanceIsSymmetric() {
            Location a = new Location(1.0, 2.0);
            Location b = new Location(4.0, 6.0);
            assertEquals(a.distanceTo(b), b.distanceTo(a), 1e-9,
                    "distanceTo must be symmetric: a.distanceTo(b) == b.distanceTo(a)");
        }
    }

    // =========================================================
    //  PART A  –  BoundingBox
    // =========================================================

    @Nested
    @DisplayName("Part A – BoundingBox")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class BoundingBoxTests {

        @Test
        @Order(1)
        @DisplayName("contains returns true for a point strictly inside the box")
        void containsInteriorPoint() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            assertTrue(box.contains(new Location(5, 5)),
                    "Point (5,5) is strictly inside [(0,0)-(10,10)]");
        }

        @Test
        @Order(2)
        @DisplayName("contains returns true for a point on the boundary edge")
        void containsBoundaryPoint() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            assertTrue(box.contains(new Location(0, 5)),
                    "Point (0,5) is on the left edge and should be considered inside");
            assertTrue(box.contains(new Location(10, 10)),
                    "Point (10,10) is on the corner and should be considered inside");
        }

        @Test
        @Order(3)
        @DisplayName("contains returns false for a point outside the box")
        void containsExteriorPoint() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            assertFalse(box.contains(new Location(12, 12)),
                    "Point (12,12) is outside [(0,0)-(10,10)]");
            assertFalse(box.contains(new Location(-1, 5)),
                    "Point (-1,5) is to the left of the box");
        }

        @Test
        @Order(4)
        @DisplayName("area returns correct value")
        void areaCalculation() {
            BoundingBox box = new BoundingBox(0, 0, 4, 5);
            assertEquals(20.0, box.area(), 1e-9,
                    "Area of [(0,0)-(4,5)] should be 4 * 5 = 20");
        }

        @Test
        @Order(5)
        @DisplayName("expand returns the smallest enclosing box")
        void expandProducesCorrectMBR() {
            BoundingBox a = new BoundingBox(0, 0, 3, 3);
            BoundingBox b = new BoundingBox(2, 2, 6, 5);
            BoundingBox combined = a.expand(b);

            // We cannot access private fields, so we verify via contains + area
            assertTrue(combined.contains(new Location(0, 0)),
                    "Expanded box must contain the min corner of a");
            assertTrue(combined.contains(new Location(6, 5)),
                    "Expanded box must contain the max corner of b");
            assertEquals(30.0, combined.area(), 1e-9,
                    "Expanded box [(0,0)-(6,5)] should have area 6 * 5 = 30");
        }

        @Test
        @Order(6)
        @DisplayName("overlapsCircle returns true when circle centre is inside the box")
        void circleInsideBox() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            assertTrue(box.overlapsCircle(new Location(5, 5), 1.0),
                    "Circle entirely inside the box must overlap it");
        }

        @Test
        @Order(7)
        @DisplayName("overlapsCircle returns true when circle reaches across the boundary")
        void circleOverlapsEdge() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            // Center at (11,5) with radius 2 → closest box point is (10,5),
            // distance = 1 < 2, so they overlap
            assertTrue(box.overlapsCircle(new Location(11, 5), 2.0),
                    "Circle centred at (11,5) r=2 should reach into [(0,0)-(10,10)]");
        }

        @Test
        @Order(8)
        @DisplayName("overlapsCircle returns true for circle just touching the corner")
        void circleJustTouchesCorner() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            // Closest point on box to (11,11) is (10,10), distance = sqrt(2) ≈ 1.414
            double touchRadius = Math.sqrt(2.0);
            assertTrue(box.overlapsCircle(new Location(11, 11), touchRadius + 1e-9),
                    "Circle just touching the corner (radius = sqrt(2)) must overlap");
        }

        @Test
        @Order(9)
        @DisplayName("overlapsCircle returns false when circle is clearly outside")
        void circleOutside() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            assertFalse(box.overlapsCircle(new Location(20, 20), 1.0),
                    "Circle at (20,20) r=1 is far outside [(0,0)-(10,10)]");
        }

        @Test
        @Order(10)
        @DisplayName("overlapsCircle returns false for circle not quite reaching the edge")
        void circleJustMissesEdge() {
            BoundingBox box = new BoundingBox(0, 0, 10, 10);
            // Centre at (13,5), closest box point is (10,5), distance = 3
            assertFalse(box.overlapsCircle(new Location(13, 5), 2.9),
                    "Circle centred at (13,5) r=2.9 does not reach [(0,0)-(10,10)]");
        }
    }

    // =========================================================
    //  PART B  –  Driver
    // =========================================================

    @Nested
    @DisplayName("Part B – Driver")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DriverTests {

        @Test
        @Order(1)
        @DisplayName("getId and getName return constructor values")
        void attributesAreStoredCorrectly() {
            Driver d = new Driver(7, "Alice", new Location(2.0, 3.0));
            assertEquals(7, d.getId(),   "getId() must return the id passed to the constructor");
            assertEquals("Alice", d.getName(), "getName() must return the name");
        }

        @Test
        @Order(2)
        @DisplayName("getPosition returns the initial location")
        void initialPositionIsCorrect() {
            Location pos = new Location(2.0, 3.0);
            Driver d = new Driver(1, "Bob", pos);
            assertEquals(2.0, d.getPosition().getX(), 1e-9);
            assertEquals(3.0, d.getPosition().getY(), 1e-9);
        }

        @Test
        @Order(3)
        @DisplayName("moveTo updates the driver's position")
        void moveToupdatesPosition() {
            Driver d = new Driver(1, "Carol", new Location(0, 0));
            d.moveTo(new Location(5.0, 6.0));
            assertEquals(5.0, d.getPosition().getX(), 1e-9,
                    "After moveTo(5,6) getPosition().getX() must return 5");
            assertEquals(6.0, d.getPosition().getY(), 1e-9,
                    "After moveTo(5,6) getPosition().getY() must return 6");
        }

        @Test
        @Order(4)
        @DisplayName("isWithinRadius returns true when driver is inside the radius")
        void driverInsideRadius() {
            // Alice at (2,3), passenger at (3,3), radius 1.5 → distance = 1
            Driver alice = new Driver(1, "Alice", new Location(2.0, 3.0));
            assertTrue(alice.isWithinRadius(new Location(3.0, 3.0), 1.5),
                    "Alice at (2,3) is 1 km from (3,3), within radius 1.5");
        }

        @Test
        @Order(5)
        @DisplayName("isWithinRadius returns false when driver is outside the radius")
        void driverOutsideRadius() {
            // Bob at (9,9), passenger at (3,3), radius 3 → distance ≈ 8.49
            Driver bob = new Driver(2, "Bob", new Location(9.0, 9.0));
            assertFalse(bob.isWithinRadius(new Location(3.0, 3.0), 3.0),
                    "Bob at (9,9) is ~8.49 km from (3,3), outside radius 3");
        }

        @Test
        @Order(6)
        @DisplayName("isWithinRadius returns true exactly on the boundary")
        void driverExactlyOnBoundary() {
            // Driver at (3,4) from origin → distance exactly 5
            Driver d = new Driver(3, "Edge", new Location(3.0, 4.0));
            assertTrue(d.isWithinRadius(new Location(0.0, 0.0), 5.0),
                    "Driver exactly at distance 5 with radius 5 should return true");
        }

        @Test
        @Order(7)
        @DisplayName("moveTo followed by isWithinRadius reflects the new position")
        void moveToAffectsRadiusCheck() {
            Driver d = new Driver(4, "Dave", new Location(9.0, 9.0));
            assertFalse(d.isWithinRadius(new Location(3.0, 3.0), 3.0),
                    "Dave starts far away");
            d.moveTo(new Location(3.0, 4.0));
            assertTrue(d.isWithinRadius(new Location(3.0, 3.0), 1.5),
                    "After moving Dave to (3,4), he is 1 km from (3,3)");
        }
    }

    // =========================================================
    //  PART C  –  Zone
    // =========================================================

    @Nested
    @DisplayName("Part C – Zone")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ZoneTests {

        // ------ helpers to build the canonical city tree ------
        private Zone buildCityTree() {
            // Leaf zones
            Zone nw = new Zone(new BoundingBox(0, 4, 6, 8), true);
            Zone ne = new Zone(new BoundingBox(6, 4, 12, 8), true);
            Zone sw = new Zone(new BoundingBox(0, 0, 6, 4), true);
            Zone se = new Zone(new BoundingBox(6, 0, 12, 4), true);

            nw.addDriver(new Driver(1, "DriverA", new Location(1.5, 6.5)));
            nw.addDriver(new Driver(2, "DriverB", new Location(3.2, 5.8)));
            nw.addDriver(new Driver(3, "DriverC", new Location(2.0, 4.9)));

            ne.addDriver(new Driver(4, "DriverD", new Location(7.5, 6.8)));
            ne.addDriver(new Driver(5, "DriverE", new Location(9.0, 5.5)));

            sw.addDriver(new Driver(6, "DriverF", new Location(2.0, 2.8)));
            sw.addDriver(new Driver(7, "DriverG", new Location(4.0, 1.5)));

            se.addDriver(new Driver(8, "DriverH", new Location(8.0, 2.5)));
            se.addDriver(new Driver(9, "DriverI", new Location(10.5, 1.2)));

            // Internal zones
            Zone north = new Zone(new BoundingBox(0, 4, 12, 8), false);
            north.addChild(nw);
            north.addChild(ne);

            Zone south = new Zone(new BoundingBox(0, 0, 12, 4), false);
            south.addChild(sw);
            south.addChild(se);

            // City root
            Zone city = new Zone(new BoundingBox(0, 0, 12, 8), false);
            city.addChild(north);
            city.addChild(south);

            return city;
        }

        // ------ leaf zone behaviour ------

        @Test
        @Order(1)
        @DisplayName("A new leaf zone is not full")
        void newLeafZoneIsNotFull() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 5, 5), true);
            assertFalse(leaf.isFull(),
                    "A freshly created leaf zone with no drivers must not be full");
        }

        @Test
        @Order(2)
        @DisplayName("Leaf zone becomes full after 4 drivers are added")
        void leafZoneBecomesFullAt4() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 5, 5), true);
            for (int i = 1; i <= 4; i++) {
                leaf.addDriver(new Driver(i, "D" + i, new Location(i, i)));
            }
            assertTrue(leaf.isFull(),
                    "Leaf zone must report full after exactly 4 drivers");
        }

        @Test
        @Order(3)
        @DisplayName("addDriver beyond capacity does not crash and does not increase count beyond 4")
        void addDriverBeyondCapacityIsSafe() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 5, 5), true);
            for (int i = 1; i <= 5; i++) {
                leaf.addDriver(new Driver(i, "D" + i, new Location(i, i)));
            }
            // Zone must still be full (not some corrupt state)
            assertTrue(leaf.isFull(),
                    "Zone must still be full and not crash after over-capacity add");
        }

        @Test
        @Order(4)
        @DisplayName("addDriver on an internal zone does nothing harmful")
        void addDriverOnInternalZoneIsIgnored() {
            Zone internal = new Zone(new BoundingBox(0, 0, 10, 10), false);
            assertDoesNotThrow(
                    () -> internal.addDriver(new Driver(1, "X", new Location(1, 1))),
                    "Calling addDriver on an internal zone must not throw an exception"
            );
        }

        // ------ internal zone behaviour ------

        @Test
        @Order(5)
        @DisplayName("Internal zone becomes full after 4 children are added")
        void internalZoneBecomesFullAt4Children() {
            Zone internal = new Zone(new BoundingBox(0, 0, 20, 20), false);
            for (int i = 0; i < 4; i++) {
                internal.addChild(new Zone(new BoundingBox(i, i, i+1, i+1), true));
            }
            assertTrue(internal.isFull(),
                    "Internal zone must report full after exactly 4 child zones");
        }

        @Test
        @Order(6)
        @DisplayName("addChild on a leaf zone does nothing harmful")
        void addChildOnLeafZoneIsIgnored() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 5, 5), true);
            assertDoesNotThrow(
                    () -> leaf.addChild(new Zone(new BoundingBox(1, 1, 2, 2), true)),
                    "Calling addChild on a leaf zone must not throw an exception"
            );
        }

        // ------ findNearbyDrivers: zone skipping ------

        @Test
        @Order(7)
        @DisplayName("findNearbyDrivers returns empty when the search circle misses the zone entirely")
        void searchMissesZone() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 5, 5), true);
            leaf.addDriver(new Driver(1, "Alice", new Location(2, 2)));

            Driver[] results = new Driver[10];
            int[]    count   = {0};
            // Passenger at (20,20), radius 1 — completely outside (0,0)-(5,5)
            leaf.findNearbyDrivers(new Location(20, 20), 1.0, results, count);

            assertEquals(0, count[0],
                    "No drivers should be found when the circle does not overlap the zone");
        }

        @Test
        @Order(8)
        @DisplayName("findNearbyDrivers returns only drivers inside the radius for a leaf zone")
        void leafZoneReturnsCorrectDrivers() {
            Zone leaf = new Zone(new BoundingBox(0, 0, 6, 4), true);
            Driver f = new Driver(6, "DriverF", new Location(2.0, 2.8));
            Driver g = new Driver(7, "DriverG", new Location(4.0, 1.5));
            leaf.addDriver(f);
            leaf.addDriver(g);

            Driver[] results = new Driver[10];
            int[]    count   = {0};
            // Passenger at (3.8, 3.0), radius 1.6
            // Distance to F ≈ 1.84 → outside; Distance to G ≈ 1.95 → outside
            // Use a larger radius that captures F but not G
            // Distance F: sqrt((3.8-2)^2 + (3.0-2.8)^2) = sqrt(3.24+0.04) ≈ 1.812
            // Distance G: sqrt((3.8-4.0)^2 + (3.0-1.5)^2) = sqrt(0.04+2.25) ≈ 1.513
            leaf.findNearbyDrivers(new Location(3.8, 3.0), 1.6, results, count);

            assertEquals(1, count[0],
                    "Only DriverG (distance ≈ 1.51) should be within radius 1.6");
            assertEquals("DriverG", results[0].getName(),
                    "The found driver should be DriverG");
        }

        @Test
        @Order(9)
        @DisplayName("findNearbyDrivers on the full city tree returns the correct driver")
        void fullCityTreeSearch() {
            Zone city = buildCityTree();

            Driver[] results = new Driver[20];
            int[]    count   = {0};
            city.findNearbyDrivers(new Location(3.8, 3.0), 1.6, results, count);

            assertEquals(1, count[0],
                    "Exactly one driver (DriverG) should be within 1.6 km of (3.8,3.0)");
            assertEquals("DriverG", results[0].getName(),
                    "That driver must be DriverG");
        }

        @Test
        @Order(10)
        @DisplayName("findNearbyDrivers on the full city tree returns multiple drivers for a wide radius")
        void fullCityTreeWideSearch() {
            Zone city = buildCityTree();

            Driver[] results = new Driver[20];
            int[]    count   = {0};
            // Centre at (5,5), radius 4 — should reach into SW and NW zones
            // SW drivers: F(2.0,2.8) dist≈3.20, G(4.0,1.5) dist≈3.53
            // NW drivers: A(1.5,6.5) dist≈4.30, B(3.2,5.8) dist≈1.97, C(2.0,4.9) dist≈3.15
            // Within radius 4: F, G, B, C
            city.findNearbyDrivers(new Location(5, 5), 4.0, results, count);

            assertTrue(count[0] >= 2,
                    "At least DriverB and DriverF should be within radius 4 of (5,5)");

            // Verify that DriverD (NE, at (7.5,6.8), dist≈3.13) IS found
            boolean foundB = false, foundF = false;
            for (int i = 0; i < count[0]; i++) {
                if ("DriverB".equals(results[i].getName())) foundB = true;
                if ("DriverF".equals(results[i].getName())) foundF = true;
            }
            assertTrue(foundB, "DriverB at (3.2,5.8) is ≈1.97 km from (5,5) — must be found");
            assertTrue(foundF, "DriverF at (2.0,2.8) is ≈3.20 km from (5,5) — must be found");
        }

        @Test
        @Order(11)
        @DisplayName("findNearbyDrivers returns nothing for a passenger outside the city")
        void passengerOutsideCity() {
            Zone city = buildCityTree();

            Driver[] results = new Driver[20];
            int[]    count   = {0};
            city.findNearbyDrivers(new Location(50, 50), 2.0, results, count);

            assertEquals(0, count[0],
                    "A passenger far outside the city boundary must find no drivers");
        }

        @Test
        @Order(12)
        @DisplayName("getBoundary returns the BoundingBox given to the constructor")
        void getBoundaryReturnsCorrectBox() {
            BoundingBox box  = new BoundingBox(1, 2, 7, 9);
            Zone        zone = new Zone(box, true);

            BoundingBox returned = zone.getBoundary();

            // Verify the same extent via area and a known contained point
            assertEquals(box.area(), returned.area(), 1e-9,
                    "getBoundary() must return a box with the same area as the one given");
            assertTrue(returned.contains(new Location(4, 5)),
                    "getBoundary() must return a box that still contains interior points");
        }
    }

    // =========================================================
    //  PART D  –  Dispatcher
    // =========================================================

    @Nested
    @DisplayName("Part D – Dispatcher")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DispatcherTests {

        private Dispatcher buildDispatcher() {
            Dispatcher dispatcher = new Dispatcher(new BoundingBox(0, 0, 12, 8));
            Zone city = dispatcher.getCityZone();

            Zone nw = new Zone(new BoundingBox(0, 4, 6,  8), true);
            Zone ne = new Zone(new BoundingBox(6, 4, 12, 8), true);
            Zone sw = new Zone(new BoundingBox(0, 0, 6,  4), true);
            Zone se = new Zone(new BoundingBox(6, 0, 12, 4), true);

            nw.addDriver(new Driver(1, "DriverA", new Location(1.5, 6.5)));
            nw.addDriver(new Driver(2, "DriverB", new Location(3.2, 5.8)));
            nw.addDriver(new Driver(3, "DriverC", new Location(2.0, 4.9)));
            ne.addDriver(new Driver(4, "DriverD", new Location(7.5, 6.8)));
            ne.addDriver(new Driver(5, "DriverE", new Location(9.0, 5.5)));
            sw.addDriver(new Driver(6, "DriverF", new Location(2.0, 2.8)));
            sw.addDriver(new Driver(7, "DriverG", new Location(4.0, 1.5)));
            se.addDriver(new Driver(8, "DriverH", new Location(8.0, 2.5)));
            se.addDriver(new Driver(9, "DriverI", new Location(10.5, 1.2)));

            Zone north = new Zone(new BoundingBox(0, 4, 12, 8), false);
            north.addChild(nw);
            north.addChild(ne);

            Zone south = new Zone(new BoundingBox(0, 0, 12, 4), false);
            south.addChild(sw);
            south.addChild(se);

            city.addChild(north);
            city.addChild(south);

            return dispatcher;
        }

        @Test
        @Order(1)
        @DisplayName("getCityZone returns an internal zone with the correct boundary")
        void getCityZoneHasCorrectBoundary() {
            Dispatcher d = new Dispatcher(new BoundingBox(0, 0, 12, 8));
            Zone city = d.getCityZone();

            assertNotNull(city, "getCityZone() must not return null");
            assertEquals(96.0, city.getBoundary().area(), 1e-9,
                    "City zone boundary area must be 12 * 8 = 96");
        }

        @Test
        @Order(2)
        @DisplayName("requestRide returns the one nearby driver")
        void requestRideReturnsOneDriver() {
            Dispatcher dispatcher = buildDispatcher();
            Driver[] nearby = dispatcher.requestRide(new Location(3.8, 3.0), 1.6);

            assertEquals(1, nearby.length,
                    "Exactly one driver should be within 1.6 km of (3.8,3.0)");
            assertEquals("DriverG", nearby[0].getName(),
                    "That driver must be DriverG");
        }

        @Test
        @Order(3)
        @DisplayName("requestRide returns an empty array when no driver is nearby")
        void requestRideReturnsEmptyWhenNoMatch() {
            Dispatcher dispatcher = buildDispatcher();
            Driver[] nearby = dispatcher.requestRide(new Location(50, 50), 1.0);

            assertNotNull(nearby,
                    "requestRide must never return null — return an empty array instead");
            assertEquals(0, nearby.length,
                    "No drivers should be near (50,50) with radius 1");
        }

        @Test
        @Order(4)
        @DisplayName("requestRide returns multiple drivers for a wide search")
        void requestRideReturnsMultipleDrivers() {
            Dispatcher dispatcher = buildDispatcher();
            Driver[] nearby = dispatcher.requestRide(new Location(5, 5), 4.0);

            assertTrue(nearby.length >= 2,
                    "At least DriverB and DriverF must be within radius 4 of (5,5)");

            boolean foundB = false, foundF = false;
            for (Driver d : nearby) {
                if ("DriverB".equals(d.getName())) foundB = true;
                if ("DriverF".equals(d.getName())) foundF = true;
            }
            assertTrue(foundB, "DriverB must be in the results");
            assertTrue(foundF, "DriverF must be in the results");
        }

        @Test
        @Order(5)
        @DisplayName("requestRide result array contains no null entries")
        void requestRideArrayHasNoNulls() {
            Dispatcher dispatcher = buildDispatcher();
            Driver[] nearby = dispatcher.requestRide(new Location(5, 5), 4.0);

            for (int i = 0; i < nearby.length; i++) {
                assertNotNull(nearby[i],
                        "Entry at index " + i + " in the result array must not be null");
            }
        }
    }
}