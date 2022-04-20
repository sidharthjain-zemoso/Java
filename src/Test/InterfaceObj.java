package Test;

interface TestInterface{
    abstract void m1();
    void m2();
    default void m3(){
        System.out.println("somethign");
    }
}

public class InterfaceObj {
    public static void main(String[] args) {
        // here we are not instantiating interface but rather we are just referencing to an object of some anonymous class.
        // only in this case we see something like "new interface()" syntax and always in such scenarios
        // we must define an anonymous class

        TestInterface obj = new TestInterface() {
            @Override
            public void m1() {

            }

            @Override
            public void m2() {

            }
        };
    }
}
