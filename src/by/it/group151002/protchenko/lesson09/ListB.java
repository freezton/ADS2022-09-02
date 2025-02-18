package by.it.group151002.protchenko.lesson09;

import java.util.*;

public class ListB<T> implements List<T> {

    private final int INIT_SIZE = 10;
    private Object[] arr = new Object[INIT_SIZE];
    private int size = 0;


    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] newArray = new Object[size + c.size()];
        System.arraycopy(arr, 0, newArray, 0, size);
        arr = newArray;
        for (Object el : c)
            arr[size++] = el;
        return true;
    }


    @Override
    public void add(int index, T element) {
        Object[] temp = new Object[size+1];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
        for (int i = size; i > index; i--)
            arr[i] = arr[i - 1];
        arr[index] = element;
        size++;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size){
            Object[] temp = new Object[index+1];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
            arr[index] = element;
            return null;
        }
        T res = (T)arr[index];
        arr[index] = element;
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            sb.append(arr[i]);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        if (size == arr.length-1){
            Object[] temp = new Object[arr.length*2];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }
        arr[size] = t;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (arr[index] == null)
            return null;
        T res = (T)arr[index];
        System.arraycopy(arr, index + 1, arr, index, --size);
        return res;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (arr[i] == o) return i;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object b: arr){
            if (o == b)
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
