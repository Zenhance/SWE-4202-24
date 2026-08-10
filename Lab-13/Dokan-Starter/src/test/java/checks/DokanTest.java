package checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import dokan.Box;
import dokan.Check;
import dokan.Counter;
import dokan.Item;
import dokan.Pair;
import dokan.Shelf;
import dokan.Shelves;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import shop.Book;
import shop.Sample;
import shop.SimCard;
import shop.Snack;

/**
 * The graded suite. Do not modify this file.
 *
 * <p>It checks the same behaviour as {@code DokanCases}, plus the corners a printed
 * trace cannot show. Run it with {@code ./gradlew test}.
 */
@DisplayName("Dokan")
class DokanTest {

    private static Shelf<Book> bookShelf() {
        Shelf<Book> shelf = new Shelf<>(4);
        for (Book book : Sample.BOOKS) {
            shelf.add(book);
        }
        return shelf;
    }

    // =====================================================================
    @Nested
    @DisplayName("Box")
    class Boxes {

        @Test
        void anEmptyBoxIsEmpty() {
            assertTrue(Box.empty().isEmpty());
        }

        @Test
        void aFullBoxIsNotEmptyAndGivesItsValue() {
            Box<String> box = Box.of("Chanachur");
            assertFalse(box.isEmpty());
            assertEquals("Chanachur", box.get());
        }

        @Test
        void openingAnEmptyBoxThrows() {
            assertThrows(IllegalStateException.class, () -> Box.empty().get());
        }

        @Test
        void orElseReturnsTheValueWhenThereIsOne() {
            assertEquals("Chanachur", Box.of("Chanachur").orElse("nothing"));
        }

        @Test
        void orElseReturnsTheFallbackWhenEmpty() {
            assertEquals(Sample.GRAMMAR, Box.<Book>empty().orElse(Sample.GRAMMAR));
        }

        @Test
        void aFullBoxCannotHoldNull() {
            assertThrows(NullPointerException.class, () -> Box.of(null));
        }

        @Test
        void boxesPrintReadably() {
            assertEquals("Box(empty)", Box.empty().toString());
            assertEquals("Box(Chanachur)", Box.of("Chanachur").toString());
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Pair")
    class Pairs {

        @Test
        void aPairKeepsBothValues() {
            Pair<String, Integer> pair = new Pair<>("Chanachur", 40);
            assertEquals("Chanachur", pair.first());
            assertEquals(40, pair.second());
        }

        @Test
        void swappedReversesTheValuesAndTheTypes() {
            Pair<Integer, String> swapped = new Pair<>("Chanachur", 40).swapped();
            assertEquals(40, swapped.first());
            assertEquals("Chanachur", swapped.second());
        }

        @Test
        void swappedTwiceIsWhereYouStarted() {
            Pair<String, Integer> there = new Pair<>("Chanachur", 40);
            Pair<String, Integer> andBack = there.swapped().swapped();
            assertEquals(there.first(), andBack.first());
            assertEquals(there.second(), andBack.second());
        }

        @Test
        void bothTypeParametersMayBeTheSame() {
            Pair<String, String> both = new Pair<>("Robi", "Grameenphone");
            assertEquals("Grameenphone", both.swapped().first());
        }

        @Test
        void pairsPrintReadably() {
            assertEquals("(Chanachur, 40)", new Pair<>("Chanachur", 40).toString());
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Shelf")
    class Shelfs {

        @Test
        void threeBooksGoOnTheShelf() {
            assertEquals(3, bookShelf().size());
            assertEquals(4, bookShelf().capacity());
            assertFalse(bookShelf().isFull());
        }

        @Test
        void theTotalPriceUsesTheBound() {
            assertEquals(1130, bookShelf().totalPriceTaka());
        }

        @Test
        void anEmptyShelfIsWorthNothing() {
            Shelf<Book> shelf = new Shelf<>(4);
            assertTrue(shelf.isEmpty());
            assertEquals(0, shelf.totalPriceTaka());
        }

        @Test
        void aFullShelfRefusesMoreWithoutThrowing() {
            Shelf<Book> shelf = bookShelf();
            assertTrue(shelf.add(Sample.HIMU));
            assertTrue(shelf.isFull());
            assertFalse(shelf.add(Sample.NONDITO));
            assertEquals(4, shelf.size());
        }

        @Test
        void getReturnsTheRightItemAndRefusesBadPositions() {
            assertEquals("Nondito Noroke", bookShelf().get(0).name());
            assertThrows(IndexOutOfBoundsException.class, () -> bookShelf().get(3));
            assertThrows(IndexOutOfBoundsException.class, () -> bookShelf().get(-1));
        }

        @Test
        void containsLooksByName() {
            assertTrue(bookShelf().contains("Feluda Samagra"));
            assertFalse(bookShelf().contains("Chips"));
        }

        @Test
        void removeLeavesNoHoleBehind() {
            Shelf<Book> shelf = bookShelf();
            assertTrue(shelf.remove("Feluda Samagra"));
            assertEquals(2, shelf.size());
            assertEquals(430, shelf.totalPriceTaka());
            assertEquals("Bangla Grammar", shelf.get(1).name());
        }

        @Test
        void removingSomethingThatIsNotThereChangesNothing() {
            Shelf<Book> shelf = bookShelf();
            assertFalse(shelf.remove("Chips"));
            assertEquals(3, shelf.size());
        }

        @Test
        void aCallerCannotUseItemsToChangeTheShelf() {
            List<Book> items = bookShelf().items();
            assertThrows(UnsupportedOperationException.class, () -> items.add(Sample.HIMU));
        }

        @Test
        void capacityMustBeAtLeastOne() {
            assertThrows(IllegalArgumentException.class, () -> new Shelf<Book>(0));
        }

        @Test
        void theSameClassHoldsSnacksAndSimCards() {
            Shelf<Snack> snacks = new Shelf<>(4);
            for (Snack snack : Sample.SNACKS) {
                snacks.add(snack);
            }
            Shelf<SimCard> sims = new Shelf<>(4);
            for (SimCard sim : Sample.SIMS) {
                sims.add(sim);
            }
            assertEquals(95, snacks.totalPriceTaka());
            assertEquals(350, sims.totalPriceTaka());
        }

        @Test
        void aShelfOfItemsHoldsAllThreeKindsAtOnce() {
            Shelf<Item> mixed = new Shelf<>(4);
            mixed.add(Sample.NONDITO);
            mixed.add(Sample.CHANACHUR);
            mixed.add(Sample.GP);
            assertEquals(3, mixed.size());
            assertEquals(490, mixed.totalPriceTaka());
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Counter")
    class Counters {

        private Counter<String> sales() {
            Counter<String> counter = new Counter<>();
            counter.add("Chanachur");
            counter.add("Biscuit");
            counter.add("Chanachur");
            counter.add("Chips");
            counter.add("Chanachur");
            return counter;
        }

        @Test
        void countsWhatItWasGiven() {
            assertEquals(3, sales().count("Chanachur"));
            assertEquals(1, sales().count("Biscuit"));
        }

        @Test
        void somethingNeverSeenCountsZero() {
            assertEquals(0, sales().count("Chocolate"));
            assertEquals(0, new Counter<String>().count("Chanachur"));
        }

        @Test
        void distinctCountsTheDifferentValues() {
            assertEquals(3, sales().distinct());
            assertEquals(0, new Counter<String>().distinct());
        }

        @Test
        void mostCommonComesBackInABox() {
            Box<String> best = sales().mostCommon();
            assertFalse(best.isEmpty());
            assertEquals("Chanachur", best.get());
        }

        @Test
        void mostCommonOfNothingIsAnEmptyBox() {
            assertTrue(new Counter<String>().mostCommon().isEmpty());
        }

        @Test
        void theSameCounterClassCountsBooks() {
            Counter<Book> counter = new Counter<>();
            counter.add(Sample.NONDITO);
            counter.add(Sample.FELUDA);
            counter.add(Sample.NONDITO);
            assertEquals(2, counter.count(Sample.NONDITO));
            assertEquals(Sample.NONDITO, counter.mostCommon().get());
        }
    }

    // =====================================================================
    @Nested
    @DisplayName("Shelves")
    class ShelvesTest {

        @Test
        void cheapestFindsTheCheapest() {
            assertEquals("Bangla Grammar", Shelves.cheapest(bookShelf()).get().name());
        }

        @Test
        void cheapestOfAnEmptyShelfIsAnEmptyBox() {
            assertTrue(Shelves.cheapest(new Shelf<Book>(4)).isEmpty());
        }

        @Test
        void keepFiltersInShelfOrder() {
            Check<Item> under300 = item -> item.priceTaka() < 300;
            List<Book> kept = Shelves.keep(bookShelf(), under300);
            assertEquals(List.of("Nondito Noroke", "Bangla Grammar"), names(kept));
        }

        @Test
        void keepCanReturnEverythingOrNothing() {
            assertEquals(3, Shelves.keep(bookShelf(), item -> true).size());
            assertEquals(0, Shelves.keep(bookShelf(), item -> false).size());
        }

        @Test
        void keepAcceptsACheckWrittenForAnySupertype() {
            // Check<Item> applied to a Shelf<Book>: only compiles with Check<? super T>.
            Check<Item> anything = item -> item.name().length() > 4;
            assertEquals(3, Shelves.keep(bookShelf(), anything).size());
        }

        @Test
        void maxWorksOnNumbers() {
            assertEquals(40, Shelves.max(List.of(40, 25, 30)));
        }

        @Test
        void theSameMaxWorksOnText() {
            assertEquals("Chips", Shelves.max(List.of("Chanachur", "Biscuit", "Chips")));
        }

        @Test
        void maxOfNothingIsRefused() {
            assertThrows(IllegalArgumentException.class, () -> Shelves.max(List.<Integer>of()));
        }

        @Test
        void addAllPoursAListOfBooksOntoAShelfOfItems() {
            // List<Book> into Shelf<Item>: only compiles with List<? extends T>.
            Shelf<Item> mixed = new Shelf<>(4);
            assertEquals(3, Shelves.addAll(mixed, Sample.BOOKS));
            assertEquals(1130, mixed.totalPriceTaka());
        }

        @Test
        void addAllStopsWhenTheShelfIsFull() {
            Shelf<Book> small = new Shelf<>(2);
            assertEquals(2, Shelves.addAll(small, Sample.BOOKS));
            assertEquals(2, small.size());
        }

        @Test
        void addAllOfNothingAddsNothing() {
            Shelf<Book> shelf = new Shelf<>(4);
            assertEquals(0, Shelves.addAll(shelf, List.<Book>of()));
            assertTrue(shelf.isEmpty());
        }
    }

    // =====================================================================
    private static List<String> names(List<? extends Item> items) {
        List<String> out = new ArrayList<>();
        for (Item item : items) {
            out.add(item.name());
        }
        return out;
    }
}
