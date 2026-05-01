/*
    Part C - StudentStack

    a.  push and pop never shift any elements. They just increase or decrease count
        by one. So it does not matter if there are 5 students or 50 students —
        the speed is exactly the same. We call this O(1) or constant time.

    b.  No, they cannot interfere. Each object has its own separate count in memory.
        When you create a StudentStack object and a StudentQueue object, Java creates
        two completely separate blocks of memory for them. Changing one object's count
        has absolutely no effect on the other.
*/

public class StudentStack {

    private static final int MAX = 50;
    private String[] names;
    private int[] marks;
    private int count;

    public StudentStack() {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == MAX) {
            System.out.println("Error: stack is full.");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Error: stack is empty.");
            return;
        }
        count--;
        System.out.println("Popped: " + names[count] + " — " + marks[count]);
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Error: stack is empty.");
            return;
        }
        System.out.println("Top: " + names[count - 1] + " — " + marks[count - 1]);
    }

    public void display() {
        if (count == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (bottom to top):");
        for (int i = 0; i < count; i++) {
            System.out.println(i + ". " + names[i] + " — " + marks[i]);
        }
    }

    public static void main(String[] args) {
        StudentStack stack = new StudentStack();

        stack.push("Alice", 85);
        stack.push("Bob", 72);
        stack.push("Carol", 91);
        stack.push("Dave", 60);
        stack.push("Eve", 78);

        System.out.println("--- Peek ---");
        stack.peek();

        System.out.println("\n--- Pop 3 times ---");
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("\n--- Display ---");
        stack.display();
    }
}