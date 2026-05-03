import java.sql.SQLOutput;

public class StudentStack {
    String[] name = new String[1000];
    float[] mark = new float[1000];
    int students=1000;
    int count=0;

    public void push(String[] name, float[] mark) {
        if(count==students) {
            System.out.println("The Stack is full");
        }

        this.name = name;
        this.mark =mark;
        count++;
    }

    public void pop() {
        if(count == 0) {
            System.out.println("The stack is empty");
        }

        count--;
        System.out.println(name[count]);
        System.out.println(mark[count]);
    }

    public void peek() {
        System.out.println("Top student's info: "+"name"+name[count]+" "+"Marks"+mark[count] );
    }

    public void display() {
        for(int i=0;i<name.length;i++) {
            System.out.println("NAME: "+name[i]+" and MARKS: "+mark[i]);
        }
    }

}