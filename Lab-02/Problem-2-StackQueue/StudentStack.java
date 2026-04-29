/*
a. Push and pop only adds at or removes from the last index so it takes the same time for every number of students;
b. One objects count cannot interfere with the other. Because the count has to be called with reference.
    so only the count of the referenced object will be changed;
*/


public class StudentStack {
    private static int Max = 50;

    private String[] names;
    private int[] marks;
    private int count;

    public StudentStack() {
        names = new String[Max];
        marks = new int[Max];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == Max) {
            System.out.println("Stack is full.");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Student name: " + names[count - 1]);
        System.out.println("Mark: " + marks[count - 1]);
        System.out.println();
        count--;
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Student name: " + names[count - 1]);
        System.out.println("Mark: " + marks[count - 1]);
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
        StudentStack roster = new StudentStack();

        roster.push("Alice", 100);
        roster.push("Bob", 90);
        roster.push("Charlie", 85);
        roster.push("David", 80);
        roster.push("Evan", 75);

        roster.display();

        roster.peek();

        roster.pop();
        roster.pop();
        roster.pop();

        roster.display();
    }
}
