package datastructures.hashtable.implementation;

public class HashTableDemo {
	public static void main(String[] args) {
		HashTable table = new HashTable();
		//Before Insertion
		System.out.println("Table Size = " + table.size());
		table.put("This",1 );
		table.put("is",2 );
		table.put("a",3 );
		table.put("Test",4 );
		table.put("Driver",5 );
		System.out.println("Table Size = " + table.size());
		// first search the key then delete it in the table
		System.out.println(table.remove("is") + " : This key is deleted from table");
		System.out.println("Now Size of the table = " + table.size());

		table.put("a", 6);
		System.out.println("The updated value of key 'a' is " + table.get("a"));
		System.out.println("Now Size of the table = " + table.size());

		if(table.isEmpty())
			System.out.println("Table is Empty");
		else
			System.out.println("Table is not Empty");
	}
}
