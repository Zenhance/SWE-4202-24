public class Main {
 public static void main(String[] args){
     StudentStack stack = new StudentStack();
     StudentQueue queue=new StudentQueue();


     stack.push("Farnaz",100);
     stack.push("Rahman",100);
     stack.push("abc",67);
     stack.push("def",67);
     stack.push("ghi",67);


     stack.peek();
     stack.pop();
     stack.pop();
     stack.pop();
     stack.display();



     queue.enqueue("A1",100);
     queue.enqueue("A2",90);
     queue.enqueue("A3",80);
     queue.enqueue("A4",70);
     queue.enqueue("A5",60);


     queue.front();
     queue.dequeue();
     queue.dequeue();
     queue.dequeue();
     queue.display();

 }
}
