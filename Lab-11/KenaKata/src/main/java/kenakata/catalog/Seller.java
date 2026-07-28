package kenakata.catalog;

public class Seller {
    public String name;

    public Seller(String name){
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException("Name can't be Empty");
        this.name=name;
    }

    public String name(){
        return name;
    }
}
