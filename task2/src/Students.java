  public class StudentStack {
     Students[] studentlist;
     int count = 0;

     public StudentStack() {
      this.studentlist=new Students[5];}

     public void push(String name,double mark){
         if(count<5){
             studentlist[count]=new Students(name,mark);
             count++;
         }
         else{
             System.out.println("Error!");
         }}
     public void pop(){
         if(count>0){
             count--;
             System.out.println("Popping at"+ studentlist[count]);
         }
         else{
             System.out.println("Stack is empty!");
         }}
         public void peek(){
             if(count>0) {
                 System.out.println("Top student at" + studentlist[count - 1]);
             }
         }
         public void display() {
             for (int i = 0; i < count; i++) {
                 System.out.println(studentlist[i]);
             }

         }
     public static void main(String args[]) {
         StudentStack stack = new StudentStack();
         Students student1 = new Students("Nishi", 98);
         Students student2 = new Students("Tanbir", 91.5);
         Students student3 = new Students("Mahdia", 97);
         Students student4 = new Students("Amina", 95.2);
         Students student5 = new Students("Lamisa", 88);
         stack.push(student1.name, student1.mark);
         stack.push(student2.name, student2.mark);
         stack.push(student3.name, student3.mark);
         stack.push(student4.name, student4.mark);
         stack.push(student5.name, student5.mark);
         stack.peek();
         stack.pop();
         stack.pop();
         stack.pop();
         stack.display();


     }

}
/* part--b*/
public class StudentQueue {
    Students[] studentlist;
    int count = 0;

    public StudentQueue() {
        this.studentlist=new Students[5];}

    public void enqueue(String name,double mark){
        if(count<5){
            studentlist[count]=new Students(name,mark);
            count++;
        }
        else{
            System.out.println("Error!");
        }}
    public void dequeue(){
        if(count>0){
            count--;
            System.out.println("Removed "+ studentlist[0]);
            for(int i=0;i<count-1;i++){
                studentlist[i]=studentlist[i+1];
            }studentlist[count-1]=null;count--;}
            else{
                System.out.println("Queue is empty!");
            }
        }

    public void front(){
        if(count>0) {
            System.out.println("Frontstudent at" + studentlist[0]);
        }
    }
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(studentlist[i]);
        }

    }
    public static void main(String args[]) {
        StudentQueue queue = new StudentQueue();
        queue.enqueue("Nishi",98);
        queue.enqueue("Tanbir",87);
        queue.enqueue("Amina",89);
        queue.enqueue("Mahdia",79);
        queue.enqueue("Lamisa",59);
        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();


    }

}

