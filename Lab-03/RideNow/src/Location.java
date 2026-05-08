public class Location{
        private String lebel;
        double x;
        double y;

        public Location(String lebel,double x, double y){
            this.lebel ="lebel" ;
            this.x= x;
            this.y= y;
        }
        public Location(double x, double y){
            this.x=x;
            this.y=y;
            this.lebel="unknown";
        }

}



