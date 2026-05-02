public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack();

        stack.push("Wasif", 87);
        stack.display();

        stack.push("Jafar", 83);
        stack.display();

        stack.peek();

    }
}