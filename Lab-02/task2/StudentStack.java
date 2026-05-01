package task2;
/*
a. push() and pop() do not shift any elements in the array. They only add or remove
a student from the top position by changing count. Because of this, the operations
stay fast even if the stack has 50 students instead of 5 students. The time taken is
almost the same in both cases.

b. No, the count variable of one object cannot interfere with another object’s count.
Each object   keeps its own separate copy of its private fields. Since count is private,
it cannot be directly accessed or changed from outside the class, which keeps the
objects  independent from  each other.
*/
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

