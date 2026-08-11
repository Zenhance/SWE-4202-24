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

    T value;
    private Box(T value) {
        this.value = value;
    }
    /** A box holding {@code value}. Refuse null: a full box holding nothing is a lie. */
    public static <T> Box<T> of(T value) {
        if(value == null)throw new NullPointerException("value is null");

        return new Box<>(value);

    }

    /** An empty box. */
    public static <T> Box<T> empty() {
        return new Box<>(null);
    }

    public boolean isEmpty() {
        return value == null;
    }

    /** The value inside. Opening an empty box is a programming mistake, so throw. */
    public T get() {
        if(this.isEmpty()) throw new IllegalStateException("value is empty");
        return value;
    }

    /** The value inside, or {@code fallback} if the box is empty. */
    public T orElse(T fallback)
    {
        return fallback;
    }

    @Override
    public String toString() {
        if(value!=null) return "Box("+value+")";
        else return "Box(empty)";
    }
}
