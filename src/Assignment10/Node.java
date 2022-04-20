package Assignment10;

public class Node<T>{
    private T val;
    private Node<T> next;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    Node(T val){
        this(val, null);
    }

    Node(T val, Node next){
        this.val = val;
        this.next = next;
    }
}
