import java.util.*;

public class ArrayList<T> implements List<T> {
    T[] a;
    int size;
    int pos;
    public ArrayList() { 
        a = (T[]) new Object [10];
    }
    
    public void add(T item) {
        if(size == a.length)
            growArray();
        a[size++] = item; //incrementing num of elements
    }
    
    public void add(int pos, T item){
        if(size == a.length)
            growArray(); //moves the elements
        for(int i =size-1; i>pos; i--) {      
            a[i+1] = a[i];
        }
        a[pos] = item;
        size++; //adds the element
    }
    
    public T get(int pos) {  
    //checks for index  
        if(pos >= size || pos < 0)
            return null;
        return a[pos];
    }
    
    public T remove(int pos) {     
        T temp = a[pos];
        //checks for index
        if(pos >= size || pos < 0 || size == 0)
            return null;
        for(int i = pos; i < size-1; i++) {
            //moves the elements
            a[i] = a[i+1];
        }
        //decrements
        size--;
        return temp;          
    }
    
    void growArray() {    
        T[] newArr = (T[]) new Object[a.length * 2];
        for(int i = 0; i < size; i++)
        {
            newArr[i] = a[i];
        }
        a = newArr;
    }
    public int size() {
        return size;
    }
}