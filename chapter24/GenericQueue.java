/* Author: Eden Demke
 * Date: 3/12/24
 * 
 * (Implement GenericQueue using inheritance) In Section 24.5,
 * GenericQueue is implemented using composition. This means 
 * that a LinkedList object is created inside of the class and 
 * then is used to access LinkedList's methods. 
 * 
 * Another way of creating GenericQueue is using inheritance. 
 * Instead of creating an instance of LinkedList in the object 
 * class, GenericQueue can extend LinkedList and access its 
 * methods that way.
 * 
 * Create a new GenericQueue class that uses inheritance. Create 
 * a test method that uses both the enqueue and dequeue methods 
 * and prints how the queue is affected.
 */

package assignments;

import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList<E> {
	
	public void enqueue(E e ) {
		addLast(e);
	}
	
	public E dequeue() {
		return removeFirst();
	}
	
	public int getSize() {
		return size();
	}
	
//	@Override
//	public String toString() {
//		return "Queue: " + this.toString();
//	}
	
	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>();
		
		queue.enqueue("Tom");
		System.out.println("1. " + queue);
		
		queue.enqueue("Susan");
		System.out.println("2. " + queue);
		
		queue.enqueue("Kim");
		queue.enqueue("Michael");
		queue.enqueue("Eden");
		System.out.println("3. " + queue);
		
		System.out.println("4. " + queue.dequeue());
		System.out.println("5. " + queue.dequeue());
		System.out.println("6. " + queue.dequeue());
		System.out.println("7. " + queue);
	}
}
