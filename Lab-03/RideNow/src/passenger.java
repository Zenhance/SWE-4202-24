public class passenger
{ 
    int id;
    String name;
    double rating;

public passenger (int id, String name, double rating)
    {
          this.id=id;
          this.name=name;
          this.rating=rating;
    }
    public passenger (int id, String name)
    { this.rating=5.0;
     this.id=id;
     this.name=name;
    }


    public int getId()
    {
        return id;
    }
    public String getName()
    {
     return name;
    }
    public double getRating ()
    {
        return rating;
    }
    public void updateRating (double newRating)
    {
     this.rating=newRating;
        
    }
    public String toString()
    {
      return String.format("Passenger[%d] %s (%.2f)", id, name, rating);
        
    }
}






}





