package Assignment6;

public class ArrayOfRefsDemo {
    ArrayOfRefsDemo(String name){
        System.out.println("Name:"+name);
    }

    public static void main(String[] args) {
        ArrayOfRefsDemo obj1;
        ArrayOfRefsDemo obj2;
//        ArrayOfRefsDemo[] arr = {obj1, obj2}; // obj1 and obj2 are not initialized
//        ArrayOfRefsDemo[] arr1;
        ArrayOfRefsDemo[] arr2 = {new ArrayOfRefsDemo("Sid")};
    }
}
