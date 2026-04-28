public class Main {

    public static void main(String[] args) {
        System.out.println("Main runs");

        StudentStack list = new StudentStack();

        // Testing push method
        list.push("Arnob", 99);
        list.push("Moin", 89);
        list.push("Sakep", 90);

        // Testing pop method
        list.pop();
        list.pop();
        list.pop();

        // Testing error
        list.pop();

        for (int i = 1; i <= 50; i++){
            list.push("Student"+i, i+50);
        }

        // Testing error
        list.push("Arnob", 90);

        // Testing peek method
        list.peek();

        // Testing display method
        list.display();
    }
}
