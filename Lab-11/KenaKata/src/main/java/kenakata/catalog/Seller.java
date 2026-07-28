package kenakata.catalog;

public class Seller{

    private final String name;
    public Seller(String name){
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Seller name can't be null or blank");
        }
        this.name = name;
        }
}
