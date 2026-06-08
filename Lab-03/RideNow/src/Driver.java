public class Driver {

        private int id;
        private String name;
        private String licencePlate;
        private boolean isAvailable;

        public Driver(int id ,String name, String licencePlate,boolean isAvailble){
            this.id=id;
            this.name=name;
            this.licencePlate=licencePlate;
            this.isAvailable=isAvailable;

        }
        public Driver(int id,String name,String licencePlate){
            this(id, name, licencePlate, true );

        }
        public int getId() {
            return id;
        }
        public String getNAme(){
            return name;

        }
        public String getLicencePlate(){
            return licencePlate;
        }
        public void setAvailable(boolean isAvailable){
            this.isAvailable=isAvailable;
        }
        @Override
        public String toString() {
            String status = isAvailable ? "AVAILABLE" : "BUSY";
            return String.format("Driver[%d] %s (%s) [%s]", id, name, licencePlate, status);
        }
    }


