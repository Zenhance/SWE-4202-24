//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentStack stack = new StudentStack(5);
        stack.push("Inan", 37);
        stack.push("Saad", 40);
        stack.push("Mahi", 30);
        stack.push("Khan", 87);
        stack.push("Fuad", 93);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        StudentQueue queue = new StudentQueue(5);
        queue.enqueue("Sheldon", 100);
        queue.enqueue("Amy", 90);
        queue.enqueue("Raj", 94);
        queue.enqueue("Leonard", 86);
        queue.enqueue("Penny", 34);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();

    }
}