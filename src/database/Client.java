package database;
public class Client {

    public static void main(String[] args) {
        
    	Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("item1");
        aggregate.add("item2");
        aggregate.add(1240);
 
        Iterator iterator = aggregate.createIterator();
        // STAMPA
        Object o;         
        while ( iterator.hasNext() ) {
        	o=iterator.next();
        	if( o instanceof String) {
        		System.out.println("Stringa: "+o);	
        	}
        	else if (o instanceof Integer){
				System.out.println("Intero: "+o);
			}
        	else {
				System.out.println("Tipo non definito");
			}

        }
      
        // System.out.println(iterator.next()); 
        //-> genera errore perchè il cursore si è spostato all'ultimo elemento
    
    }
 
}