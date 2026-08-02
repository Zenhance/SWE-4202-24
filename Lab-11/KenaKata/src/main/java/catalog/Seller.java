package kenakata.catalog;

/** An independent seller listing items on the KenaKata marketplace. */
public final class Seller {

    private final String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("seller name must not be blank");
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
