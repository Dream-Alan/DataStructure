package DataStructure.DynamicArray;

public class ArrayList<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int capacity){
        capacity= capacity<DEFAULT_CAPACITY?DEFAULT_CAPACITY:capacity;
        elements =(E[]) new Object[capacity];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean contains(E elements){
        return indexOf(elements)!=ELEMENT_NOT_FOUND;
    }
    public int indexOf(E elements){
        for(int index=0;index<size;index++) {
            if (elements.equals(this.elements[index])) {
                return index;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    public E get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }else {
            return elements[index];
        }
    }
    public E set(int index,E elements){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }else {
            E old = this.elements[index];
            this.elements[index]=elements;
            return old;
        }
    }

    public void add(int index,E elements){

    }
    public E remove(int index){
        return null;
    }
    public void clear(){
        size=0;
    }
}
