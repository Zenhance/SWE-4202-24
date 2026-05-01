public class Main {
    public static void main(String[] args){
        StudentStack ss=new StudentStack();
         for(int i=1;i<=5;i++){
             ss.push("Student" + i, i+50);
         }
         ss.peek();

         ss.pop();
         ss.pop();
         ss.pop();

         ss.display();


         StudentQueue sq=new StudentQueue();
         for(int i=1;i<=5;i++){
             sq.enqueue("Student" + i, i+50);
         }
         sq.front();

         sq.dequeue();
         sq.dequeue();
         sq.dequeue();

         sq.display();
    }
}
