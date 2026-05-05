public class location{
        private String label;
        private double x, y;

        public location(String label, double x, double y){
            this.label = label;
            this.x = x;
            this.y = y;
        }

        public location(double x, double y){
            this.label = "UNKNOWN";
            this.x = x;
            this.y = y;
    }
    }