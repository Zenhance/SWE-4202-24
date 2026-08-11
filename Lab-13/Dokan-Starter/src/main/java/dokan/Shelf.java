package dokan;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO (step 2). A shelf of fixed capacity holding items of one kind.
 *
 * <p>{@code <T extends Item>} is a <strong>bounded</strong> type parameter, and it is
 * the heart of this lab. The bound does two jobs at once:
 * <ul>
 *   <li>it lets {@link #totalPriceTaka()} call {@code priceTaka()} on a {@code T},
 *       because every {@code T} is guaranteed to be an {@code Item}. Delete the bound
 *       and that method stops compiling — try it, it is worth seeing;</li>
 *   <li>it makes {@code Shelf<String>} a compile error, because a String is not an
 *       Item and has no business being on Rahim's shelf.</li>
 * </ul>
 *
 * <p>And a {@code Shelf<Book>} refuses a Snack at compile time, not at the till.
 * That is the intern's PAIN 1, fixed.
 *
 * <p><strong>About the storage.</strong> You probably want {@code new T[capacity]}.
 * You cannot have it: Java erases type parameters, so at run time there is no
 * {@code T} to make an array of. Use an {@code ArrayList<T>} and keep the capacity in
 * an {@code int} instead. Your submitted README must mention this.
 *
 * <p>Other hints: {@code add} returns {@code false} when the shelf is full — being
 * full is ordinary, not exceptional. {@code remove} must close the gap it leaves, or
 * you will have reinvented the intern's PAIN 2. {@code items()} must not let the
 * caller change the shelf.
 */
public final class Shelf<T extends Item> {
     private final int capacity;
     private final List<T> items = new ArrayList<>();

  public Shelf(int capacity){
      if(capacity<0){
          throw new IllegalArgumentException("Capacity cant be negative");
      }
      this.capacity=capacity;
  }