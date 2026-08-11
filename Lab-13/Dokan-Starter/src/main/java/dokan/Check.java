package dokan;

/**
 * A yes/no question you can ask about one value of type {@code T}.
 *
 * <p>One method, so you can write it as a lambda:
 * {@code Check<Book> cheap = book -> book.priceTaka() < 300;}
 */
public interface Check<T> {

    boolean passes(T value);
}
