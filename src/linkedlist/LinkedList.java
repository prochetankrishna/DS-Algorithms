package linkedlist;

public class LinkedList <T>{

    class LinkNode <T>{
        T data;
        LinkNode <T> next;

        public LinkNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    LinkNode <T> head;

    public LinkedList () {
        this.head = null;
    }

    public LinkNode <T> getHead () {
        return this.head;
    }

    public void insertAtBeginning (T data) {

        LinkNode <T> node = new LinkNode<>(data);
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }

    public void insertAtTheEnd (T data) {

        LinkNode <T> node = new LinkNode<>(data);
        if (this.head != null) {

            LinkNode <T> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        this.head = node;
    }

    public void printLinkedList () {

        LinkNode <T> temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
