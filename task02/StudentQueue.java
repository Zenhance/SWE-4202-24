/*
 * StudentStack.java
 *
 * Part C answers (StudentStack):
 *
 * a) since push and pop only increment or decrement count without moving any
 *    elements around, the speed is exactly the same whether there are 5 or 50
 *    students. it always does just one step regardless of how big the stack is.
 *
 * b) no they cant interfere. even though both classes have a field named count,
 *    each object gets its own separate copy of it in memory. so changing one
 *    objects count doesnt affect the other at all.
 */
public class StudentQueue {
    private String[] names;
    private int[] marks;
    private int count;

    public StudentStack() {
        names = new String[100];
        marks = new int[100];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == 100) {
            System.out.println("Error: stack is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Error: stack is empty");
            return;
        }
        count--;
        System.out.println("Popped: " + names[count] + " (" + marks[count] + ")");
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top: " + names[count - 1] + " (" + marks[count - 1] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack (bottom to top):");
        for (int i = 0; i < count; i++) {
            System.out.println("  " + names[i] + " - " + marks[i]);
        }
    }

    public static void main(String[] args) {

        StudentStack stack = new StudentStack();

        stack.push("Alice", 85);
        stack.push("Bob", 90);
        stack.push("Charlie", 78);
        stack.push("Diana", 92);
        stack.push("Evan", 66);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();
    }

}