public class Main {
    public static void main(String[] args){
        StudentStack s1=new StudentStack();
        s1.push("Sabbir",80);
        s1.push("Sameer",89);
        s1.push("Tanvir",70);
        s1.push("Lamisa",99);
        s1.push("janina",10);
        s1.peek();
        s1.pop();
        s1.pop();
        s1.pop();
        s1.display();

        StudentQueue s2=new StudentQueue();
        s2.enqueue("Sabbir",80);
        s2.enqueue("Sameer",89);
        s2.enqueue("Tanvir",70);
        s2.enqueue("Lamisa",99);
        s2.enqueue("janina",10);
        s2.front();
        s2.dequeue();
        s2.dequeue();
        s2.dequeue();
        s2.display();


    }
}
