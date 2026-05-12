package model;

public class Movie{

    private int id;
    private String title;
    private String rating;
    private  int durationMin;
    private double basePrice;

    public Movie(int id, String title,String rating ,int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){

        return this.title;
    }

    public String getRating(){

        return this.rating;
    }
    public int getDurationMin()
    {
        return this.durationMin;
    }
    public double getBasePrice(){
             return  this.basePrice;
    }
    public int getMinage(){
         if(rating=="G"){
             return 0;
         }
        if(rating=="PG"){
            return 7;
        }
        if(rating=="PG-13"){
            return 13;
        }
        else return 18;
    }
    @Override
    public String toString(){
        return title+"("+rating+"-"+" "+this.durationMin+"min"+"-BDT"+String.format("%.2f",this.basePrice);
    }



}
