package kenakata.catalog;

public class Seller {
    private final String name;

    public Seller(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Seller name invalid.");
        }
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