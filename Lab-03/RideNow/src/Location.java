public class Location{
        private String label;
        private double x, y;

        public Location(String label, double x, double y){
            this.label = label;
            this.x = x;
            this.y = y;
        }

        public Location(double x, double y){
            this.label = "UNKNOWN";
            this.x = x;
            this.y = y;
    }
    }