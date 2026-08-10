package main.java.kenakata.catalog;

public class Seller {
    private String name;
    public Seller(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Seller Name must be Valid");
        }
        this.name=name;
    }
}
