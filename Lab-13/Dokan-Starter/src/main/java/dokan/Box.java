package dokan;

public final class Box<T> {
    private final T value;

    private Box(T value){
        this.value = value;
    }
    public static <T> Box<T> of(T value){
        if (value == null) {
            throw new IllegalArgumentException("Box cannot contain null");
        }
        return new Box<>(value);
    }
    public static <T> Box<T> empty() {
        return new Box<>(null);
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return value;
    }
    public T orElse(T fallback){
        if (isEmpty()) {
            return fallback;
        }

        return value;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Box(empty)";
        }

        return "Box(" + value + ")";
    }
}