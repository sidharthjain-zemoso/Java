package Assignment10;

public class Main {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<>();
        SListIterator iterator = sList.getIterator();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.add(5);
        System.out.println(sList);
        iterator.add(4, 3);
        System.out.println(sList);
        iterator.delete(4);
        System.out.println(sList);
        iterator.deleteNode(2);
        System.out.println(sList);
    }
}
