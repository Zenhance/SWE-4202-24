# Reading Input in Java — A Guide for the Car Parking Lab

This lab does not test whether you can remember Java's input API. It tests your design. So
this guide gives you the input plumbing outright, and explains *why* every piece of it is
there. Read it once, keep the shape, and spend your thinking on the rest of the problem.

Nothing in this guide tells you what classes to write. It is only about getting a typed line
of text into your program and getting an answer back out.

---

## 1. What your program has to do

Somebody types lines into the console, one at a time:

```
SLOTS 1 2 1
MAXSTAY 10
BIKE DH-11-2233 NONE
BILL DH-11-2233
END
```

Most lines are orders — do something, say nothing. A few are questions — print one line.
Your program keeps reading until the line `END` arrives.

So the whole program has this shape:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                // ... do something with hours ...
            } else if (field[0].equals("COUNT")) {
                System.out.println(/* the number you worked out */);
            }
            // ... one branch per keyword ...
        }
    }
}
```

Everything below explains one line of that.

---

## 2. `new Scanner(System.in)` — where the text comes from

`System.in` is the console: whatever is typed at the keyboard. It hands you *bytes*, which is
useless on its own. `Scanner` is the wrapper that turns those bytes into whole lines, words
and numbers you can use.

```java
Scanner input = new Scanner(System.in);
```

Create it **once**, before the loop, and reuse it. Creating a second `Scanner` on `System.in`
inside a loop is a classic way to lose input: each one buffers ahead, so the second may never
see lines the first already swallowed.

You do not need to close it. Closing a `Scanner` on `System.in` closes the console for good,
and any later read fails.

---

## 3. `while (input.hasNextLine())` — why the loop needs a guard

`nextLine()` does not return anything polite when the input has run out. It throws
`NoSuchElementException` and your program dies with a stack trace, which as far as marking is
concerned is a wrong answer.

`hasNextLine()` asks first: *is there another line at all?* It returns `false` when the input
is finished, so the loop simply ends.

```java
while (input.hasNextLine()) {     // safe
    String line = input.nextLine();
}
```

```java
while (true) {                    // crashes at the end of the input
    String line = input.nextLine();
}
```

Your program has two ways to stop, and it needs both:

- the line `END` arrives → you `break` out of the loop yourself;
- the input runs out without an `END` → `hasNextLine()` returns `false` and the loop ends
  quietly instead of throwing.

When you are typing by hand and want to signal "no more input" without typing `END`, press
**Ctrl+D** (Linux and macOS) or **Ctrl+Z then Enter** (Windows).

---

## 4. `nextLine()`, not `next()` or `nextInt()`

The three `Scanner` methods read different amounts:

| Method | Reads | Leaves behind |
|---|---|---|
| `nextLine()` | everything up to the end of the line | nothing |
| `next()` | one word | the rest of the line, including the newline |
| `nextInt()` | one number | the rest of the line, including the newline |

A line here is a keyword *plus* its fields — `BIKE DH-11-2233 NONE` is one instruction, not
three. Reading it whole with `nextLine()` and splitting it yourself keeps that grouping.

There is also a trap worth knowing about, because most people meet it once and lose an hour:

```java
int n = input.nextInt();          // reads 5, leaves the newline sitting there
String name = input.nextLine();   // reads that leftover newline: name is ""
```

`nextInt()` stops at the end of the number and does not consume the newline after it, so the
next `nextLine()` finds an empty remainder and returns `""`. Using `nextLine()` for everything
avoids the whole problem.

---

## 5. `.trim()` and `.isEmpty()` — cleaning up what was typed

```java
String line = input.nextLine().trim();
if (line.isEmpty()) {
    continue;
}
```

`trim()` returns a copy of the string with spaces (and stray tabs and carriage returns) removed
from both ends. This matters more than it looks:

- a stray space at the *start* of the line would make `split(" ")` return an empty first field,
  so `field[0]` holds `""` and none of your keyword tests match. (A space at the end is harmless
  — `split` drops trailing empty fields — but a doubled space in the middle is not: `"COUNT  X"`
  splits into three fields, the middle one empty.)
- a file written on Windows ends its lines with `\r\n`, and the `\r` travels along inside the
  string, so `"END\r".equals("END")` is `false` and your program never stops. `trim()` removes it.

Note that `trim()` does **not** change `line` — strings in Java are immutable, and every string
method returns a *new* string. `line.trim();` on its own accomplishes nothing; you must assign
the result.

`isEmpty()` skips blank lines, so a stray Enter does not become a mysterious instruction.
`continue` means "go straight to the next turn of the loop".

---

## 6. `split(" ")` — one line into its parts

```java
String[] field = line.split(" ");
```

`split` cuts the string wherever it finds the separator and returns the pieces as an array.
For `"BIKE DH-11-2233 NONE"` you get:

| | |
|---|---|
| `field[0]` | `"BIKE"` |
| `field[1]` | `"DH-11-2233"` |
| `field[2]` | `"NONE"` |
| `field.length` | `3` |

Arrays count from **0**, so the keyword is `field[0]` and the first piece of information is
`field[1]`. Reading `field[3]` here throws `ArrayIndexOutOfBoundsException`, so only reach for
the fields the keyword you just matched actually has: `COUNT` has one field, `MAXSTAY` has two,
`BIKE` has three.

Every element of that array is a `String`. Even `"10"` is a `String` — see the next section.

---

## 7. `Integer.parseInt(...)` — text is not a number

This is the one that trips people up most.

Everything that arrives from the console is text. The line `MAXSTAY 10` gives you the two
*characters* `'1'` and `'0'`, not the number ten. Java will not let you do arithmetic on that,
and it should not:

```java
String hours = field[1];      // "10"
int later = hours + 1;        // will not compile
```

`Integer.parseInt` reads the digits and produces the `int` they spell:

```java
int hours = Integer.parseInt(field[1]);   // 10, a number you can add and compare
```

Worse than the compile error is the case where `+` *does* work:

```java
String a = "10";
String b = "5";
System.out.println(a + b);                                     // 105
System.out.println(Integer.parseInt(a) + Integer.parseInt(b));  // 15
```

For strings, `+` means *stick together*. `"10" + "5"` is `"105"`. That compiles cleanly, prints
a plausible-looking number, and is wrong — so convert at the moment you read the field, and keep
numbers as `int` from then on.

`parseInt` throws `NumberFormatException` if the text is not a whole number (`"ten"`, `"1.5"`,
`""`, `"10 "` — which is another reason for that `trim()`). In this lab every numeric field is a
whole number, so you do not need to catch it; if you ever *do* see it, it means you parsed the
wrong field.

The reverse direction needs nothing at all: `System.out.println(someInt)` prints the digits for
you.

---

## 8. `.equals(...)`, never `==`, for text

```java
if (field[0].equals("COUNT")) { ... }     // right
if (field[0] == "COUNT")      { ... }     // wrong, even when the text matches
```

For objects — and a `String` is an object — `==` asks *are these the same object in memory?*
`equals` asks *do these hold the same characters?* Those are different questions.

Text you typed into your own source code is pooled by the compiler, so `"COUNT" == "COUNT"` is
`true` and beginners conclude that `==` works. Text your program *built while running* — a piece
of a line that `split` just cut out — is a new object, so `field[0] == "COUNT"` is `false` even
when `field[0]` holds exactly `COUNT`. This is why the bug is dangerous: it passes your quick
test and fails on real input.

The rule is simple. `==` for `int`, `char` and `boolean`. `.equals` for `String` and every other
object.

Useful relatives:

```java
word.equalsIgnoreCase("count")   // same letters, ignoring capitals
word.isEmpty()                   // length is 0
word.isBlank()                   // empty, or nothing but spaces
```

The keywords in this lab are always capitals, so plain `equals` is enough.

---

## 9. Turning a word into an object

At some point a keyword has to become a thing in your program:

```java
if (field[0].equals("BIKE")) {
    // build whatever your design calls a motorcycle
} else if (field[0].equals("CAR")) {
    // ... a car
} else if (field[0].equals("TRUCK")) {
    // ... a truck
}
```

Keep that chain in one place, next to the reading. It is the boundary between text and your
program: text goes in, an object comes out. Once you hold the object, work with the object —
do not carry the word `"BIKE"` around and ask about it again later.

A `switch` on the string is fine too, if you prefer it:

```java
switch (field[0]) {
    case "BIKE" -> { /* ... */ }
    case "CAR"  -> { /* ... */ }
    default     -> { /* ... */ }
}
```

---

## 10. `System.out.println(...)` — printing exactly what was asked

`println` prints its argument and moves to a new line. `print` prints without the newline; you
almost never want it here, because each answer is its own line.

The marking compares your lines with the expected lines, character for character. So:

- print an answer **only** for the lines that ask a question. Orders print nothing at all;
- print the number or the word alone — `10`, not `Bill: 10` and not `10 Taka`;
- never print a prompt. `System.out.print("Enter command: ")` is helpful to a human and fatal
  to marking, because it becomes an extra line of output that was not expected;
- do not print a heading, a blank line at the end, or a farewell message;
- send nothing to `System.err` in your final version, and delete your debugging prints.

If a question can have no answer, print the word the problem statement specifies for that case.
Printing nothing at all shifts every later line up by one and turns one wrong answer into a
whole wrong output.

---

## 11. Exceptions at the boundary

Reading a line can produce something the program must refuse. `throw` reports that, and the
`catch` around the reading decides what to do about it:

```java
try {
    // the work that might refuse
} catch (SomeRefusalException refusal) {
    // count it, or print the word the problem says to print
}
```

Two conveniences worth knowing:

```java
catch (FirstException | SecondException refusal) { ... }   // one handler, two kinds
```

A checked exception must be either caught or declared with `throws` on the method that lets it
escape. Note that catching an exception is *not* the same as ignoring it — an empty `catch`
block silently swallows the problem and leaves your counts wrong.

---

## 12. Compiling and running

From the folder holding your `.java` files:

```
javac *.java
java Main
```

`javac *.java` compiles every source file in the folder. `java Main` starts the class whose
`main` you want to run — so the file named `Main.java` must contain
`public static void main(String[] args)`.

Then just type the instructions, pressing Enter after each one. Your program answers as you go
and stops when you type `END`.

While you are testing, retyping fifty lines is miserable. Put them in a text file and let the
shell feed them in — this is only a convenience for you, and changes nothing about how the
program works:

```
java Main < my_test.txt
```

---

## 13. Mistakes that cost marks

1. `==` instead of `.equals` when comparing a typed word.
2. Forgetting `Integer.parseInt`, so `"10" + "5"` becomes `"105"`.
3. `while (true)` with no `hasNextLine()` guard, so the program crashes at the end of input.
4. Printing prompts or extra text.
5. Printing something for an order that should print nothing, or printing nothing for a question.
6. Ignoring `trim()`, then wondering why `END` was never recognised.
7. Mixing `nextInt()` and `nextLine()` and getting empty strings.
8. Reading `field[2]` on a line that only has two fields.
9. Leaving debugging output in the version you hand in.
