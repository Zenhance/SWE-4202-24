package checks;

import dokan.Box;
import dokan.Pair;
import dokan.Shelf;
import shop.Book;
import shop.Sample;
import shop.Snack;

/**
 * The marks you cannot earn by running anything.
 *
 * <p>Four lines below are commented out. Each is a mistake the intern's shop compiled
 * happily and then failed on at run time. With correct type parameters,
 * <strong>javac must refuse them</strong>.
 *
 * <p>Uncomment them ONE AT A TIME, run {@code ./gradlew compileJava}, and check that
 * the build fails with the error named in the comment. Then comment the line back out
 * and try the next. If any of these four compiles, a type parameter is missing — and
 * you lose those marks even if every test case is green.
 *
 * <p>Leave every line commented out in what you submit, so the project builds.
 */
public final class CompileFailWitnesses {

    static void witnesses() {
        Shelf<Book> bookShelf = new Shelf<>(4);
        bookShelf.add(Sample.NONDITO);

        // ---- 1 ----------------------------------------------------------
        // A snack on the book shelf. This is exactly PAIN 1, and it must now be:
        //   error: incompatible types: Snack cannot be converted to Book
        //
        // bookShelf.add(Sample.CHANACHUR);

        // ---- 2 ----------------------------------------------------------
        // A shelf is for items. A String is not an Item, so the bound must reject it:
        //   error: type argument String is not within bounds of type-variable T
        //
        // Shelf<String> nonsense = new Shelf<>(4);

        // ---- 3 ----------------------------------------------------------
        // A box of snacks does not hold books, and the compiler already knows:
        //   error: incompatible types: Snack cannot be converted to Book
        //
        // Book wrong = Box.of(Sample.CHANACHUR).get();

        // ---- 4 ----------------------------------------------------------
        // swapped() really does change the order of the type parameters:
        //   error: incompatible types: Pair<Integer,String> cannot be converted to Pair<String,Integer>
        //
        // Pair<String, Integer> stillTheSame = new Pair<>("Chanachur", 40).swapped();

        // These two MUST keep compiling: the values come out already typed.
        Book book = bookShelf.get(0);
        Snack snack = Box.of(Sample.CHANACHUR).get();
        System.out.println(book + " " + snack);
    }

    private CompileFailWitnesses() {
    }
}
