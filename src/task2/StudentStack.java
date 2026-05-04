package task2;

public class StudentStack {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void push(String name, int marks)
    {
        if(count>=50)
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

    public void pop(){
        if(count==0){
            System.out.println("stack is empty");
            return;
        }
        count --;
        System.out.println("Popped: " + name[count] + " " + marks[count]);

    }

    public void peek(){
        if(count==0){
            System.out.println("stack is empty");
            return;
        }
        System.out.println("Top: " + this.name[count - 1] + " " + this.marks[count - 1]);

    }

    public void display(){
        for(int i=0; i<count; i++){
            System.out.println(this.name[i] + " " + this.marks[i]);

        }
    }
}
