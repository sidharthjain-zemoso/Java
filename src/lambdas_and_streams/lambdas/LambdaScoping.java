package lambdas_and_streams.lambdas;

class SuperClass{
    String member = "GOD FATHER";
}

interface Lambda{
    void lambdaFunc(String name);
}

// scope of lambda expressions is same as that of scope where it is enclosed or defined

public class LambdaScoping extends SuperClass{
    String member;

    LambdaScoping(String name){
        this.member = name;
    }

    void testMembers(String member){
//        member = "";
        System.out.println(super.member);
        System.out.println(this.member);
        System.out.println(member);

        // below is capturing lambda because it uses parameter (member) from it's enclosing scope
        Lambda func = (name) -> {
            System.out.println();
            System.out.println(super.member);
            System.out.println(this.member);
            System.out.println(member); // Variable used in lambda expression should be final or effectively final
            System.out.println(name);
            return;
        };
        func.lambdaFunc("Daugher");

        // other way:
        Lambda ref = new Lambda() {
            @Override
            public void lambdaFunc(String name) {
                System.out.println();
                System.out.println(LambdaScoping.super.member);
                System.out.println(LambdaScoping.this.member);
                System.out.println(member); // Variable 'member' is accessed from within inner class, needs to be final or effectively final
                System.out.println(name);
            }
        };
        ref.lambdaFunc("Daughter2");


    }

    public static void main(String[] args) {
        LambdaScoping obj = new LambdaScoping("Father");
        obj.testMembers("Son");
    }

}
