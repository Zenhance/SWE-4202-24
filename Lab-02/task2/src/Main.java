public class Main{
    public static void main(String[] args){
        StudentStack s1=new StudentStack();

        s1.push("Rakib", 82);
        s1.push("Sakib", 80);
        s1.push("Rohan", 84);
        s1.peek();
        s1.pop();
        s1.display();


        StudentQueue s2=new StudentQueue();

        s2.enqueue("Disha",90);
        s2.enqueue("Toma",92);
        s2.enqueue("Mohua",82);
        s2.front();
        s2.dequeue();
        s2.display();
    }
}