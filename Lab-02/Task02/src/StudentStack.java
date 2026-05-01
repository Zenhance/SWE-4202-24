public class StudentStack {

    private String[] names;
    private int[] marks;
    private int count;
    private static final int capacity = 100;

    public StudentStack() {
        names = new String[capacity];
        marks = new int[capacity];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == capacity) {
            System.out.println("Stack is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println(names[count] + " " + marks[count]);
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(names[count - 1] + " " + marks[count - 1]);
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " " + marks[i]);
        }
    }
}