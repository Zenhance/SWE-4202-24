public class Main
{
    public static void main(String[] args)
    {
        StudentStack stack=new StudentStack();

        stack.push("Zunied",90);
        stack.push("Raiyan",80);
        stack.push("Rusafi",75);
        stack.push("Tajwar",97);
        stack.push("Tanvir",86);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        StudentQueue queue=new StudentQueue();

        queue.enqueue("Zunied",90);
        queue.enqueue("Raiyan",80);
        queue.enqueue("Rusafi",75);
        queue.enqueue("Tajwar",97);
        queue.enqueue("Tanvir",86);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
//StudentStack
//
//a. Push and Pop do not shift elements. Therefore, the speed remains the same for each cases that means whether there are 5 students or 50 students the speed remains same.
//
//b. If someone writes code using both classes at same time, there will be no interfere with another because each object has separate memory. 'count' variable is private and it belongs to each of them independently.
//
//StudentQueue
//
//a. Every time dequeue shifts remaining all elements to the left. For 50 students and 45 dequeues, the individual element moves required in total is roughly 1000.
//
//
//b. We make the array private so that the outside code can not directly modify it. Because of this different classes use same internal structure safely.