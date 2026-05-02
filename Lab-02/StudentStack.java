/*
a. Push and pop do not shift any elements, they only add and remove respectively the top element.
   So this does not affect the speed whether it's a stack of 5 or 50 elements
b. As it is placed in different memory location; it won't interfere with the count of other classes
   in the main file.
*/

public class StudentStack {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void push(String name, int marks) {
        if (count >= 50) {
            System.out.println("Stack is full");
            return;
        }
        this.name[count] = name;
        this.marks[count] = marks;
        count++;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println("Name:" + this.name[count] + " Marks: " + this.marks[count]);
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Name: "+name[count - 1]+" Marks: "+ marks[count - 1]);
    }

}