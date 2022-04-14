package sidharth.assignment5.singleton;

public class Second {
    String nonStaticMember;
    public static Second someStaticMethod(String str){
        Second obj = new Second();
        obj.nonStaticMember = str;
        return obj;
    }
    public void printString(){
        System.out.println(nonStaticMember);
    }
}
