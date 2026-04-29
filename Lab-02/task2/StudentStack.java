/*

    a)push and pop never shift any elements. This means the speed stays almost the
    same whether the stack has 5 students or 50 students because only the top position
    is accessed.

    b)The count field belongs to each object separately because it is not static.
    One StudentStack or StudentQueue object cannot interfere with another object's
    count value.
*/

class StudentStack {

    private String[] names;
    private int[] marks;
    private int count;

    public StudentStack(int size) {
        names = new String[size];
        marks = new int[size];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count == names.length) {
            System.out.println("List is full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println(name + " has been included");
    }

    public void pop() {
        if (count == 0) {
            System.out.println("List is empty");
            return;
        }

        count--;

        System.out.println("Popped: " + names[count] +
                " (" + marks[count] + ")");
    }

    public void peek() {
        if (count == 0) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Top Student: " + names[count - 1] +
                " (" + marks[count - 1] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Students in List:");

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

    public static void main(String[] args) {

        StudentStack stack = new StudentStack(10);

        stack.push("Rahim", 85);
        stack.push("Karim", 90);
        stack.push("Rafiq", 78);
        stack.push("Jabbar", 88);
        stack.push("Siam", 95);

        System.out.println();

        stack.peek();

        System.out.println();

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println();

        stack.display();
    }
}