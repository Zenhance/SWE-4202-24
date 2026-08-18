public class Student {
    String name;
    double mark;

    public Student(String name, double mark) {//constructor
        this.name = name;
        this.mark = mark;
    }

    public void print() {
        System.out.println(name + " - " + mark);
    }
}

class StudentStack {
    private Student[] ar = new Student[5];
    private int c = 0;

    public void push(String name, double mark) {//method
        if (c == ar.length) {
            System.out.println("Stack is full");
            return;
        }
        ar[c] = new Student(name, mark);
        c++;
    }

    public void pop() {//method
        if (c == 0) {
            System.out.println("Stack is empty");
            return;
        }
        c--;
        ar[c].print();
    }

    public void peek() {
        if (c == 0) {
            System.out.println("Stack is empty");
            return;
        }
        ar[c - 1].print();
    }

    public void display() {
        for (int i = 0; i < c; i++) {
            ar[i].print();
        }
    }
}
//a.The size does not affect performance significantly.
//b. No, Each object do their own work , they do not interfere with another's . they operate independently without affecting each other.
