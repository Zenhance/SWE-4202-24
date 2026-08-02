public class Location {
        private String label;
        private double x;
        private double y;

        public Location(String label, double x, double y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }
        public Location(double x,double y){
            this("Ünknown",x,y);


        }
        public String getLabel(){
            return label;
        }
        public double getX(){
            return x;

        }

        public double getY(){
            return y;

        }

        public double distance(Location other){
            double newx=this.x-other.x;
            double newy=this.y-other.y;
            return Math.sqrt(newx*newx+ newy*nw                                                                                                                                                                                                                                                                                                                                                                                                                               )
        }
}
