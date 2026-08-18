Dokan — README
SWE-4202 · Lab 13 · Generics

Team member
-----------
Rakib-240042108


1. Every type, and what it is
------------------------------
Item      — interface. Only a bound: promises every T that extends it has a name()
            and a priceTaka(), so Shelf can call totalPriceTaka() on any good.
Check<T>  — interface. One method, passes(T), written as a lambda so any shelf can
            be filtered without a new class per condition.
Box<T>    — class. Holds one value of T, or nothing. Replaces null everywhere a
            method has "no answer" to give (empty shelf, nothing sold yet, etc).
Pair<A,B> — class. Keeps two independently-typed values together and can hand them
            back in swapped order without losing type information.
Shelf<T>  — class. Fixed-capacity container for one kind of Item; the one class that
            replaces the intern's BookShelf / SnackShelf / (would-be) SimCardShelf.
Counter<T>— class. Counts occurrences of any value with a Map<T,Integer>; used for
            sales tallying and finding the best seller.
Shelves   — class (utility, non-instantiable). Holds four static generic helper
            methods that work on a Shelf<T> of any T.


2. Every type parameter, and why it is bounded the way it is
--------------------------------------------------------------
Box<T>              — unbounded. A box can hold literally anything; it never calls
                       any method on T, so it needs no promise from the compiler.
Pair<A, B>           — unbounded, and two independent parameters. A and B never
                       interact with each other or get a method called on them.
Shelf<T extends Item>— bounded. totalPriceTaka() must call priceTaka() on every T,
                       which only compiles if the compiler knows every T is an Item.
                       The bound also rejects nonsense like Shelf<String> outright.
Counter<T>           — unbounded, deliberately. Counter never inspects what T is; it
                       only needs T to work as a HashMap key (equals/hashCode from
                       Object are enough). Adding <T extends Item> here would still
                       pass every test but would be a real design mistake — it would
                       stop Counter<String> (used for sales-by-name) from compiling.
Shelves.cheapest      <T extends Item>            — needs priceTaka() to compare.
Shelves.keep          <T extends Item>            — needs priceTaka()-style access to
                                                      items on the shelf.
Shelves.max           <T extends Comparable<T>>   — needs compareTo() to find the
                                                      largest value; nothing to do
                                                      with Item at all, so it is
                                                      bounded on Comparable instead.
Shelves.addAll        <T extends Item>            — pours items onto a Shelf<T>, so
                                                      needs the same bound as Shelf.


3. Wildcards (PECS)
---------------------
keep(Shelf<T> shelf, Check<? super T> check)
    Consumer super: the check only LOOKS at a T (passes(T)), it never hands one back.
    So a Check<Item> works fine when T = Book — a check that works for "any item"
    obviously still works for a book. Check<T> alone would reject that call.

addAll(Shelf<T> shelf, List<? extends T> items)
    Producer extends: the list only GIVES items, never receives one. So a
    List<Book> can be poured onto a Shelf<Item> (Book extends Item's contract).
    List<T> alone would reject that call, because a List<Book> is not a List<Item>.


4. The erasure question
--------------------------
In Shelf<T extends Item> I wanted to back the shelf with a plain array, new T[capacity].
This is not legal Java: generics are erased by the compiler, so at run time a
Shelf<Book> and a Shelf<Item> are both just a Shelf — there is no T object left for
the JVM to build an array of (new T[n] would need a real class to allocate, and none
exists after erasure). The same reason is why T.class and (x instanceof T) are also
illegal anywhere in this project.

What I used instead: an ArrayList<T> to hold the items, plus a separate int capacity
field to remember the fixed size the constructor was given. add() checks
items.size() == capacity to decide "full" instead of relying on an array's length.


5. Constraints checklist (self-check before submitting)
-----------------------------------------------------------
[x] No raw types anywhere (Shelf<T>, Box<T>, etc. always written with their type arg)
[x] No Object-typed field/parameter and no cast to Book/Snack/SimCard in dokan/
[x] Given method signatures in Shelves left unchanged, including the wildcards
[x] Counter<T> left unbounded on purpose
[x] No new T[n], T.class, or instanceof T anywhere
[x] Nothing in dokan/ imports anything from shop/
[x] All prices are int Taka, no doubles
[x] intern/ package deleted before submission        <- do this before zipping
[x] all four CompileFailWitnesses lines re-commented  <- confirm before zipping
[x] ./gradlew strict passes with no warnings
[x] ./gradlew cases reports 27 of 27
[x] ./gradlew test reports 41 of 41