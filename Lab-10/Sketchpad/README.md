# Sketchpad — A Little Shape-Drawing Kit

**SWE-4202 · Lab 10 · Java 17 · 8 marks**

You are building the *shape* half of a tiny console drawing tool. The part that
actually prints the picture (`Canvas`) and the part that runs everything
(`Main`) are given to you. Everything else is yours to design: the family of
**shapes**, the family of **exceptions** a shape throws when it cannot be drawn,
and the **gallery** that draws a pile of mixed shapes and, when one cannot be
drawn, skips it, says why, and keeps going.

There is **no unit test** in this lab. You check your work by running `Main` and
reading the picture and the report it prints.

---

## How to run

Open `src/main/java/Main.java` and run it (IntelliJ: right-click → **Run 'Main'**).

`Main` will not compile until the classes it uses exist — that is deliberate.
Reading `Main` is how you learn the exact class names, constructors, and methods
your code must provide. Create the classes below and `Main` comes to life.

---

## Provided — do NOT modify

| File | What it is |
|------|------------|
| `Canvas.java` | The console "screen." It paints filled circles and rectangles **for you** — you never work out which cells to colour. Ask it `capacity()` for its drawing area (its total number of cells), `width()`/`height()` for its size, `show()` to print the picture, `clear()` to wipe it. |
| `Main.java` | Runs the whole kit and shows how your classes are used: it builds a mixed pile of shapes, hands them to a gallery, draws them, then demonstrates resizing a square and rejecting a malformed shape. |

To draw, your shapes call the `Canvas` primitives — `circle(radius)` and
`rectangle(width, height)`. You never draw pixels yourself.

---

## What you must build

### The shape family
A top type that stands for **any shape**, plus the concrete kinds **circle**,
**rectangle**, and **square**. Every shape, whatever its kind, can:
- report its **area**;
- give a one-line **description** of itself;
- **draw itself** on a `Canvas` — but only after checking it *fits*: if it does
  not fit it throws (see below) and paints **nothing**, leaving the canvas
  exactly as it was.

A shape built with an impossible size (a radius, side, width or height that is
zero or negative) must be **rejected at construction** — such a shape must never
come into existence.

A **square is a kind of rectangle** whose sides are always equal: it reuses what
a rectangle already does, and your job is to decide what it must change so that
it always stays square.

### The exception family
When the canvas cannot draw a well-formed shape, the shape throws a **checked**
exception. There are two kinds:
- **`ShapeTooLargeException`** — the shape is bigger than the canvas can hold
  (its area exceeds the canvas `capacity()`);
- **`ShapeTooSmallException`** — the shape would not cover even a single cell.

The gallery must be able to catch **both of these together, in one place** in its
draw loop — and it should still work the day a third kind of failure is added.
How you arrange `ShapeTooLargeException` and `ShapeTooSmallException` so that a
*single* `catch` can hold all of them at once is part of the design.

### The gallery
Holds a mixed pile of shapes (circles, rectangles, squares) together as plain
shapes. It must:
- **draw the whole pile in one sweep**, asking each shape to draw itself —
  without ever asking which *kind* each shape is;
- **survive every failure**: when a shape cannot be drawn it throws; the gallery
  catches it, records the shape and the reason, and moves on to the next — one
  un-drawable shape must never stop the shapes behind it;
- **report** how many shapes were drawn, how many were skipped and why, and then
  show the finished canvas;
- report how many shapes are **waiting** to be drawn.

---

## The three decisions you are marked on

The picture is easy to eyeball; the marks are in these design choices.

1. **Which class is `abstract`, and which is `concrete`?** One class stands for
   "any shape at all" and has no form of its own — no one should be able to
   construct it, so `new` on it must not compile. Another is itself a real,
   drawable shape that also happens to be a parent. Decide which is which, and be
   ready to say why.
2. **When do you override a method the parent already wrote?** Only when the
   parent's version is wrong for that child — not out of habit. One of your
   overrides is *necessary* (or the shape breaks its own rules); overriding a
   method that is already correct is a mistake. Know which is which.
3. **Which exception, and thrown from where?** A shape built with an impossible
   size is a bug in the caller: reject it from the **constructor** with an
   `IllegalArgumentException` (unchecked). A well-formed shape the canvas cannot
   hold is an expected outcome the gallery must survive: it travels as a
   **checked** exception, caught by the gallery. Keep the two apart.

---

## Also submit: a four-sentence design note

1. Which class is `abstract`, and why nobody may construct it.
2. Which parent class you left concrete, and why.
3. One method you **overrode** even though the parent implemented it, and why.
4. One method you **deliberately did not override**, and why.

---

## Rules

- Java 17. Use `double` for sizes and areas, `int` for counts.
- Use a `java.util.ArrayList` for the gallery's pile.
- Do **not** modify the provided files, and do **not** draw pixels yourself —
  call the `Canvas` primitives.
- Partial credit is awarded; submit whatever compiles, plus your design note.

**Team members / roll numbers:** _(fill in)_
