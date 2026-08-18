package dokan;
import java.util.Objects;
public final class Pair<A,B>{
    private final A first;
    private final B second;
    public Pair(A first,B second) {
        this.first=Objects.requireNonNull(first,"first");
        this.second=Objects.requireNonNull(second,"second");
    }
    public A first(){
        return first;
    }
    public B second(){
        return second;
    }
    public Pair<B,A> swapped(){
        return new Pair<>(second,first);
        }
        @Override
    public String toString(){
        return"("+first+","+second+")";

    }
}
