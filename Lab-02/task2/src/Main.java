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
    }
}