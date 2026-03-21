package DataStructure.LinkedList;

public class LinkedList<E> extends AbstractList<E>{
    private int size;
    private Node head;

    @Override
    public void clear() {
        size = 0;
        head = null;
    }
    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node= getNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if(index==0){
            head = new Node<E>(element, head);
        }else {
            Node<E> pre = getNode(index - 1);
            pre.next = new Node<E>(element, pre.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            Node<E> oldHead = head;
            head = head.next;
            oldHead.next = null;
            size--;
            return oldHead.element;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = prev.next.next;
            getNode(index).next = null;
            size--;
            return getNode(index).element;
        }
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
    private Node<E> getNode(int index){
        rangeCheck(index);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element,Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
