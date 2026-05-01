/*
    Part C - StudentQueue

    a.  Every dequeue shifts all remaining students one step to the left.
        If there are 50 students and you dequeue 45 times:
        First dequeue shifts 49, second shifts 48, and so on until the 45th shifts 5.
        Total moves = 49 + 48 + 47 + ... + 5 = roughly 1,215 individual moves.

    b.  Because the array is private, outside code cannot touch it directly.
        This means StudentList, StudentStack and StudentQueue can all use the exact
        same internal array and count but expose completely different methods.
        The class controls what operations are allowed — that is only possible because
        the array is hidden.
*/

public class StudentQueue {

    private static final int MAX = 50;
    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue() {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == MAX) {
            System.out.println("Error: queue is full.");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Error: queue is empty.");
            return;
        }
        System.out.println("Dequeued: " + names[0] + " — " + marks[0]);
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }

    public void front() {
        if (count == 0) {
            System.out.println("Error: queue is empty.");
            return;
        }
        System.out.println("Front: " + names[0] + " — " + marks[0]);
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue (front to back):");
        for (int i = 0; i < count; i++) {
            System.out.println(i + ". " + names[i] + " — " + marks[i]);
        }
    }

    public static void main(String[] args) {
        StudentQueue queue = new StudentQueue();

        queue.enqueue("Alice", 85);
        queue.enqueue("Bob", 72);
        queue.enqueue("Carol", 91);
        queue.enqueue("Dave", 60);
        queue.enqueue("Eve", 78);

        System.out.println("--- Front ---");
        queue.front();

        System.out.println("\n--- Dequeue 3 times ---");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("\n--- Display ---");
        queue.display();
    }
}