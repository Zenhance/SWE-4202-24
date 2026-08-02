package kenakata.catalog;

public class Seller {
    private String name;
    public Seller(String name) {
        if(name == null||name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }
    public String name() {
        return name;
    }
    public String toString() {
        return name;
    }
}
