/* a) push and pop never shift any elements. What does this mean for speed when the
stack has 50 students versus 5 students?

Ans:- Push and pop only affects on the top of a stack.So no elements are shifted.
 Their speed stays the same whether there are 50 or 5 students.

b. Your StudentStack and StudentQueue both have a private field called count (or
similar). If someone writes code that uses both classes at the same time, can one
object’s count interfere with the other’s? Why not?

Ans:- No, it is not going to interfere with one another's object count.
 It happens because count is in a private within the class that means each individual
 gets it's own separate memory.

 */

public class StudentStack {
    private String[] Name = new String[60];
    private double[] mark= new double[60];
    private int count = 0;

    public void push(String Name,double mark){
        if (count >= 60){
            System.out.println("Stack is full");
            return;
        }
        this.Name[count]=Name;
        this.mark[count]=mark;
        count++;
    }
    public void pop(){
        if (count == 0){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.Name[count-1]+" "+ this.mark[count-1]);
        count--;
    }
    public void peek(){
        if (count == 0){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.Name[count-1]+" "+ this.mark[count-1]);
    }
    public void display(){
        for (int i = 0; i < count; i++){
            System.out.println(this.Name[i] + " " + this.mark[i]);
        }
    }
}
