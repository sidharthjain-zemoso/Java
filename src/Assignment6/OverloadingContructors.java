package Assignment6;

public class OverloadingContructors {
    String name;
    OverloadingContructors(){
        this("Default name");
        System.out.println("Default constructor");
    }

    OverloadingContructors(String name){
        this.name = name;
        System.out.println("Parametric constructor");
    }

    public static void main(String[] args) {
        OverloadingContructors obj = new OverloadingContructors();
        System.out.println(obj.name);
    }
}
