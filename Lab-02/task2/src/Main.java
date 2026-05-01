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

