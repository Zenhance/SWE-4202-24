public class StudentQueue {

    private static final int MAX = 50;

    private String[] names;
    private int[]    marks;
    private int      count;

    public StudentQueue() {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count >= MAX;
    }

    public void enqueue(String name, int mark) {
        if (isFull()) {
            System.out.println("Error: Queue is full.");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
        System.out.println("Enqueued -> " + name + " (mark " + mark + ")");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty.");
            return;
        }
        System.out.println("Dequeued -> " + names[0] + " (mark " + marks[0] + ")");
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty.");
            return;
        }
        System.out.println("Front -> " + names[0] + " (mark " + marks[0] + ")");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("(Front)");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " " + names[i] + " " + marks[i]);
        }
        System.out.println("(Rear)");
    }
}