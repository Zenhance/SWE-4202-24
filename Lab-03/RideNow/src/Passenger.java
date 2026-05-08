 class Passenger {
     private final int id;
     private final String name;
     private double rating;

     public Passenger(int id, String name, double rating) {
         this.id = id;
         this.name = name;
         this.rating = rating;
     }

     public Passenger(int id, String name) {
         this.id = id;
         this.name = name;
         this.rating = 5.0;
     }

     public int getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public double getRating() {
         return rating;
     }

     public void updateRating(double newRating) {
         this.rating = newRating;
     }

     public String toString() {
         return "passenger[+id]" + "+name";
     }

 }
