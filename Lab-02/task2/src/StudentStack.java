/*
What change to add and removeAt would turn StudentList into a stack?
Into a queue?
=>To turn StudentStack into a stack(LIFO), after adding at the end removal will also occur from the end.
=>To turn StudentStack into a queue(FIFO), after adding at the end removal will occur from the beginning.
 */
public class StudentStack {
    String[] names;
    int[] marks;
    int count;
//constructor-initialize
    StudentStack(String[] name, int[] mark){
        this.names = name;
        this.marks = mark;
        this.count = 0;
    }
public void push(String name, int mark){
        if(count==100){
            System.out.println("ERROR!!STACK IS FULL!!");
            return;
        }
        names[count] = name;
       marks[count] = mark;
        count++;
}
public void pop(){
        if(count==0){
            System.out.println("ERROR!! STACK IS EMPTY!!");
            return;
}
    System.out.println(names[count-1]+" "+marks[count-1]);
        count--;
    }
public void peek(){
    System.out.println(names[count-1]+" "+marks[count-1]);
}
public void display(){
        for(int i=0;i<count;i++) {
            System.out.println(names[i]+" "+marks[i]);
        }
}
}
