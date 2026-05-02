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

}