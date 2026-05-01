/*
a) push and pop do not move any elements around. They only work with the top
item, so the speed remains nearly the same whether the stack contains 5 students
or 50 students.

b) Since count is not static, each object has its own separate count field.
This means one StudentStack or StudentQueue object cannot affect the count value
of another object.

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
            System.out.println("List has become full");
            return;
        }

        names[count] = name;
        marks[count] = mark;
        count++;

        System.out.println(name + " included already");
    }

    public void pop() {
        if (count == 0) {
            System.out.println("List is now empty");
            return;
        }

        count--;

        System.out.println("Removed: " + names[count] +
                " (" + marks[count] + ")");
    }

    public void peek() {
        if (count == 0) {
            System.out.println("List is now empty");
            return;
        }

        System.out.println("Top Student is: " + names[count - 1] +
                " (" + marks[count - 1] + ")");
    }

    public void display() {
        if (count == 0) {
            System.out.println("List is now empty");
            return;
        }

        System.out.println("Students in List are:");

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }

}

