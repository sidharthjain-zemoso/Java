package core_java.String;

public class StringBuilderFun {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sidharth");
        System.out.println(sb);
        sb.insert(8, " ");
        System.out.println(sb);
        sb.append("Jain!!");
        System.out.println(sb);
        sb.replace(9, 13, "is a Jain"); //end is exclusive. here "Jain" is replaced with "is a Jain"
        System.out.println(sb);
        sb.delete(9, 14); // end is exclusive. Here 5 characters "is a " are deleted
        System.out.println(sb);

        sb.insert(0, "Intern ");
        System.out.println(sb);
    }
}
