# GridLedger — A National Electricity Billing Engine

A contractor built the billing engine for the National Power Distribution
Company. It **produces the right numbers** — and is, by every other measure, a
disaster to maintain. You have been brought in to rebuild it so the company can
actually live with it. **The numbers must stay exactly the same. What changes is
the shape of the code that produces them.**

Read the accompanying problem statement (`GridLedger.pdf`) first — it tells you
how the billing world behaves. This file only tells you how to run things.

## What you were handed

```
src/main/java/Bill.java   <- the contractor's engine: ONE class that does everything
src/main/java/Main.java    <- a monthly billing run that prints invoices and
                              checks every number against a hand-computed value
src/test/java/GridLedgerTest.java   <- the acceptance test. DO NOT MODIFY IT.
```

## See that the engine already works

```
./gradlew run
```

This bills a mixed batch (a household, a shop, a factory, and a subsidised
"lifeline" household), prints each invoice, and verifies every figure. The
arithmetic is already correct — that is not what this lab is about.

## See what is wrong with it

```
./gradlew test
```

Today this **does not even compile.** `GridLedgerTest` builds a residential, a
commercial, an industrial, and a lifeline connection *each by its own name* and
drops them into one billing run — and the contractor's single `Bill` class
offers no such things. That failure is the first lesson: a design that funnels
every category through one class with a `String customerType` field cannot
express what the business plainly needs.

## Your job

Rebuild the engine so that `./gradlew test` passes, **without changing any
number**. The problem statement describes how the pieces relate; the test file
fixes their exact shapes (constructor arguments, method names, return types).
Read both together.

Passing the numeric tests is necessary but not sufficient. The final group of
tests, *"The design is sound, not just the numbers,"* reads your classes
directly: it checks that the categories are genuine kinds of one common
connection type, that the lifeline connection is *built on* the residential one,
that a category-less connection cannot be constructed, and that no connection
leaks its state as a public field. A solution that reaches the right totals
through one class and a forest of `if`/`else` will not satisfy them.

Once you replace `Bill`, `Main.java` will no longer compile (it uses the old
class). Rewrite it to demonstrate a billing run with your new classes, or remove
it — the acceptance test does not depend on it.

- **Java:** 17
- **Collections:** `java.util.ArrayList` and friends are allowed.
- **Do not modify** `GridLedgerTest.java`.
- Submit your `.java` source files and your Step-0 interaction sketch.
