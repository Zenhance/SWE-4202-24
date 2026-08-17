package shop;

import java.util.Objects;
import dokan.Item;

/** A prepaid SIM. Given to you complete; do not change it. */
public final class SimCard implements Item {

    private final String name;
    private final int priceTaka;
    private final String operator;

    public SimCard(String name, int priceTaka, String operator) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(operator, "operator");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (priceTaka < 0) {
            throw new IllegalArgumentException("priceTaka must not be negative");
        }
        this.name = name;
        this.priceTaka = priceTaka;
        this.operator = operator;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int priceTaka() {
        return priceTaka;
    }

    public String operator() {
        return operator;
    }

    @Override
    public String toString() {
        return name + " (" + priceTaka + " Tk)";
    }
}
