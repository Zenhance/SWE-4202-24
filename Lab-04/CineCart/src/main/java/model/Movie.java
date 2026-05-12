package model;

public class Movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }

    public int getMinAge(){
        int age = 0;
        if(this.rating=="G"){
            age=0;
        }
        else if(this.rating=="PG"){
            age=7;
        }
        else if(this.rating=="PG-13"){
            age=13;
        }
        else if(this.rating=="R"){
            age=18;
        }
        return age;


    }
    public String toString(){
        return this.title+" ("+this.rating+") "+this.durationMin+"min - BDT "+String.format("%.2f", this.basePrice);
    }




}
