//a
  /* push and pop never shifts elements.they only touch the top elements of the stack.
     so the size of the stack has no effect on the speed of push and pop as both operations
     take the same constant time(0(1)).
   */

//b
   /* no one objects count cannot interfere with the other's. because both has its own separtate
      copy of the private file named "count" stored in the memory. as private means the field belongs
      to that object only. it is not accessible to all the other classes. so it cannot interfere.
    */


public class StudentStack {
    private String[] names = new String[50];
    private int[] marks = new int[50];
    private int count=0;

    public void push(String names, int marks){
        if(count+1>50){
            System.out.println("Stack is Full");
        }
        this.names[count]=names;
        this.marks[count]=marks;
        count++;
    }

    public void pop(){
        if(count-1<0){
            System.out.println("Stack is empty");
        }
        System.out.println("Remove:" + this.names[count-1] + " " + this.marks[count-1] + "\n");
        count--;
    }

    public void peek(){
        if(count-1<0){
            System.out.println("Stack is empty");
        }
        System.out.println("Top:" + this.names[count-1] + " " + this.marks[count-1] + "\n");
    }

    public void display(){
        for(int i=0;i<5;i++){
            System.out.println(this.names[i] + ":" + this.marks[i]);
        }
    }
}

