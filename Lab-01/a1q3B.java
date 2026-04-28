public class a1q3B {
    public static void main(String[] args) {
        Counter one = new Counter();

        System.out.println(one.get());
        one.increment();
        System.out.println(one.get());
        one.reset();
        System.out.println(one.get());
    }
}


class Counter {
    private int value;
    Counter() {
        value = 0;
    }

    void increment() {
        value++;
    }

    void reset() {
        value = 0;
    }

    int get() {
        return value;
    }
}