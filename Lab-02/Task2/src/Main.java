//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentStack s1=new StudentStack();
        for (int i=0;i<9;i++){
            s1.push("Student"+i,50+i);
        }
        s1.peek();
        s1.pop();
        s1.pop();
        s1.display();
     StudentQueue q1=new StudentQueue();
     for (int i=0;i<9;i++){
         q1.enqueue("Student"+i,80+i);
     }
     q1.dequeue();
     q1.front();
     q1.display();

}
}