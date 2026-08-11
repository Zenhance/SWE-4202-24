/*
 * A month's billing run, done the contractor's way: a plain array of Bill and a
 * loop. Run it with `./gradlew run` (or `java Main`). It prints an invoice for
 * every connection and the grand total the company will collect, and it checks
 * those numbers against hand-computed expected values so you can SEE that the
 * engine is already numerically correct.
 *
 * Your job is not to change these numbers. It is to change the shape of the code
 * that produces them, so that the acceptance test (GridLedgerTest) passes.
 */
public class Main {

    public static void main(String[] args) {

        // A mixed batch: a household, a shop, a factory, and a subsidised household.
        Bill residential = new Bill("RESIDENTIAL", 1000, 1320); // 320 units
        Bill commercial  = new Bill("COMMERCIAL",  0,    250);  // 250 units
        Bill industrial  = new Bill("INDUSTRIAL",  5000, 6000); // 1000 units

        Bill lifeline    = new Bill("RESIDENTIAL", 200, 520);   // 320 units...
        lifeline.subsidised = true;                             // ...at the lifeline rebate

        Bill[] batch = { residential, commercial, industrial, lifeline };
        String[] names = { "Residential", "Commercial", "Industrial", "Lifeline  " };

        System.out.println("GridLedger — monthly billing run");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-12s %8s %10s %8s %8s %8s %11s%n",
                "Category", "units", "energy", "fixed", "fuel", "tax", "total");

        double grandTotal = 0.0;
        for (int i = 0; i < batch.length; i++) {
            Bill b = batch[i];
            System.out.printf("%-12s %8d %10.2f %8.2f %8.2f %8.2f %11.2f%n",
                    names[i], b.units(), b.energyCharge(), b.fixedCharge(),
                    b.fuelSurcharge(), b.tax(), b.total());
            grandTotal += b.total();
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("Grand total: %.3f%n%n", grandTotal);

        // --- Prove the engine is already correct (numbers must never change). ---
        check("residential energy", residential.energyCharge(), 2570.000);
        check("residential total",  residential.total(),        3073.350);
        check("commercial total",   commercial.total(),         3816.750);
        check("industrial total",   industrial.total(),         19425.000);
        check("lifeline energy",    lifeline.energyCharge(),    1799.000); // 2570 less 30%
        check("lifeline total",     lifeline.total(),           2182.845);
        check("grand total",        grandTotal,                 28497.945);
        System.out.println("All business numbers verified. The engine works — now fix its shape.");
    }

    private static void check(String label, double actual, double expected) {
        if (Math.abs(actual - expected) > 1e-6) {
            throw new AssertionError(
                    "MISMATCH in " + label + ": expected " + expected + " but got " + actual);
        }
    }
}
