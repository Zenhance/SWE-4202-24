package kenakata.catalog;

public class Seller {
    private String name;
    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Seller name must not be null or blank");
        }
        this.name = name;
    }
}
