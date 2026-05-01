public class StudentQueue {
    private String[] names = new String[5];
    private int[] marks = new int[5];
    private int count = 0;

    public void enqueue(String name, int mark) {
        if (count == names.length) {
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

        System.out.println("Removed: " + names[0] + " " + marks[0]);

        for (int i = 1; i < count; i++) {
            names[i - 1] = names[i];
            marks[i - 1] = marks[i];
        }

        count--;
    }

    public void front() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front: " + names[0] + " " + marks[0]);
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " " + marks[i]);
        }
    }

    public static void main(String[] args) {
        StudentQueue q = new StudentQueue();

        q.enqueue("wasi", 80);
        q.enqueue("musaddik", 70);
        q.enqueue("anisha", 90);
        q.enqueue("mustakim", 60);
        q.enqueue("mohsina", 85);

        q.front();

        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.display();
    }
}