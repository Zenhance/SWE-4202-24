package dokan;

import java.util.Objects;


public final class Box<T>
{
    private final T value;
    private Box(T value)

    {
        this.value = value;
    }

    public static <T> Box<T> of(T value)
    {
        Objects.requireNonNull(value, "value");
        return new Box<>(value);
    }

    public static <T> Box<T> empty()
    {
        return new Box<>(null);
    }

    public boolean isEmpty()
    {
        return value == null;
    }

    public T get()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Box is empty");
        }
        return value;
    }

    public T orElse(T fallback)

    {
        return isEmpty() ? fallback : value;
    }

    @Override
    public String toString()
    {
        return isEmpty() ? "Box(empty)" : "Box(" + value + ")";
    }
}