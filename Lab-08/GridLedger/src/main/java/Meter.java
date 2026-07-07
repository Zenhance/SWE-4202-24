public class Meter {
        private final int openingReading;
        private final int closingReading;

        public Meter(int openingReading, int closingReading) {
            if (openingReading < 0 || closingReading < 0) {
                throw new IllegalArgumentException("Meter readings cannot be negative.");
            }



            if (closingReading < openingReading) {
                throw new IllegalArgumentException("Closing reading cannot be below opening reading.");
            }

            this.openingReading = openingReading;
            this.closingReading = closingReading;
        }

        public int openingReading() {
            return openingReading;
        }

        public int closingReading() {
            return closingReading;
        }

        public int unitsConsumed() {
            return closingReading - openingReading;
        }

    public int getUnitsConsumed() {
        return 0;
    }


}
