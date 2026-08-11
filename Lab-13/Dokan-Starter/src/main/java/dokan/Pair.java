package dokan;

import java.util.Objects;

/**
 * Two values of two possibly different types, kept together.
 *
 * <p>This class is given to you almost complete, as a worked example of the style the
 * rest of the toolkit should be written in: type parameters on the class, final
 * fields, no casts, no {@code Object} anywhere. Only {@link #swapped()} is left for
 * you — and it is the interesting one.
 */
public final class Pair<A, B> {

    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = Objects.requireNonNull(first, "first");
        this.second = Objects.requireNonNull(second, "second");
    }

    public A first() {
        return first;
    }

    public B second() {
        return second;
    }

    /**
     * TODO (step 1). The same two values the other way round.
     *
     * <p>Look hard at the return type. A {@code Pair<String, Integer>} must come back
     * as a {@code Pair<Integer, String>} — the type parameters swap places along with
     * the values, and the compiler will hold you to it. The body is one line.
     */
    public Pair<B, A> swapped() {
        throw new UnsupportedOperationException("TODO: Pair.swapped");
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
