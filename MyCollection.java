package mycollection;

public class MyCollection<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int index;

    MyCollection(){
        head = new ListNode<T>();
        tail = head;
        index = -1;
    }

    MyCollection(T newValue){
        this();
        add(newValue);
    }

    public void add(T newValue){
        if(newValue != null && index % 16 > 14){
            ListNode<T> newNode = new ListNode<>();
            index++;
            newNode.arr[index % 16] = newValue;
            tail.next = newNode;
            tail = newNode;
        }
        else if (newValue != null){
            index++;
            tail.arr[index % 16] = newValue;
        }
    }

    public T get(int otherIndex){
        int otherNodeIndex = otherIndex / 16;
        int otherArrIndex = otherIndex % 16;

        int currNodeIndex = index / 16;
        int currArrIndex = index % 16;

        if(otherIndex >= 0 && (currNodeIndex > otherNodeIndex || (currNodeIndex == otherNodeIndex && currArrIndex >= otherArrIndex))){
            ListNode<T> node = head;
            int counter = otherNodeIndex;
            while(counter != 0){
                node = node.next;
                counter--;
            }
            return node.arr[otherArrIndex];
        }
        return head.arr[0];
    }

    public T getHead(){
        return head.arr[0];
    }

    public int getSize(){
        return index + 1;
    }

    private class ListNode<T>{
        private T[] arr;
        private ListNode<T> next;

        ListNode(){
            arr = (T[]) new Object[16];
        }
    }
}
