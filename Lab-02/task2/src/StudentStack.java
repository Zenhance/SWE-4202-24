/*
a)as push and pop dont shift elements,
  speed will remain same for 50 students vs 5 students
b)It will not interfere, as I have used both in my main function.
  one object's count cannot interfere with another object's count.
  because each object has its own separate fields in memory.
 */

public class StudentStack {
    private String[] names;
    private int[] marks;
    private int count;
    public StudentStack(int size) {
        names = new String[size];
        marks = new int[size];
        count = 0;
    }
    public void push(String name, int mark) {
        if(count == names.length){
            System.out.println("Stack is full");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }
    public void pop() {
        if(count == 0){
            System.out.println("Stack is empty");
            return ;
        }
        System.out.println("Removed:"+names[count-1]
        +" "+marks[count-1]);
        count--;
    }
    public void peek() {
        System.out.println("Top:"+names[count-1]
        +" "+marks[count-1]);
    }
    public void display() {
        for(int i=0;i<count;i++){
            System.out.print(names[i]+" "+marks[i]);
        }
    }

}
