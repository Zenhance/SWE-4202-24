/*
 * GridLedger — the billing engine, as the contractor delivered it.
 *
 * This ONE class does everything. It bills a connection correctly: run Main and
 * the numbers come out right to the paisa. That is the only good thing about it.
 *
 * Everything the connection could be — residential, commercial, industrial, or a
 * subsidised "lifeline" household — is crammed into a single String field
 * (customerType) plus a bolted-on boolean (subsidised). Every calculation below
 * therefore has to FIRST ask "what kind of customer is this?" before it can do
 * anything, so the same if/else ladder on customerType is copied into five
 * different methods, and they drift out of step whenever someone edits one and
 * forgets the others.
 *
 * You are replacing this. Keep the numbers; change the shape.
 */
public class Bill {

    // -- Everything is a public field. Anyone can reach in and scribble on it. --
    public String customerType;      // "RESIDENTIAL", "COMMERCIAL", "INDUSTRIAL"
    public int previousReading;
    public int currentReading;
    public boolean subsidised;       // a residential-only flag, bolted on later
    public double fuelPercent = 0.10; // country-wide fuel surcharge, % of energy charge
    public double taxPercent  = 0.05; // tax, % of (energy + fixed + fuel)

    public Bill() {
        // A half-built bill is a perfectly legal object: no customerType set,
        // every method below then silently returns 0. Nobody stops you.
    }

    public Bill(String customerType, int previousReading, int currentReading) {
        this.customerType = customerType;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    // Units consumed. Note: nothing checks that the meter didn't run backwards.
    // A currentReading below previousReading just bills a negative number of units.
    public int units() {
        return currentReading - previousReading;
    }

    public double energyCharge() {
        int units = currentReading - previousReading;
        if (customerType == null) {
            return 0;
        } else if (customerType.equals("RESIDENTIAL")) {
            double c = 0;
            if (units <= 50) {
                c += units * 4.0;
            } else {
                c += 50 * 4.0;
                if (units <= 200) {
                    c += (units - 50) * 7.0;
                } else {
                    c += 150 * 7.0;
                    c += (units - 200) * 11.0;
                }
            }
            if (subsidised) {
                c = c - (c * 0.30);   // lifeline rebate, tangled in the middle of the slab maths
            }
            return c;
        } else if (customerType.equals("COMMERCIAL")) {
            double c = 0;
            if (units <= 100) {
                c += units * 9.0;
            } else {
                c += 100 * 9.0;
                c += (units - 100) * 13.0;
            }
            return c;
        } else if (customerType.equals("INDUSTRIAL")) {
            return units * 15.0;      // flat rate for every unit
        }
        return 0;
    }

    public double fixedCharge() {
        // The SAME ladder again, just to return a flat number per category.
        if (customerType == null) {
            return 0;
        } else if (customerType.equals("RESIDENTIAL")) {
            return 100.0;
        } else if (customerType.equals("COMMERCIAL")) {
            return 500.0;
        } else if (customerType.equals("INDUSTRIAL")) {
            return 2000.0;
        }
        return 0;
    }

    public double fuelSurcharge() {
        // And AGAIN — even though the rule (a % of the energy charge) is the
        // same for everyone, the branch is here too because energyCharge() is
        // computed inside each arm the contractor never trusted to share.
        if (customerType == null) {
            return 0;
        } else if (customerType.equals("RESIDENTIAL")) {
            return energyCharge() * fuelPercent;
        } else if (customerType.equals("COMMERCIAL")) {
            return energyCharge() * fuelPercent;
        } else if (customerType.equals("INDUSTRIAL")) {
            return energyCharge() * fuelPercent;
        }
        return 0;
    }

    public double tax() {
        // Fourth copy of the ladder. Tax is a % of (energy + fixed + fuel) for
        // everybody, but of course it re-branches anyway.
        if (customerType == null) {
            return 0;
        } else if (customerType.equals("RESIDENTIAL")) {
            return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;
        } else if (customerType.equals("COMMERCIAL")) {
            return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;
        } else if (customerType.equals("INDUSTRIAL")) {
            return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxPercent;
        }
        return 0;
    }

    public double total() {
        // Fifth copy. Adds up the four parts — the same sentence for every
        // category, written out four times.
        if (customerType == null) {
            return 0;
        } else if (customerType.equals("RESIDENTIAL")) {
            return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
        } else if (customerType.equals("COMMERCIAL")) {
            return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
        } else if (customerType.equals("INDUSTRIAL")) {
            return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
        }
        return 0;
    }
}
