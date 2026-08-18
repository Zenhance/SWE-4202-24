/*

 Problem 2 Part A : StudentStack


 PART C — Realization questions for StudentStack

  a) push and pop never shift any elements. What does this mean for speed?
     It means both operations are ALWAYS instant, no matter how many
     students are in the stack. Whether there are 5 or 50 students,
     push just writes at position [count] and pop just reads position
    [count - 1] then decrements count. That is always exactly ONE step.
     In computer science we say this is O(1) — constant time.

  b) Can one object's count interfere with another object's count?
    No, never. Each object (StudentStack or StudentQueue) has its OWN
    private copy of count stored inside it. When you create two objects,
   Java allocates separate memory for each one. Changing count in one
    object has absolutely no effect on the other. This is the whole
     point of encapsulation — each object manages its own private state.

 */
public class StudentStack {

    // --- Private fields ---
    // These are copied from StudentList but made private so outside
    // code cannot touch the array directly and break the stack rules.
    private static final int MAX_SIZE = 100;
    private String[] names;    // student names
    private int[]    marks;    // student marks (parallel array)
    private int      count;    // how many students are currently in the stack

    // --- Constructor ---
    public StudentStack() {
        names = new String[MAX_SIZE];
        marks = new int[MAX_SIZE];
        count = 0;   // stack starts empty
    }

    // --- push ---
    // Adds a student at the TOP of the stack (position count).
    // Like putting a sheet of paper on top of a pile.
    // No shifting needed — we just write at the next free slot.
    public void push(String name, int mark) {
        if (count == MAX_SIZE) {
            System.out.println("Error: stack is full, cannot push " + name);
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;   // top of stack moves up by one
        System.out.println("Pushed: " + name + " (" + mark + ")");
    }

    // --- pop ---
    // Removes and prints the student at the TOP of the stack (position count-1).
    // Like taking the top sheet off the pile.
    // No shifting — we just decrement count (the slot data is ignored).
    public void pop() {
        if (count == 0) {
            System.out.println("Error: stack is empty, nothing to pop.");
            return;
        }
        count--;   // move top down by one — this "removes" the top student
        System.out.println("Popped: " + names[count] + " (" + marks[count] + ")");
        // Note: we do NOT zero out names[count] — decrementing count is enough.
        // The next push() will simply overwrite that slot.
    }

    // --- peek ---
    // Shows the student at the TOP without removing them.
    // Like looking at the top sheet without picking it up.
    public void peek() {
        if (count == 0) {
            System.out.println("Error: stack is empty, nothing to peek.");
            return;
        }
        System.out.println("Top of stack: " + names[count - 1]
                + " (" + marks[count - 1] + ")");
    }

    // --- display ---
    // Prints all students from BOTTOM to TOP (index 0 upward).
    // Bottom = first one pushed. Top = last one pushed.
    public void display() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("--- Stack (bottom to top) ---");
        for (int i = 0; i < count; i++) {
            System.out.println("  [" + i + "] " + names[i] + " - " + marks[i]);
        }
        System.out.println("--- Top is index " + (count - 1) + " ---");
    }



    // MAIN METHOD — tests the stack

    public static void main(String[] args) {

        StudentStack stack = new StudentStack();

        // Push 5 students onto the stack
        System.out.println("=== Pushing 5 students ===");
        stack.push("Alice",  85);
        stack.push("Bob",    72);
        stack.push("Carol",  90);
        stack.push("David",  68);
        stack.push("Emma",   95);

        // Peek at the top (should be Emma — last one pushed)
        System.out.println("\n=== Peek ===");
        stack.peek();

        // Pop 3 times (Emma, David, Carol — last in, first out)
        System.out.println("\n=== Popping 3 times ===");
        stack.pop();   // removes Emma
        stack.pop();   // removes David
        stack.pop();   // removes Carol

        // Display what remains (Alice at bottom, Bob on top)
        System.out.println("\n=== Display remaining ===");
        stack.display();
    }
}
