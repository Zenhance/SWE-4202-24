public class Passenger {
    private int id;
    private String name;
    private double rating;
    public Passenger(int id,String name,double rating){
        this.id=id;
        this.name=name;
        this.rating=rating;
    }
  public Passenger(int id,String name){
        this.id=id;
        this.name=name;
        this.rating=5.0;
  }
  public void getId(){
        return Id;
  }
  public void getName(){
        return Name;
  }
  public void getRating(){
        return Rating;
  }
  void updatedRating(){
        Rating=this.rating;
    }

}
