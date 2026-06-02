package model;

public class Movie {


    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;


public Movie(int id,String title,String rating,int durationMin,double basePrice){

    this.id=id;
    this.title=title;
    this.rating=rating;
    this.durationMin=durationMin;
    this.basePrice=basePrice;
}

public int getId(){
    return id;
}

public String getTitle(){
    return title;
}

public String getRating(){
    return rating;
}

public int getDurationMin(){
    return durationMin;
}

public double getBasePrice(){
    return basePrice;
}

public int getMinAge(){
    int ret=0;
    if (rating=="G"){
        ret = 0;
    }

    if (rating=="PG"){
        ret = 7;
    }

    if (rating=="PG-13"){
        ret = 13;
    }

    if (rating=="R"){
        ret = 18;
      }

    return ret;
}

public String toString(){

    String res;

    res=String.format("%s (%s) %d min - BDT %.2f",title,rating,durationMin,basePrice);

    return res;

}


}
