//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("For Student Stack");
        StudentStack s1=new StudentStack();
        for (int i=1;i<5;i++){
            s1.push("Student"+i,50+i);
        }
        System.out.println("Peek");
        s1.peek();
        System.out.println("Pop");
        s1.pop();
        s1.pop();
        s1.pop();
        System.out.println("Display");
        s1.display();
        System.out.println("For Student Queue");
     StudentQueue q1=new StudentQueue();
     for (int i=1;i<5;i++){
         q1.enqueue("Student"+i,50+i);
     }
        System.out.println("Front");
     q1.front();
        System.out.println("Dequeue");
     q1.dequeue();
     q1.dequeue();
     q1.dequeue();
     System.out.println("Disply");
        q1.display();


}
}