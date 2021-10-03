package database;
public interface Aggregate {
	
	public Iterator createIterator();
	public void add(Object item);
	
}
