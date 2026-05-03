import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        StudentStack stack = new StudentStack();

        stack.push(scan.nextLine(), scan.nextInt());
        stack.display();

        stack.push(scan.nextLine(), scan.nextInt());
        stack.display();

        stack.peek();

        stack.push(scan.nextLine(), scan.nextInt());
        stack.display();

        stack.push(scan.nextLine(), scan.nextInt());
        stack.display();

        stack.peek();
        stack.pop();
        stack.display();

        System.out.println("===Start of StudentQueue===");

        StudentQueue queue = new StudentQueue();

        queue.enqueue(scan.nextLine(), scan.nextInt());
        queue.enqueue(scan.nextLine(), scan.nextInt());
        queue.enqueue(scan.nextLine(), scan.nextInt());
        queue.display();
        queue.front();

        queue.dequeue();
        queue.display();
        queue.front();
    }
}