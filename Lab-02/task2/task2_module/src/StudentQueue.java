

public class StudentQueue {


    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue() {
        names = new String[50];
        marks = new int[50];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count >= 50) {
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
        StudentQueue queue = new StudentQueue();

        queue.enqueue("Tasauf", 100);
        queue.enqueue("Abdullah", 90);
        queue.enqueue("Sifat", 85);
        queue.enqueue("Nushrat", 80);
        queue.enqueue("Ridu", 75);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}