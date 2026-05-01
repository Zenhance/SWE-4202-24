public class StudentQueue {
    private String[] names;
    private int[] marks;
    private int count;
    private static final int capacity = 100;

    public StudentQueue() {
        names = new String[capacity];
        marks = new int[capacity];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == capacity) {
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
        System.out.println(names[0] +" "+ marks[0]);


        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        count--;  // one fewer item
    }

    public void front() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println(names[0] + " " + marks[0]);
    }

    public void display() {
        System.out.println("Queue (front to back)");
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + ": " + marks[i]);
        }
    }
}