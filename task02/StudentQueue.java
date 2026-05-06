/*
 * StudentQueue.java
 *
 * Part C answers (StudentQueue):
 *
 * a) every time you dequeue, you shift all remaining elements one step left.
 *    so the 1st dequeue shifts 49, the 2nd shifts 48, all the way down to the
 *    45th which shifts 5. thats 49+48+47...+5 = around 1175 total moves.
 *
 * b) because the array is private, outside code can only use it through the
 *    methods we choose to expose. this means we can give StudentStack only
 *    push/pop rules and StudentQueue only enqueue/dequeue rules, even though
 *    the underlying array is the same idea in both.
 */

public class StudentQueue {
    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue() {
        names = new String[100];
        marks = new int[100];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == 100) {
            System.out.println("Error: queue is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Error: queue is empty");
            return;
        }

        String removedName = names[0];
        int removedMark = marks[0];

        // shift everyone left by one
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        count--;
        System.out.println("Dequeued: " + removedName + " (" + removedMark + ")");
    }

    public void front() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front: " + names[0] + " (" + marks[0] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue (front to back):");
        for (int i = 0; i < count; i++) {
            System.out.println("  " + names[i] + " - " + marks[i]);
        }
    }

    public static void main(String[] args) {

        StudentQueue queue = new StudentQueue();

        queue.enqueue("Alice", 85);
        queue.enqueue("Bob", 90);
        queue.enqueue("Charlie", 78);
        queue.enqueue("Diana", 92);
        queue.enqueue("Evan", 66);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }

}
