public class StudentStack {
    String[] names;
    int[] marks;
    int count;

    StudentStack(String[] name, int[] mark) {
        this.names = name;
        this.marks = mark;
        this.count = 0;
    }

    public void push(String name, int mark) {
        if (count == 100) {
            System.out.println("ERROR:STACK IS FULL");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;

    }
}

