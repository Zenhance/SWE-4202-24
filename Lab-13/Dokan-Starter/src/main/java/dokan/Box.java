package dokan;

/**
 * TODO (step 1). A small box that holds either one value of type {@code T}, or
 * nothing at all.
 *
 * <p>This is what the shop uses instead of returning {@code null}. "The shelf is
 * empty, so there is no cheapest item" is an ordinary answer, not a crash — and an
 * empty {@code Box<Book>} is still visibly a box of books, which a bare {@code null}
 * never is. That is the intern's PAIN 3, fixed.
 *
 * <p>Hints:
 * <ul>
 *   <li>One field is enough: the value, which is {@code null} exactly when the box is
 *       empty.</li>
 *   <li>Make the constructor {@code private} and build boxes through {@code of} and
 *       {@code empty}, so nobody outside can make a box that is neither.</li>
 *   <li>Notice {@code static <T> Box<T> of(T value)} — the {@code <T>} sits on the
 *       method because a static method cannot use the class's type parameter.</li>
 *   <li>{@code toString} must print exactly {@code Box(empty)} or {@code Box(value)};
 *       the test cases compare that text.</li>
 * </ul>
 */
public final class Box<T> {

    /** A box holding {@code value}. Refuse null: a full box holding nothing is a lie. */
    public static <T> Box<T> of(T value) {
        throw new UnsupportedOperationException("TODO: Box.of");
    }

    /** An empty box. */
    public static <T> Box<T> empty() {
        throw new UnsupportedOperationException("TODO: Box.empty");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: Box.isEmpty");
    }

    /** The value inside. Opening an empty box is a programming mistake, so throw. */
    public T get() {
        throw new UnsupportedOperationException("TODO: Box.get");
    }

    /** The value inside, or {@code fallback} if the box is empty. */
    public T orElse(T fallback) {
        throw new UnsupportedOperationException("TODO: Box.orElse");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: Box.toString");
    }
}
