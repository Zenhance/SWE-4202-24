package kenakata.catalog;

public class Seller {
    private String name;
    public Seller(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid seller name");}
        this.name = name;
    }
    public String name() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}