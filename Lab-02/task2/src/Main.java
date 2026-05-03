public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack();

        stack.push("Wasif", 87);
        stack.display();

        stack.push("Jafar", 83);
        stack.display();

        stack.peek();

        stack.push("Rafi", 89);
        stack.display();

        stack.push("Hasan", 81);
        stack.display();

        stack.peek();
        stack.pop();
        stack.display();

        System.out.println("===Start of StudentQueue===");

        StudentQueue queue = new StudentQueue();

        queue.enqueue("asif", 71);
        queue.enqueue("jafar", 78);
        queue.enqueue("rafi", 77);
        queue.display();

    }
}