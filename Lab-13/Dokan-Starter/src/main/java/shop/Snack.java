package shop;

import java.util.Objects;
import dokan.Item;

/** A packet of something to eat. Given to you complete; do not change it. */
public final class Snack implements Item {

    private final String name;
    private final int priceTaka;
    private final int grams;

    public Snack(String name, int priceTaka, int grams) {
        Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (priceTaka < 0) {
            throw new IllegalArgumentException("priceTaka must not be negative");
        }
        if (grams < 1) {
            throw new IllegalArgumentException("grams must be at least 1");
        }
        this.name = name;
        this.priceTaka = priceTaka;
        this.grams = grams;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int priceTaka() {
        return priceTaka;
    }

    public int grams() {
        return grams;
    }

    @Override
    public String toString() {
        return name + " (" + priceTaka + " Tk)";
    }
}
