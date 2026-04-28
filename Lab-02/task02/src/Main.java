public class Main {

    public static void main(String[] args) {
        System.out.println("Main runs");

        StudentStack list = new StudentStack();

        // Implementing push() method
        for (int i = 1; i <= 5; i++){
            list.push("Student"+i, i+50);
        }

        // Implementing peek() method
        list.peek();

        // Implementing pop() method
        list.pop();
        list.pop();
        list.pop();

        // Implementing display() method
        list.display();
    }
}
