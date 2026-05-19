package model;

public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;


    public Movie(int id, String title, String rating, int
                 durationMin, double basePrice ){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getMinAge() {
         int age=0;
         if(rating=="G"){
             age=0;
         }else if(rating=="PG"){
             age=7;
         }else if(rating=="PG-13"){
             age=13;
         }else if(rating=="R"){
             age=18;
         }

         return age;

    }


    public String toString(){

        return title+ "("+rating+")"+ durationMin+"min" +"-"+"BDT"+ basePrice;

    }
}
