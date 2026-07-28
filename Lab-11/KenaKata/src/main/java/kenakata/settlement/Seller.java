package kenakata.settlement;

public class Seller {
    private final String name;
    public Seller(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Seller name cannot be empty");
        }
    }
}
