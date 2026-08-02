package kenakata.catalog;

public final class Seller {

    private final String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("");
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
