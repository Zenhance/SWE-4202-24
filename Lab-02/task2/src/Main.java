class StackMain{
        static void main(String[] args) {
            StudentStack s=new StudentStack();
            s.push("Harry",95);
            s.push("Ron",88);
            s.push("Hermayni",92);
            s.push("Luna",87);
            s.push("Nolan",86);
            s.peek();
            s.pop();
            s.pop();
            s.pop();
            s.display();
        }
    }
class QueueMain{
    static void main(String[] args) {
       StudentQueue q=new StudentQueue();
        q.enqueue("Harry",95);
        q.enqueue("Ron",88);
        q.enqueue("Hermayni",92);
        q.enqueue("Luna",87);
        q.enqueue("Nolan",86);
        q.front();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();
    }
}
