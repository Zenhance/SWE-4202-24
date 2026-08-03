package kenakata.catalog;

import java.util.Objects;

public class Seller {
    private final String name;

    public Seller(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Invalid seller name");
        this.name = name;
    }

    public String name() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
