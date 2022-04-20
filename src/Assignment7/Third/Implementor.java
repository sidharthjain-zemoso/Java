package Assignment7.Third;

public class Implementor extends ConcreteClass implements CombinedInterface{

    @Override
    public void newMethod() {
        System.out.println("New Method");
    }

    @Override
    public void commonMethod() {
        System.out.println("Common Method");
    }

    @Override
    public void three1() {
        System.out.println("Third interface First method");
    }

    @Override
    public void three2() {
        System.out.println("Third interface Second method");
    }

    @Override
    public void two1() {
        System.out.println("Second interface First method");
    }

    @Override
    public void two2() {
        System.out.println("Second interface Second method");
    }

    @Override
    public void one1() {
        System.out.println("First interface First method");
    }

    @Override
    public void one2() {
        System.out.println("First interface Second method");
    }

    void method1(FirstInterface fi){
        System.out.println("Method1: ");
        fi.one1();
        fi.one2();
        fi.commonMethod();
        System.out.println();
    }

    void method2(SecondInterface si){
        System.out.println("Method2: ");
        si.two1();
        si.two2();
        si.commonMethod();
        System.out.println();
    }

    void method3(ThirdInterface ti){
        System.out.println("Method3: ");
        ti.three1();
        ti.three2();
        ti.commonMethod();
        System.out.println();
    }

    void method4(CombinedInterface ci){
        System.out.println("CommonMethod: ");
        ci.newMethod();
        ci.one1();
        ci.two1();
        ci.three1();
        ci.commonMethod();
        System.out.println();
    }

    public static void main(String[] args) {
        Implementor obj = new Implementor();
        obj.method1(obj);
        obj.method2(obj);
        obj.method3(obj);
        obj.method4(obj);
    }
}
