import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack();

        stack.push(getName(), getMark());
        stack.display();

        stack.push(getName(), getMark());
        stack.display();

        stack.peek();

        stack.push(getName(), getMark());
        stack.display();

        stack.push(getName(), getMark());
        stack.display();

        stack.peek();
        stack.pop();
        stack.display();

        System.out.println("===Start of StudentQueue===");

        StudentQueue queue = new StudentQueue();

        queue.enqueue(getName(), getMark());
        queue.enqueue(getName(), getMark());
        queue.enqueue(getName(), getMark());
        queue.display();
        queue.front();

        queue.dequeue();
        queue.display();
        queue.front();
    }

    static Scanner scan = new Scanner(System.in);

    public static String getName() {
        System.out.print("Enter student name: ");

        String name = scan.nextLine();
        return name;
    }

    public static int getMark() {
        System.out.print("Enter mark: ");
        int mark = scan.nextInt();
        scan.nextLine();
        return mark;
    }
}