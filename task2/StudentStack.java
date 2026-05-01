public class StudentStack {
    String[] names;
    double[] marks;
    int count = 0;

    StudentStack(String[] names, double[] marks) {
        this.names = names;
        this.marks = marks;
    }

    public void push(String names, double marks) {
        if (count == 500) {
            System.out.println("Stack is full");
            return;
        }
        this.names[count] = names;
        this.marks[count] = marks;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println("Name:" + names[count] + " Marks:" + marks[count]);
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Name:" + names[count - 1] + " Marks: " + marks[count - 1]);
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println("Name:" + names[i] + " Marks:" + marks[i]);
        }
    }
}