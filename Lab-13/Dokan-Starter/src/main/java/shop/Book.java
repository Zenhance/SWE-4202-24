package shop;

import java.util.Objects;
import dokan.Item;

/** A book on Rahim's shelf. Given to you complete; do not change it. */
public final class Book implements Item {

    private final String name;
    private final int priceTaka;
    private final String author;

    public Book(String name, int priceTaka, String author) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(author, "author");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (priceTaka < 0) {
            throw new IllegalArgumentException("priceTaka must not be negative");
        }
        this.name = name;
        this.priceTaka = priceTaka;
        this.author = author;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int priceTaka() {
        return priceTaka;
    }

    public String author() {
        return author;
    }

    @Override
    public String toString() {
        return name + " (" + priceTaka + " Tk)";
    }
}
