package kenakata.catalog;

public final class Seller {
        private final String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name=name;
    }
    public String Name() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
