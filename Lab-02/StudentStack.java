public class StudentStack {
    private String[] name = new String[50];
    private int[] mark = new int[50];
    private int count=0;

    public void push(String name,int mark) {
        if (count == students.length) {
            System.out.println("Stack is full");
            return;
        }
        student[count] = new Student(name, mark);
    }