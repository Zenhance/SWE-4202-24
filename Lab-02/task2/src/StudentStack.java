/*
a)push and pop are fast because no shifting is needed.
b)count is separate for each object since it is non static.
*/

class StudentStack {

    private String[] studentNames;
    private int[] studentMarks;
    private int total;

    public StudentStack(int size) {
        studentNames=new String[size];
        studentMarks=new int[size];
        total=0;
    }

    public void push(String name, int mark) {
        if (total==studentNames.length) {
            System.out.println("stack full");
            return;
        }

        studentNames[total]=name;
        studentMarks[total]=mark;
        total++;

        System.out.println(name+"added");
    }
    public void pop() {
        if (total==0) {
            System.out.println("stack empty");
            return;
        }
        total--;

        System.out.println("removed: " +studentNames[total] +
                "(" + studentMarks[total]+ ")");
    }

    public void peek() {
        if (total==0) {
            System.out.println("stack empty");
            return;
        }

        System.out.println("Top Student: " +studentNames[total-1] +
                "(" + studentMarks[total-1] + ")");
    }

    public void display() {
        if (total==0) {
            System.out.println("stack empty");
            return;
        }

        System.out.println("student stack:");

        for(int i=0;i<total;i++) {
            System.out.println(studentNames[i]+":" +studentMarks[i]);
        }
    }
}