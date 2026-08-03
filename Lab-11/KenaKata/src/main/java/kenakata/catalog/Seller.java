package kenakata.catalog;

public class Seller {
    private String name;

    public Seller(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Seller name cannot be null or empty");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return name.equals(seller.name);
    }
}
