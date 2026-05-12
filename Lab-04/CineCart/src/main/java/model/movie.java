package model;

public class movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;
    public movie(int id,String title,String rating,int durationMin,double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }
    public int getid(){
        return id;
    }
}
