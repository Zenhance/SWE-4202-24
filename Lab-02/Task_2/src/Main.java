public class Main{
    public static void main(String[] args){

        StudentStack s1=new StudentStack();

        s1.push("Alice", 90);
        s1.push("Bob", 92);

        s1.peek();
        s1.pop();

        s1.display();

        StudentQueue s2=new StudentQueue();

        s2.enqueue("Alice",90);
        s2.enqueue("Bob",92);

        s2.front();
        s2.dequeue();

        s2.display();
    }
}