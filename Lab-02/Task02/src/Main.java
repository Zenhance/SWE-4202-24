public static void main(String[] args) {
    StudentStack stack = new StudentStack();
    StudentQueue queue = new StudentQueue();

    stack.push("Trump", 85);
    stack.push("Putin", 72);
    stack.push("Hasina", 94);
    stack.push("Modi", 68);
    stack.push("Marx", 79);

    stack.peek();

    stack.pop();
    stack.pop();
    stack.pop();

    stack.display();

    System.out.println("---New Class---");

    queue.enqueue("Trump", 85);
    queue.enqueue("Putin", 72);
    queue.enqueue("Hasina", 94);
    queue.enqueue("Modi", 68);
    queue.enqueue("Marx", 80);

    queue.front();

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    queue.display();
}
