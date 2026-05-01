

public class StudentStack {


    private String[] names;
    private int[] marks;
    private int count;

    public StudentStack() {
        names = new String[50];
        marks = new int[50];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count >= 50) {
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
    public static void main(String[] args){
        StudentStack Stack = new StudentStack();

        stack.push("Tasauf", 84);
        stack.push("Abdullah", 143);
        stack.push("Sifat", 61);
        stack.push("Nushrat", 150);
        stack.push("Ridu", 90);




        stack.peek();



        stack.pop();
        stack.pop();
        stack.pop();


        stack.display();
    }
}

