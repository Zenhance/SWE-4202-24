/*

a. If the queue has 50 students and dequeue is called 45 times, many elements
must be shifted repeatedly. Roughly thousands of element moves are required
because every dequeue shifts remaining students one position left.

b. Hiding the array as private allows each class to enforce different rules
 without outside code directly changing the array.
*/

class StudentQueue {

    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue(int size) {
        names = new String[size];
        marks = new int[size];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == names.length) {
            System.out.println("Queue is full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println(name + " added to queue");
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Removed: " + names[0] +
                " (" + marks[0] + ")");

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

        System.out.println("Front Student: " + names[0] +
                " (" + marks[0] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Students in Queue:");

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

    public static void main(String[] args) {

        StudentQueue queue = new StudentQueue(10);

        queue.enqueue("Rahim", 85);
        queue.enqueue("Karim", 90);
        queue.enqueue("Rafiq", 78);
        queue.enqueue("Jabbar", 88);
        queue.enqueue("Siam", 95);

        System.out.println();

        queue.front();

        System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println();

        queue.display();
    }
}