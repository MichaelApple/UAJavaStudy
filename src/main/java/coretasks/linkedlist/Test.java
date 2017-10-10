package coretasks.linkedlist;

/**
 * Created by Miha on 09.10.2017.
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.put("1", 0);
        myLinkedList.put("2", 1);
        myLinkedList.put("3", 2);
        myLinkedList.put("4", 3);

        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(1));
        myLinkedList.delete(1);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.size());
    }
}
