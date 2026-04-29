
public class main2_2B {
    public static void main(String[] args){

        StudentQueue roster2 = new StudentQueue();

        roster2.enqueue("rey", 99);
        roster2.enqueue("miya", 78);
        roster2.enqueue("ted", 76);
        roster2.enqueue("beyhive", 56);
        roster2.enqueue("ryad", 100);
        System.out.println();

        roster2.front();
        System.out.println();

        roster2.dequeue();
        roster2.dequeue();
        roster2.dequeue();
        System.out.println();

        roster2.display();
        System.out.println();
    }
}
