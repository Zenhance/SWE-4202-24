/*
a. If the queue contains 50 students and dequeue is performed 45 times,
   many elements will be shifted over and over. This causes roughly
   thousands of moves because each dequeue shifts the remaining students
   one position to the left.

b. Keeping the array private protects the internal data and lets each
   class enforce its own rules, preventing outside code from directly
   changing the array.
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
            System.out.println("Queue is now full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println(name + "is added to queue");
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue is now empty");
            return;
        }

        System.out.println("Removed : " + names[0] +
                " (" + marks[0] + ")");

        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        count--;
    }

    public void front() {
        if (count == 0) {
            System.out.println("Queue is now empty");
            return;
        }

        System.out.println("Front Student is: " + names[0] +
                " (" + marks[0] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is now empty");
            return;
        }

        System.out.println("Students in the Queue:");

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

}