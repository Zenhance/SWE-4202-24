/*
a. For each call of dequeue, each array element will be moved once except the first index.
    For the first dequeue, other 49 elements will be moved once each. Each dequeue moves the remaining elements once.
    So elements will be moved total 1215 times.
b. As the array and count is private, outside code cannot access its data. So each class can behave differently without
    interfering each other using the same internal data.
 */

public class StudentQueue {
    private static int Max = 50;

    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue() {
        names = new String[Max];
        marks = new int[Max];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == Max) {
            System.out.println("Stack is full.");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Student name: " + names[0]);
        System.out.println("Mark: " + marks[0]);
        System.out.println();

        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }

    public void front() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Student name: " + names[0]);
        System.out.println("Mark: " + marks[0]);
        System.out.println();
    }

    public void display() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Student name: " + names[i]);
            System.out.println("Mark: " + marks[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StudentQueue roster = new StudentQueue();

        roster.enqueue("Alice", 100);
        roster.enqueue("Bob", 90);
        roster.enqueue("Charlie", 85);
        roster.enqueue("David", 80);
        roster.enqueue("Evan", 75);

        roster.front();

        roster.dequeue();
        roster.dequeue();
        roster.dequeue();

        roster.display();
    }
}