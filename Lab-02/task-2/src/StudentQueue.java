/*
=========================================================================================
Ans (a) If the queue has 50 students and dequeue is called 45 times, many elements
must be shifted repeatedly. Closely thousands of element moves are required
because every dequeue shifts remaining students one position left.

Ans (b) Making the array private allows each class to enforce different rules
 without outside code directly changing the array.
==========================================================================================
*/

class StudentQueue {

    private String[] names;
    private int[] marks;
    private int counter;

    public StudentQueue(int size) {
        names = new String[size];
        marks = new int[size];
        counter = 0;
    }

    public void enqueue(String name, int mark) {
        if (counter == names.length) {
            System.out.println("Queue is full");
            return;
        }

        names[counter] = name;
        marks[counter] = mark;
        counter++;

        System.out.println(name + " added to queue");
    }

    public void dequeue() {
        if (counter == 0) {
            System.out.println("The queue is empty");
            return;
        }

        System.out.println("Removed: " + names[0] +
                " (" + marks[0] + ")");

        for (int i = 0; i < counter - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }

        counter--;
    }

    public void front() {
        if (counter == 0) {
            System.out.println("The queue is empty");
            return;
        }

        System.out.println("Front Student: " + names[0] +
                " (" + marks[0] + ")");
    }

    public void display() {
        if (counter == 0) {
            System.out.println("The queue is empty");
            return;
        }

        System.out.println("Students in the Queue:");

        for (int i = 0; i < counter; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

}