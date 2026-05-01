/*
===============================================================================================================
a) Push and pop do not shift any elements. Thus, the time is constant irrespective of whether there are
five students in the stack or fifty students in the stack because we operate on the top element.

b) The 'count' member is an individual member since it is not static. Thus, modifying the `count` member of
one instance of the 'StudentStack' or 'StudentQueue' class will not modify the count member of the other object.
===============================================================================================================

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
            System.out.println("The list is full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println(name + " has been included");
    }

    public void pop() {
        if (count == 0) {
            System.out.println("The list is empty");
            return;
        }

        count--;

        System.out.println("Popped: " + names[count] +
                " (" + marks[count] + ")");
    }

    public void peek() {
        if (count == 0) {
            System.out.println("The list is empty");
            return;
        }

        System.out.println("Top Student: " + names[count - 1] +
                " (" + marks[count - 1] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("The list is empty");
            return;
        }

        System.out.println("Students in the list:");

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

}