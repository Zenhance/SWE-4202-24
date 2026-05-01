/*a. In a stack, push and pop don’t move any other elements, they just work at the top. Because of that, each operation takes the same amount of time no matter how many students are in the stack. So whether there are 5 or 50 students, the speed stays almost the same.

b. No, one object’s count cannot affect another’s. Each object has its own separate count variable stored in memory. Since it is private, it can only be changed through its own methods, so the two objects stay completely independent.
*/






public class StudentStack {
    private String[] names = new String[5];
    private int[] marks = new int[5];
    private int count = 0;

    public void push(String name, int mark) {
        if (count == names.length) {
            System.out.println("Stack is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println("Removed: " + names[count] + " " + marks[count]);
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top: " + names[count - 1] + " " + marks[count - 1]);
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " " + marks[i]);
        }
    }

    public static void main(String[] args) {
        StudentStack s = new StudentStack();

        s.push("wasi", 80);
        s.push("musaddik", 70);
        s.push("anisha", 90);
        s.push("mustakim", 60);
        s.push("mohsina", 85);

        s.peek();

        s.pop();
        s.pop();
        s.pop();

        s.display();
    }
}