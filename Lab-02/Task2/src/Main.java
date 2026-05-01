//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("For Student Stack");
        StudentStack s1=new StudentStack();
        for (int i=1;i<9;i++){
            s1.push("Student"+i,50+i);
        }
        s1.peek();
        s1.pop();
        s1.pop();
        s1.display();
        System.out.println("For Student Queue");
     StudentQueue q1=new StudentQueue();
     for (int i=1;i<9;i++){
         q1.enqueue("Student"+i,50+i);
     }
     q1.dequeue();
     q1.front();
     q1.display();

}
}