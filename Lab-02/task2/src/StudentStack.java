public class StudentStack {
    private Student[] list;
    private int max;
    private int count;

    public StudentStack(int max) {
        this.max = max;
        list = new Student[max];
        count = -1;
    }

    public void push(Student s) {
        if (count == max - 1) {
            System.out.println("Error!");

        }
        count++;
        list[count] = s;
    }

    public void display() {
        if (count == -1) {
            System.out.println("Error!");
            return;
        }
        for (int i = 0; i <= count; i++) {
            System.out.println(list[i].name + " " + list[i].marks);

        }

    }

    public void pop() {
        if (count == -1) {
            System.out.println("Error!");
            return;
        }
    }

    public Student peek() {
        if (count == -1) {
            System.out.println("Error!");
            return null;
        }

        return list[count];
    }


}

