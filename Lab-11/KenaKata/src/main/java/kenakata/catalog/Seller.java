package kenakata.catalog;

public record Seller(String name) {
    public Seller {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Seller name must not be null or blank");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}