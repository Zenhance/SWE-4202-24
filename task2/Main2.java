public class Main2 {
 public static void main(String[] args){

 String[] names=new String[500];
 double[] marks=new double[500];
  System.out.println("Student Stack:");
  StudentStack stack =new StudentStack(names,marks);
  stack.push("A",90);
  stack.push("B",95);
  stack.push("C",80);
  stack.push("D",85);
  stack.push("E",95);
  stack.peek();
  stack.pop();
  stack.pop();
  stack.pop();
  stack.display();


  System.out.println("Student Queue");
  StudentQueue queue=new StudentQueue(names,marks);
  queue.enqueue("A",90);
  queue.enqueue("B",95);
  queue.enqueue("C",80);
  queue.enqueue("D",85);
  queue.enqueue("E",95);
  queue.dequeue();
  queue.dequeue();
  queue.dequeue();

  queue.display();



 }
}


