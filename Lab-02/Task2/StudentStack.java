/*
PartA
a) Speed stays constant regardless of size- push and pop take same time (0(1)).

b) No, one object's count can't interefere with another. Each object has it's own separate copy of the fields in memory.
*/

public class StudentStack{

    private String[] names;
    private int[] marks;
    private int count;
    private int cap = 10;
    public StudentStack() {
        names = new String[cap];
        marks = new int[cap];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == cap) {
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
        System.out.println("Removed: " + names[count - 1] + " (" + marks[count - 1] + ")");
        count--;
    }
    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top: " + names[count - 1] + " (" + marks[count - 1] + ")");
    }
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " (" + marks[i] + ")");
        }
    }
    public static void main(String[] args) {
    StudentStack s = new StudentStack();

    s.push("A", 80);
    s.push("B", 85);
    s.push("C", 90);
    s.push("D", 75);
    s.push("E", 88);

    s.peek();

    s.pop();
    s.pop();
    s.pop();

    s.display();
    }
}