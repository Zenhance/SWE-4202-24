/*

 OOP Lab 2 — Problem 2 Part B : StudentQueue


  PART C — Realization questions for StudentQueue

 a) If the queue holds 50 students and you dequeue 45 times,
     roughly how many individual element moves does that require?

   Each dequeue shifts ALL remaining students one step left.
   - 1st dequeue: 49 remaining ..... 49 shifts
    - 2nd dequeue: 48 remaining.... 48 shifts
     - 3rd dequeue: 47 remaining ... 47 shifts
   - ... and so on until the 45th dequeue: 5 remaining → 5 shifts
     Total ≈ 49 + 48 + 47 + ... + 5 = roughly 1,265 individual moves.
   This is why queues with shifting are slow for large datasets.

  b) You have written StudentList, StudentStack, and StudentQueue —
     all using the same private array and count. Why does making
  the array private make this possible?
   Because private forces all access to go through the class's own
    methods (push/pop, enqueue/dequeue, etc.), the same data structure
  can enforce completely different rules depending on which methods
    are exposed — the outside world cannot bypass them by touching
    the array directly.

 */
public class StudentQueue {

    // --- Private fields ---
    // Exactly the same fields as StudentStack and StudentList.
    // The ONLY difference will be the methods (enqueue/dequeue instead of push/pop).
    private static final int MAX_SIZE = 100;
    private String[] names;
    private int[]    marks;
    private int      count;

    // --- Constructor ---
    public StudentQueue() {
        names = new String[MAX_SIZE];
        marks = new int[MAX_SIZE];
        count = 0;   // queue starts empty
    }

    // --- enqueue ---
    // Adds a student at the BACK of the queue (position count).


    public void enqueue(String name, int mark) {
        if (count == MAX_SIZE) {
            System.out.println("Error: queue is full, cannot enqueue " + name);
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
        System.out.println("Enqueued: " + name + " (" + mark + ")");
    }

    // --- dequeue ---
    // Removes and prints the student at the FRONT of the queue (position 0).
    // Like serving the first person in line.
    // IMPORTANT: everyone else must shift one step LEFT to fill the gap.
    public void dequeue() {
        if (count == 0) {
            System.out.println("Error: queue is empty, nothing to dequeue.");
            return;
        }

        // Remember the student we are removing (position 0 = front)
        String removedName = names[0];
        int    removedMark = marks[0];

        // Shift everyone left by one step
        // Person at [1] moves to [0], person at [2] moves to [1], etc.
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        count--;   // one fewer student in the queue now
        System.out.println("Dequeued: " + removedName + " (" + removedMark + ")");
    }

    // --- front ---
    // Shows the student at the FRONT without removing them.
    // Like looking at who is first in line without serving them yet.
    public void front() {
        if (count == 0) {
            System.out.println("Error: queue is empty, no front student.");
            return;
        }
        System.out.println("Front of queue: " + names[0]
                + " (" + marks[0] + ")");
    }

    // --- display ---
    // Prints all students from FRONT to BACK (index 0 onward).
    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("--- Queue (front to back) ---");
        for (int i = 0; i < count; i++) {
            System.out.println("  [" + i + "] " + names[i] + " - " + marks[i]);
        }
        System.out.println("--- Back is index " + (count - 1) + " ---");
    }



    // MAIN METHOD — tests the queue

    public static void main(String[] args) {

        StudentQueue queue = new StudentQueue();

        // Enqueue 5 students (they join the back of the line)
        System.out.println("=== Enqueuing 5 students ===");
        queue.enqueue("Alice",  85);
        queue.enqueue("Bob",    72);
        queue.enqueue("Carol",  90);
        queue.enqueue("David",  68);
        queue.enqueue("Emma",   95);

        // Check who is at the front (should be Alice — first to arrive)
        System.out.println("\nFront");
        queue.front();

        // Dequeue 3 times (Alice, Bob, Carol — first in, first out)
        System.out.println("\nDequeuing 3 times");
        queue.dequeue();   // removes Alice
        queue.dequeue();   // removes Bob
        queue.dequeue();   // removes Carol

        // Display what remains (David at front, Emma at back)
        System.out.println("\n Display remaining ");
        queue.display();
    }
}
