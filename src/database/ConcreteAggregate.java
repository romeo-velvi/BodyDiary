package database;
import java.util.ArrayList;
 
public class ConcreteAggregate implements Aggregate {
 
    private ArrayList<Object> arrayList;
 
    public ConcreteAggregate() {
        arrayList = new ArrayList<Object>();
    }
 
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator( arrayList );
    }
 
    @Override
    public void add(Object item) {
        arrayList.add( item );
    }
 
}