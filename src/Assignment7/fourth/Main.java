package Assignment7.fourth;

import Assignment7.fourth.Cycles.Cycle;

public class Main {
    public static void main(String[] args) {
        UnicycleFactory unicycleFactory = new UnicycleFactory();
        Cycle unicycle = unicycleFactory.getInstance();
        unicycle.balance();
    }
}
