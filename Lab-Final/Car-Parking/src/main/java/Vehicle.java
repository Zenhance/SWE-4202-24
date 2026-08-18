public abstract class Vehicle {
        private final String plate;
        private final String scheme;
        private int hours;

        public Vehicle(String plate, String scheme) {
            this.plate = plate;
            this.scheme = scheme;
            this.hours = 0;
        }

        public String getPlate() {
            return plate;
        }

        public int getHours() {
            return hours;
        }

        public void addHours(int hours) {
            this.hours += hours;
        }
    public abstract SlotType[] getAcceptedSlots();
    public int applyDiscount(int bill) {
        return switch (scheme) {
            case "NONE" -> bill;
            case "STUDENT" -> bill - ((20 * bill) / 100);
            case "WEEKEND" -> Math.max(0, bill - 10);
            default -> bill;
        };
    }
}