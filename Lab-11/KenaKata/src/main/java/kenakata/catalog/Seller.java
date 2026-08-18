package kenakata.catalog;

public class Seller {
    private final String name;
    public Seller(String name) {
       if(name==null){
           throw new IllegalArgumentException("name is null");
       }
       this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }

}
