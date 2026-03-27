package DataStructure.LinkedList;

public class LinkedList<E> extends AbstractList<E>{
    private Node head;
    private int size;

    @Override
    public void clear() {
        size = 0;
        head = null;
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

//    @Override
//    public void add(int index, E element) {
//        // 1. 检查索引范围
//        if (index < 0 || index > size) {
//            outOfBounds(index);
//        }
//
//        // 2. 处理空链表的情况
//        if (size == 0) {
//            head = new Node<E>(element, null);
//        } else {
//            // 3. 处理非空链表
//            if (index == 0) {
//                head = new Node<E>(element, head);
//            } else {
//                Node<E> pre = getNode(index - 1);
//                pre.next = new Node<E>(element, pre.next);
//            }
//        }
//        size++;
//    }
@Override
public void add(int index, E element) {
    /*
     * 最好：O(1)
     * 最坏：O(n)
     * 平均：O(n)
     */
    rangeCheckForAdd(index);
    if(index == 0){ // 给空链表添加第一个元素的情况
        head = new Node<>(element, head);
    }else{
        Node<E> prev = getNode(index - 1);
        prev.next = new Node<>(element, prev.next);
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
        if(element==null){
            Node<E> node=head;
            for(int i=0;i<size;i++){
                if(node.element==null){
                    return i;
                }
                node=node.next;
            }
        }else{
            Node<E> node=head;
            for(int index=0;index<size;index++) {
                if (element.equals(node.element)) {
                    return index;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
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

    @Override
    public String toString() {
        Node<E> node=head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",").append(" [");
        for (int i=0;i<size;i++){
            if(i!=0){
                stringBuilder.append(",");
            }
            stringBuilder.append(node.element);
            node=node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
