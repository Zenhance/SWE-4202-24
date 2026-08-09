package kenakata.catalog;

public class Seller {
    private final String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

