package database;
import java.util.ArrayList;
 
public class ConcreteIterator implements Iterator {
 
    private ArrayList<Object> arrayList;
    private int current = -1;
 
    public ConcreteIterator( ArrayList<Object> arrayList ) {
        this.arrayList = arrayList;
    }
 
    @Override
    public Object next() {
        current++;
        return (Object) arrayList.get(current);
    }
 
    @Override
    public boolean hasNext() {
        return (current+1) < arrayList.size();
    }
 
}