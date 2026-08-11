# Dokan — One Shelf for Every Kind of Thing

**SWE-4202 · Lab 13 · Generics · 10 marks · Java 17 · Gradle**

Rahim runs a corner shop in Mohammadpur. He sells books, snacks and SIM cards — three
unrelated things that all have a name and a price. He needs a shelf, a way to say
"there isn't one", a way to count what sold, and a couple of helpers.

He needs each of those **once**, not once per kind of good. Building that is the lab.

Read `Dokan.pdf` alongside this file. The PDF explains *why*; this file tells you
*what to do, in order*.

---

## The five files you have to write

Everything else in this project is finished. Your whole job is these five, all in
`src/main/java/dokan/`:

| File | What it teaches |
|---|---|
| `Box.java` | one type parameter — `Box<T>` |
| `Pair.java` | two type parameters — only `swapped()` is left for you |
| `Shelf.java` | a **bounded** type parameter — `Shelf<T extends Item>` |
| `Counter.java` | an **unbounded** one — `Counter<T>` |
| `Shelves.java` | static generic methods, and wildcards (`? extends`, `? super`) |

Right now each of those throws `UnsupportedOperationException("TODO: ...")`. That is
why the project compiles even though nothing works yet — you will never be stuck with a
build that will not run.

### Files you must NOT change

| File | Why |
|---|---|
| `src/test/java/checks/DokanTest.java` | **the graded suite.** Changing it is not allowed. |
| `checks/DokanCases.java` | the 27 worked cases |
| `dokan/Item.java`, `dokan/Check.java` | the two interfaces, given to you |
| `shop/Book.java`, `Snack.java`, `SimCard.java`, `Sample.java` | the goods and the data |
| `shop/Main.java` | the demo of the finished shop |

`intern/` is the code you are replacing. Read it, run it, and delete the whole package
at the end.

---

## The five commands

Run these from the project folder. On Windows write `gradlew.bat` instead of `./gradlew`.

| Command | What it does |
|---|---|
| `./gradlew intern` | Runs the intern's shop and makes its three failures happen in front of you. |
| `./gradlew cases` | **Your to-do list.** 27 worked cases with Input, Expected, Actual, Explanation, and a score at the bottom. |
| `./gradlew test` | The graded suite: 41 JUnit tests. |
| `./gradlew run` | `Main` — a day at the shop, once your code works. |
| `./gradlew strict` | Compiles with warnings as errors. The last thing you run. |

The first `./gradlew` command downloads Gradle, so give it a minute. After that they all
take about a second.

---

## Step 0 — see the problem before you fix it (10 minutes)

```bash
./gradlew intern
```

Three things go wrong, and all three are the reason generics exist:

1. **The shelf holds `Object`, so it holds anything.** A snack lands on the book shelf,
   javac says nothing, and you get a `ClassCastException` later, in a method that had
   nothing to do with the mistake.
2. **One bug, fixed once, still live in the copy.** He wrote `BookShelf`, then
   copy-pasted it into `SnackShelf`. The removal bug was found and fixed in *one* of
   them. Watch the same operation leave `BookShelf` correct and make `SnackShelf` throw.
3. **`null` is not an answer.** `cheapest()` returns `null` for an empty shelf, and the
   next line dereferences it.

Now open `intern/ObjectShelf.java` and `intern/SnackShelf.java` and read them. Then:

```bash
./gradlew cases
```

> `1 of 27 cases passed`

That number is your progress bar for the rest of the lab.

---

## Step 1 — `Box.java`, and `Pair.swapped()`

**`Box<T>`** holds either one value of type `T` or nothing at all. It is what you return
instead of `null`, so pain 3 above cannot happen. One field is enough — the value, which
is `null` exactly when the box is empty. Make the constructor `private` and build boxes
through `Box.of(value)` and `Box.empty()`.

`toString()` must print exactly `Box(empty)` or `Box(Chanachur)`; the cases compare that
text.

**`Pair<A,B>`** is given to you complete except `swapped()`. Read the rest of the class
first — it is a worked example of the style your other four classes should follow. Then
write `swapped()` and look hard at its return type: a `Pair<String,Integer>` must come
back as a `Pair<Integer,String>`. The body is one line.

```bash
./gradlew cases
```

> `7 of 27 cases passed`  ← cases 1–7

---

## Step 2 — `Shelf.java`

A shelf of fixed capacity holding items of one kind. This is the heart of the lab.

`<T extends Item>` is a **bounded** type parameter and it does two jobs at once:

- it lets `totalPriceTaka()` call `priceTaka()` on a `T`, because every `T` is
  guaranteed to be an `Item`;
- it makes `Shelf<String>` a compile error, because a String is not an `Item`.

Try deleting the bound once, just to watch `totalPriceTaka()` stop compiling. Then put
it back.

**You will want `new T[capacity]`. You cannot have it.** Java *erases* type parameters,
so at run time there is no `T` to make an array of. Use an `ArrayList<T>` and keep the
capacity in an `int`. Write this down — your submitted README has to answer for it.

Two more things to get right: `add` returns `false` when the shelf is full (being full
is ordinary, not exceptional), and `remove` must close the gap it leaves behind — or you
have just reinvented the intern's second bug.

```bash
./gradlew cases
```

> `13 of 27 cases passed`  ← cases 8–13

---

## Step 3 — `Counter.java`

Counts how many times each value has been seen. A `Map<T, Integer>` is all the state you
need.

Notice that `T` here has **no bound at all**. This class does not need to know what an
item is, so it does not ask — and that is why the very same class counts Strings on one
line and Books on the next. *Adding a bound you do not need is a real mistake, not a
harmless extra.* `Counter<T extends Item>` would still pass every test and would still
be wrong.

`mostCommon()` returns a `Box<T>` — the type parameter travels from this class straight
into the one you wrote in step 1. When nothing has been counted, that is an empty box.
No null, no special case at the call site.

```bash
./gradlew cases
```

> `19 of 27 cases passed`  ← cases 14–19

---

## Step 4 — `Shelves.java`

Four helpers that work on any shelf of any good:

```java
static <T extends Item>          Box<T>  cheapest(Shelf<T> shelf)
static <T extends Item>          List<T> keep(Shelf<T> shelf, Check<? super T> check)
static <T extends Comparable<T>> T       max(List<T> values)
static <T extends Item>          int     addAll(Shelf<T> shelf, List<? extends T> items)
```

Each has its `<T>` on the **method**, not the class. That is why callers write
`Shelves.cheapest(books)` and never `Shelves.<Book>cheapest(books)` — the compiler works
the type out from the argument. This is called **inference**.

**Do not change these signatures.** The wildcards are the marked part:

- `Check<? super T>` — *consumer super*. The check only *looks at* items, so a
  `Check<Item>` works fine on a `Shelf<Book>`. With `Check<T>` that line is rejected.
- `List<? extends T>` — *producer extends*. The list only *hands over* items, so a
  `List<Book>` can be poured onto a `Shelf<Item>`. With `List<T>` that line is rejected.

```bash
./gradlew cases
./gradlew test
./gradlew run
```

> `27 of 27 cases passed`
> `41 of 41 tests passed`

`./gradlew run` should now print a full day at Rahim's shop.

---

## Step 5 — the marks you cannot earn by running anything

Open `checks/CompileFailWitnesses.java`. Four lines are commented out. Each is a mistake
the intern's shop compiled happily and then failed on at run time. With your type
parameters written correctly, **javac must refuse all four.**

Uncomment them **one at a time**, and after each one:

```bash
./gradlew compileJava
```

The build must **fail**, with the error written in the comment above that line. Then
comment the line back out and try the next.

If any of the four compiles, a type parameter is missing somewhere — and you lose those
marks even if all 27 cases and all 41 tests are green.

**Leave every witness line commented out in what you submit,** so the project builds.

---

## Step 6 — clean up and check yourself

Delete the whole `intern/` package. You have replaced it.

```bash
./gradlew strict
```

This compiles with `-Xlint:unchecked,rawtypes -Werror`, which turns every generics
warning into a build failure. It must pass. If it does not:

- **`found raw type`** — you wrote `Shelf` where you meant `Shelf<Book>`. A raw type
  switches all the checking back off, which is exactly what you spent this lab removing.
- **`unchecked cast`** — you cast something to a generic type. If you are casting, a
  type parameter is missing.

Then run everything one last time:

```bash
./gradlew strict && ./gradlew test && ./gradlew run
```

---

## What to submit

Your `.java` sources, with `intern/` deleted and the four witness lines commented out,
plus a `README.txt` of your own containing:

1. team members and roll numbers;
2. one sentence per type you wrote — class or interface, and why;
3. every type parameter you wrote, with one line on why it is bounded the way it is —
   **or why it needs no bound**;
4. the erasure question: you wanted `new T[n]` in `Shelf`. Why can you not have it, and
   what did you do instead?

**Partial credit applies.** A project where `./gradlew cases` reports 20 of 27 is worth
far more than one that does not build. Submit whatever compiles.

---

## If you get stuck

- **`./gradlew: Permission denied`** — run `chmod +x gradlew`.
- **A case says `not implemented yet (TODO)`** — that method still throws
  `UnsupportedOperationException`. It is not a bug; you have not got there yet.
- **A case fails with an exception name** you did not expect — the runner prints the
  exception's class name in the `Actual` line. Read the Explanation under it: it states
  what the answer should have been and why.
- **Fix the topmost FAIL first.** The cases are in dependency order, so one broken method
  early on can fail five cases later.
