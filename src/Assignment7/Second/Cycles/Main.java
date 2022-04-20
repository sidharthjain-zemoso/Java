package Assignment7.Second.Cycles;

public class Main {
    public static void main(String[] args) {
        Cycle unicycle = new Unicycle();
        Cycle bicycle = new Bicycle();
        Cycle tricycle = new Tricycle();
        System.out.println("Up Cast:");
        Cycle[] cycles = {unicycle, bicycle, tricycle};
        for(Cycle cycle: cycles){
            cycle.balance();
            cycle.specificToCycle();
        }
        System.out.println("Down Cast:");
        Unicycle unicycle2 = (Unicycle) unicycle;
        Bicycle bicycle2 = (Bicycle) bicycle;
        Tricycle tricycle2 = (Tricycle) tricycle;

        unicycle2.balance();
        unicycle2.specificToCycle();
        unicycle2.specificToDerived();
        bicycle2.balance();
        bicycle2.specificToCycle();
        bicycle2.specificToDerived();
        tricycle2.balance();
        tricycle2.specificToCycle();
        tricycle2.specificToDerived();
    }
}
