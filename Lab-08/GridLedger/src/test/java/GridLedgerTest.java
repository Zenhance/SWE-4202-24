import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * GridLedger — A National Electricity Billing Engine.
 *
 * This is the specification for the lab. Do NOT modify this file.
 *
 * It is also your guide to the exact method signatures: the way each class is
 * constructed here, and the type each value is used as, tells you what to
 * declare. The problem statement tells you how the classes relate; this file
 * tells you their shapes. Read both together.
 *
 * The contractor's engine (the single Bill class) will NOT compile against this
 * file — that is the first thing it is meant to show you. Your rebuilt classes
 * live in the default package, under src/main/java/.
 */
class GridLedgerTest {

    // --- The tariff the system must obey (identical to the contractor's) -----
    // Residential: rising three-band slab, boundaries at 50 and 200 units.
    private static final double RES_RATE_1 = 4.0;   // first 50 units
    private static final double RES_RATE_2 = 7.0;   // units 51..200
    private static final double RES_RATE_3 = 11.0;  // units above 200
    private static final double RES_FIXED  = 100.0;
    // Commercial: two-band slab, boundary at 100 units.
    private static final double COM_RATE_1 = 9.0;   // first 100 units
    private static final double COM_RATE_2 = 13.0;  // units above 100
    private static final double COM_FIXED  = 500.0;
    // Industrial: one flat rate for every unit.
    private static final double IND_RATE   = 15.0;
    private static final double IND_FIXED  = 2000.0;
    // Country-wide add-ons.
    private static final double FUEL_DEFAULT    = 0.10; // fuel surcharge = this % of the energy charge
    private static final double TAX_RATE        = 0.05; // tax = this % of (energy + fixed + fuel)
    private static final double LIFELINE_REBATE = 0.30; // taken off the residential energy charge

    private static final double EPS = 1e-6;

    // --- The slab rules, written out once so the tests can check against them -
    private double residentialEnergy(int units) {
        if (units <= 50)  return units * RES_RATE_1;
        if (units <= 200) return 50 * RES_RATE_1 + (units - 50) * RES_RATE_2;
        return 50 * RES_RATE_1 + 150 * RES_RATE_2 + (units - 200) * RES_RATE_3;
    }
    private double commercialEnergy(int units) {
        if (units <= 100) return units * COM_RATE_1;
        return 100 * COM_RATE_1 + (units - 100) * COM_RATE_2;
    }
    private double industrialEnergy(int units) {
        return units * IND_RATE;
    }
    private double fuel(double energy, double pct) { return energy * pct; }
    private double tax(double energy, double fixed, double fuelAmt) {
        return (energy + fixed + fuelAmt) * TAX_RATE;
    }

    // =====================================================================
    @Nested
    @DisplayName("The meter guards itself")
    class MeterGuards {

        @Test
        @DisplayName("units consumed are worked out from the two readings")
        void unitsFromReadings() {
            Meter m = new Meter(1000, 1320);
            assertEquals(320, m.getUnitsConsumed(), "units = closing - opening");
        }

        @Test
        @DisplayName("a negative reading is refused")
        void negativeReadingRejected() {
            assertThrows(IllegalArgumentException.class, () -> new Meter(-1, 100),
                    "a negative opening reading is impossible");
        }

        @Test
        @DisplayName("a meter that ran backwards is refused")
        void backwardsMeterRejected() {
            assertThrows(IllegalArgumentException.class, () -> new Meter(500, 400),
                    "a closing reading below the opening reading is a broken record, not a cheap month");
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Each category charges energy in its own voice")
    class EnergyVoice {

        @Test
        @DisplayName("the same units produce three different energy charges")
        void sameUnitsDifferByCategory() {
            // One meter reading, 150 units, given to one connection of each category.
            Connection res = new ResidentialConnection(new Meter(0, 150));
            Connection com = new CommercialConnection(new Meter(0, 150));
            Connection ind = new IndustrialConnection(new Meter(0, 150));

            assertEquals(residentialEnergy(150), res.energyCharge(), EPS, "residential slab");
            assertEquals(commercialEnergy(150), com.energyCharge(), EPS, "commercial slab");
            assertEquals(industrialEnergy(150), ind.energyCharge(), EPS, "industrial flat rate");

            assertNotEquals(res.energyCharge(), com.energyCharge(), "categories must not charge alike");
            assertNotEquals(com.energyCharge(), ind.energyCharge(), "categories must not charge alike");
            assertNotEquals(res.energyCharge(), ind.energyCharge(), "categories must not charge alike");
        }

        @Test
        @DisplayName("the residential three-band slab adds up band by band")
        void residentialSlabIsBanded() {
            // 320 units: 50*4 + 150*7 + 120*11 = 200 + 1050 + 1320 = 2570.
            Connection res = new ResidentialConnection(new Meter(1000, 1320));
            assertEquals(2570.0, res.energyCharge(), EPS);
        }

        @Test
        @DisplayName("the commercial two-band slab adds up band by band")
        void commercialSlabIsBanded() {
            // 250 units: 100*9 + 150*13 = 900 + 1950 = 2850.
            Connection com = new CommercialConnection(new Meter(0, 250));
            assertEquals(2850.0, com.energyCharge(), EPS);
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Every bill is the same four parts, added up the same way")
    class CommonParts {

        private void assertPartsAddUp(Connection c, double expectedEnergy, double expectedFixed) {
            double energy = c.energyCharge();
            assertEquals(expectedEnergy, energy, EPS, "energy charge");
            assertEquals(expectedFixed, c.fixedCharge(), EPS, "fixed charge");

            double expectedFuel = fuel(energy, FUEL_DEFAULT);
            assertEquals(expectedFuel, c.fuelSurcharge(), EPS, "fuel surcharge is a % of the energy charge");

            double expectedTax = tax(energy, expectedFixed, expectedFuel);
            assertEquals(expectedTax, c.tax(), EPS, "tax is a % of (energy + fixed + fuel)");

            assertEquals(energy + expectedFixed + expectedFuel + expectedTax, c.total(), EPS,
                    "total is the four parts added up");
        }

        @Test
        @DisplayName("residential bill parts add up")
        void residentialAddsUp() {
            assertPartsAddUp(new ResidentialConnection(new Meter(1000, 1320)), 2570.0, RES_FIXED);
        }

        @Test
        @DisplayName("commercial bill parts add up")
        void commercialAddsUp() {
            assertPartsAddUp(new CommercialConnection(new Meter(0, 250)), 2850.0, COM_FIXED);
        }

        @Test
        @DisplayName("industrial bill parts add up")
        void industrialAddsUp() {
            assertPartsAddUp(new IndustrialConnection(new Meter(5000, 6000)), 15000.0, IND_FIXED);
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("The lifeline connection is built ON the residential one")
    class LifelineBuiltOnResidential {

        @Test
        @DisplayName("a lifeline connection IS a residential connection")
        void lifelineIsAResidential() {
            Connection life;
            life = new LifelineConnection(new Meter(0, 100));
            assertTrue(life instanceof ResidentialConnection,
                    "a lifeline household is a residential connection with a rebate, not a separate category");
        }

        @Test
        @DisplayName("its energy charge is the residential charge, less the rebate")
        void energyIsResidentialLessRebate() {
            Meter a = new Meter(200, 520);   // 320 units
            Meter b = new Meter(200, 520);   // an identical reading for the plain residential

            Connection life = new LifelineConnection(a);
            Connection res  = new ResidentialConnection(b);

            assertEquals(res.energyCharge() * (1.0 - LIFELINE_REBATE), life.energyCharge(), EPS,
                    "the lifeline charge must be derived FROM the residential charge, not re-typed");
            // 2570 * 0.70 = 1799.0
            assertEquals(1799.0, life.energyCharge(), EPS);
        }

        @Test
        @DisplayName("everything else about it matches a residential connection")
        void sharesTheResidentialCommonParts() {
            Connection life = new LifelineConnection(new Meter(200, 520));
            Connection res  = new ResidentialConnection(new Meter(200, 520));
            assertEquals(res.fixedCharge(), life.fixedCharge(), EPS, "same fixed charge as residential");
            // Full bill: 1799 energy, 100 fixed, 179.9 fuel, 103.945 tax => 2182.845
            assertEquals(2182.845, life.total(), EPS);
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("One billing run holds every category side by side")
    class MixedRun {

        @Test
        @DisplayName("a mixed batch reports its size and a grand total equal to the parts")
        void grandTotalEqualsSumOfParts() {
            Connection res  = new ResidentialConnection(new Meter(1000, 1320));
            Connection com  = new CommercialConnection(new Meter(0, 250));
            Connection ind  = new IndustrialConnection(new Meter(5000, 6000));
            Connection life = new LifelineConnection(new Meter(200, 520));

            // The four categories must fit together in one container, under one type.
            Connection[] batch = { res, com, ind, life };

            BillingRun run = new BillingRun();
            for (Connection c : batch) {
                run.register(c);
            }

            assertEquals(4, run.size(), "four connections were registered");
            assertEquals(res.total() + com.total() + ind.total() + life.total(),
                    run.grandTotal(), EPS,
                    "the grand total must equal each connection's own total, added up");
        }

        @Test
        @DisplayName("executing the run bills everything in one sweep, in registration order")
        void executeBillsAllInOrder() {
            Connection res = new ResidentialConnection(new Meter(1000, 1320));
            Connection com = new CommercialConnection(new Meter(0, 250));
            Connection ind = new IndustrialConnection(new Meter(5000, 6000));

            BillingRun run = new BillingRun();
            run.register(res);
            run.register(com);
            run.register(ind);

            List<Invoice> invoices = run.execute();

            assertEquals(3, invoices.size(), "one invoice per connection");
            assertEquals(res.total(), invoices.get(0).getTotal(), EPS, "first invoice is the residential total");
            assertEquals(com.total(), invoices.get(1).getTotal(), EPS, "second invoice is the commercial total");
            assertEquals(ind.total(), invoices.get(2).getTotal(), EPS, "third invoice is the industrial total");
        }

        @Test
        @DisplayName("one variable can stand in for any category")
        void oneSlotManyForms() {
            BillingRun run = new BillingRun();

            Connection slot = new ResidentialConnection(new Meter(1000, 1320));
            run.register(slot);
            slot = new CommercialConnection(new Meter(0, 250));
            run.register(slot);
            slot = new IndustrialConnection(new Meter(5000, 6000));
            run.register(slot);
            slot = new LifelineConnection(new Meter(200, 520));
            run.register(slot);

            assertEquals(4, run.size(), "the same variable, reassigned to each category, registers all four");
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Register plainly, or register with the month's fuel percentage")
    class RegisterOverload {

        @Test
        @DisplayName("registering with a fuel percentage applies it to the bill")
        void registerWithFuelPercent() {
            Connection res = new ResidentialConnection(new Meter(1000, 1320)); // energy 2570
            double energy = res.energyCharge();

            BillingRun run = new BillingRun();
            run.register(res, 0.20); // a heavier fuel month, 20% instead of the default 10%

            double expectedFuel = fuel(energy, 0.20);
            double expectedTax  = tax(energy, RES_FIXED, expectedFuel);
            double expectedTotal = energy + RES_FIXED + expectedFuel + expectedTax;

            assertEquals(expectedTotal, res.total(), EPS,
                    "the fuel percentage handed in at registration must drive the bill");
            assertEquals(1, run.size());
        }

        @Test
        @DisplayName("registering plainly uses the default fuel percentage")
        void plainRegisterUsesDefault() {
            Connection res = new ResidentialConnection(new Meter(1000, 1320));

            BillingRun run = new BillingRun();
            run.register(res);

            assertEquals(3073.35, res.total(), EPS, "the default 10% fuel month gives the standard bill");
            assertEquals(1, run.size());
        }
    }

    // =====================================================================
    // These last checks cannot be judged from a number. They read your design
    // directly, and they are exactly the properties the contractor's version
    // could not offer.
    // =====================================================================
    @Nested
    @DisplayName("The design is sound, not just the numbers")
    class DesignRules {

        private final Class<?>[] connectionFamily = {
                Connection.class,
                ResidentialConnection.class,
                CommercialConnection.class,
                IndustrialConnection.class,
                LifelineConnection.class,
        };

        @Test
        @DisplayName("a category-less connection cannot be constructed")
        void baseConnectionIsAbstract() {
            assertTrue(Modifier.isAbstract(Connection.class.getModifiers()),
                    "Connection must be abstract: there is no such thing as a plain, category-less connection");
        }

        @Test
        @DisplayName("every category is a kind of the one common connection type")
        void categoriesShareOneCommonType() {
            assertTrue(Connection.class.isAssignableFrom(ResidentialConnection.class), "residential is-a connection");
            assertTrue(Connection.class.isAssignableFrom(CommercialConnection.class),  "commercial is-a connection");
            assertTrue(Connection.class.isAssignableFrom(IndustrialConnection.class),  "industrial is-a connection");
            assertTrue(ResidentialConnection.class.isAssignableFrom(LifelineConnection.class),
                    "lifeline is-a residential connection (built on it, not beside it)");
        }

        @Test
        @DisplayName("no connection exposes its state as a public field")
        void connectionStateIsSealed() {
            for (Class<?> type : connectionFamily) {
                for (Field f : type.getFields()) { // getFields() = public fields, including inherited
                    if (!Modifier.isStatic(f.getModifiers())) {
                        fail(type.getSimpleName() + " leaks a public field '" + f.getName()
                                + "'. A connection's state must not be reachable and rewritable from outside.");
                    }
                }
            }
        }

        @Test
        @DisplayName("the meter does not expose its readings as public fields")
        void meterStateIsSealed() {
            for (Field f : Meter.class.getFields()) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    fail("Meter leaks a public field '" + f.getName()
                            + "'. Readings must be sealed behind the meter.");
                }
            }
        }
    }
}
