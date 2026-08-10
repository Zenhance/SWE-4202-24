package dokan;

/**
 * Anything Rahim can put on a shelf and sell.
 *
 * <p>This interface is not generic itself. Its job is to be a <em>bound</em>: when a
 * class says {@code <T extends Item>}, it is promising the compiler that whatever
 * {@code T} turns out to be, it at least has a name and a price.
 */
public interface Item {

    String name();

    int priceTaka();
}
