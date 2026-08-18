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

}