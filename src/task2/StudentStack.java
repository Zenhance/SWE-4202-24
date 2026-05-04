package task2;

public class StudentStack {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void push(String name, int marks)
    {
        if(count+1>50)
        {
            System.out.println("stack already full");
            return;
        }
        else {
            this.name[count] =name;
            this.marks[count] =marks;
            count++;
        }
    }
}
