

public class StudentStack {
    private String[] name;
    private double[] marks;
    private int count;
    private int capacity;


    public StudentStack(int capacity){
        this.capacity = capacity;
        name = new String[capacity];
        marks = new double[capacity];
        count = 0;
    }
    public void  push(String name, double marks){
        if(count == capacity){
            System.out.println("Memory full");
            return;
        }
        else{
            this.name[count] = name;
            this.marks[count] = marks;
            count++;
        }


    }
    public void pop(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else {
            count--;
            System.out.println("Removed: " + name[count] + " - " + marks[count]);

        }

    }
    public void peek(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else {
            System.out.println("Top: " + name[count - 1] + " - " + marks[count - 1]);
        }
    }
    public void display(){
        if (count == 0){
            System.out.println("Stack Empty");
            return;
        }
        else{
            System.out.println("All data:");
            for(int i =0; i<count; i++){
                System.out.printf("%-10s ---> %6.2f\n", name[i], marks[i]);
            }
        }
    }
}
