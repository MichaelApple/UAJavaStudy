package coretasks.linkedlist;

import arraylistimpl.MyArrayList;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Miha on 09.10.2017.
 */
public class MyLinkedList {
    private int size;
    private Node head;

    public MyLinkedList() {
    }

    public Object get(int index){
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
        return current;

    }

    public void put(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }

        temp.setNext(current.getNext());

        // now set this node's next-node reference to the new node
        current.setNext(temp);
        size++;
    }

    public boolean delete(int index) {
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    public int indexOf(Object obj) {
        int result = 0;
        Node temp = new Node(obj);

        for (int i = 0; i < size(); i++) {
            if (temp.equals(get(i)))
                return i;
        }

        return result;
    }

    public int size() {
        return size;
    }

    private class Node {
        // reference to the next node in the chain, or null if there isn't one.
        Node next;

        // data carried by this node. could be of any type you need.
        Object data;

        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        @SuppressWarnings("unused")
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }
}
