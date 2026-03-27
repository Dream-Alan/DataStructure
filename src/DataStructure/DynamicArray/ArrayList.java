package DataStructure.DynamicArray;

import org.w3c.dom.Node;

@SuppressWarnings({"unused", "UnusedReturnValue", "StatementWithEmptyBody", "ManualArrayCopy"})
public class ArrayList<E> implements List<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int capacity){
        //noinspection ManualMinMaxCalculation
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
    public int indexOf(E element){
        if(element==null){
            for(int i=0;i<size;i++){
                if(elements[i]==null){
                    return i;
                }
            }
        }else{
            for(int index=0;index<size;index++) {
            if (element.equals(elements[index])) {
                return index;
            }
        }
        }
        return ELEMENT_NOT_FOUND;
    }
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }
    public E set(int index,E elements){
        rangeCheck(index);
        E old = this.elements[index];
        this.elements[index]=elements;
        return old;
    }

    public void add(E elements){
        add(size,elements);
    }
    public void add(int index,E elements){
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for(int i=size-1;i>=index;i--){
            this.elements[i+1]=this.elements[i];
        }
        this.elements[index]=elements;
        size++;
    }
    public E remove(int index){
        rangeCheck(index);
        for(int i=index+1;i<size;i++){
            elements[i-1]=elements[i];
        }
        elements[--size]=null;
        return elements[index];
    }
    public void remove(E elements){
        int index = indexOf(elements);
        if(index!=-1){
            remove(index);
        }
    }
    public void clear(){
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size=0;
    }
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
    }
    private void rangeCheck(int index){
        if(index<0||index>=size){
            outOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",").append(" [");
        for (int i=0;i<size;i++){
            if(i!=0){
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    private void ensureCapacity(int i) {
        int oldCapacity=elements.length;
        if(i>oldCapacity){
            int newCapacity = oldCapacity+(oldCapacity>>1);//>>1相当于除以2
            E[] newElements = (E[]) new Object[newCapacity];

            for(int j=0;j<size;j++){
                newElements[j]=elements[j];
            }
            elements=newElements;
            System.out.println(oldCapacity+"扩容为"+newCapacity);
        } else {
        }
    }
}
