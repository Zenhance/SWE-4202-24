package kenakata.catalog;

public class Seller {
    private final String name;

    public Seller(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Seller name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}