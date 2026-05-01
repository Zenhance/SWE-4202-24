//part B

public class StudentQueue {
    private String[] names;
    private int[] marks;
    private int count;
    private int capacity = 10;
    public StudentQueue() {
        names = new String[capacity];
        marks = new int[capacity];
        count = 0;
    }
    public void enqueue(String name, int mark) {
        if (count == capacity) {
            System.out.println("Queue is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }
    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Removed: " + names[0] + " (" + marks[0] + ")");
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }
    public void front() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front: " + names[0] + " (" + marks[0] + ")");
    }
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " (" + marks[i] + ")");
        }
    }
    public static void main(String[] args) {
        StudentQueue q = new StudentQueue();
        q.enqueue("A", 80);
        q.enqueue("B", 85);
        q.enqueue("C", 90);
        q.enqueue("D", 75);
        q.enqueue("E", 88);
        q.front();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();
    }
}