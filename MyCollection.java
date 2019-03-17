package mycollection;

public class MyCollection<T> {
    private ListNode<T> head;
    private ListNode<T> tail;

    MyCollection(){
        head = new ListNode<T>();
        tail = head;
    }

    MyCollection(T newValue){
        this();
        add(newValue);
    }

    public void add(T newValue){
        if(newValue != null && tail.arrIndex > 14){
            ListNode<T> newNode = new ListNode<>(newValue);
            tail.next = newNode;
            int newIndex = tail.nodeIndex + 1;
            tail = newNode;
            tail.nodeIndex = newIndex;
        }
        else if (newValue != null){
            tail.add(newValue);
        }
    }

    public T get(int index){
        int newNodeIndex = index / 16;
        int newArrIndex = index % 16;

        if(index >= 0 && (tail.nodeIndex > newNodeIndex || (tail.nodeIndex == newNodeIndex && tail.arrIndex >= newArrIndex))){
            ListNode<T> node = head;
            while(newNodeIndex != node.nodeIndex){
                node = node.next;
            }
            return node.arr[newArrIndex];
        }
        return head.arr[0];
    }

    public T getHead(){
        return head.arr[0];
    }

    private class ListNode<T>{
        private T[] arr;
        private int arrIndex;
        private int nodeIndex;
        private ListNode<T> next;

        ListNode(){
            arr = (T[]) new Object[16];
            arrIndex = -1;
            nodeIndex = 0;
            next = null;
        }

        ListNode(T newValue){
            this();
            arr[++arrIndex] = newValue;
        }

        private void add(T newValue){
            arr[++arrIndex] = newValue;
        }
    }
}

