package Assignment10;

public class SListIterator<T> {
    private Node head;
    private SList customList;

    SListIterator(SList<T> list){
        this.head = list.getHead();
        this.customList = list;
    }

    public void add(T val){
        Node<T> node = new Node<T>(val);
        add(val, this.customList.totalNodes);
        customList.setHead(this.head);
    }

    public void add(T val, int index){
        Node<T> node = new Node<T>(val);
        Node<T> current = this.head;
        int count = 0;
        // need to check if index is in range
        if(index>this.customList.totalNodes){
            System.out.println("Index is out of bounds");
            return;
        }

        if(head==null){
            this.head = node;
        }else{
            if(index==0){
                node.setNext(this.head);
                this.head = node;
            }else{
                while(count<index-1){
                    current = current.getNext();
                    count++;
                }
                node.setNext(current.getNext());
                current.setNext(node);
            }
        }
        this.customList.totalNodes++;
        customList.setHead(this.head);
    }

    public void delete(int index){
        Node<T> current = this.head;
        Node<T> nodeToDelete = null;
        int count = 0;
        // need to check if index is in range
        if(index>this.customList.totalNodes){
            System.out.println("Index is out of bounds");
            return;
        }
        while(count<index-1){
            current = current.getNext();
            count++;
        }
        if(index==0){
            this.head = current.getNext();
            current.setNext(null);
        }else {
            nodeToDelete = current.getNext();
            current.setNext(nodeToDelete.getNext());
            nodeToDelete.setNext(null);
        }
        this.customList.totalNodes--;
        customList.setHead(this.head);
    }

    public void deleteNode(T val){
        Node<T> current = this.head;
        Node<T> prev = null;
        while(current!=null && current.getVal()!=val){
            prev = current;
            current = current.getNext();
        }
        if(current==null){
            System.out.println("No such node");
            return;
        }
        if(prev==null){
            prev = current;
            this.head = current.getNext();
            prev.setNext(null);
        }else {
            prev.setNext(current.getNext());
            current.setNext(null);
        }
        this.customList.totalNodes--;
        customList.setHead(this.head);
    }

    public int size(){
        return this.customList.totalNodes;
    }

    public boolean isEmpty(){
        return this.customList.totalNodes==0;
    }

}
