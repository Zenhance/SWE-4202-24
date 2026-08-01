package kenakata.catalog;

public class Seller {
    private final String name;

    public Seller(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid seller");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
