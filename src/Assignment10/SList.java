package Assignment10;

import java.util.ArrayList;


public class SList<T> {
    private Node<T> head;
    int totalNodes;

    SList(){
        this.head = null;
        this.totalNodes = 0;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public SListIterator getIterator(){
        return new SListIterator(this);
    }

    public String toString(){
        String linkedlist = "";
        Node<T> current = this.head;
        while(current!=null){
            linkedlist += current.getVal() + "->";
            current = current.getNext();
        }
        linkedlist += "null";
        return linkedlist;
    }
}
