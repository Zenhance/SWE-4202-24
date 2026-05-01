public class StudentStack {
    private int capacity;
    private Student[] list; //declaring the variable for the array.
    private int count;

    public StudentStack(int capacity){
        list=new Student[capacity]; //declaring the array
        count=-1;
    }

    public void push(Student s){
        if(count== capacity-1){
           System.out.println("Error, stack overflow");
        }
        count++;
        list[count]=s;
    }

    public void pop(Student s){
        if(count==-1){
            System.out.println("Error, stack underflow");
        }
        Student temp=list[count];
        System.out.println(temp);
        count--;
    }

    public void peek(Student s){
        if(count==-1){
            System.out.println("Error");
        }
        System.out.println(list[count]);
    }


    public void display(Student s){
        for(int i=0; i<count; i++){
            System.out.println(list[i]);
        }
    }

    // there are lots of mistakes here,i am trying again.

}
