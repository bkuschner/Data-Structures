////////////////////////////////////////////////////////////////////////////////
// Author: Ben Kuschner
////////////////////////////////////////////////////////////////////////////////

public class SingleLinkedList<T> {
   
   /////////////////////////////////////////////////////////
   // Private link class
   /////////////////////////////////////////////////////////
   private class Link<T> {
      // Member Variables
      private T data;
      private Link<T> next;

      // Constructor(s)
      public Link (T data) {
         this.data = data;
         next = null;
      }
   
      // Member methods
      public T getData() {
         return this.data;
      }
      
      //deleted hasNext() method because I did not use it
   
      public Link<T> getNext() {
         return next;
      }

      public void setNext(Link<T> next) {
         this.next = next;
      }

   } // end of class link

   /////////////////////////////////////////////////////////
   // Single Linked List
   /////////////////////////////////////////////////////////

   // Member variables
   private Link<T> first;
   private Link<T> last;
   private int length;
   	
   // Constructor(s)
   public SingleLinkedList() {
      first = null;
      last = null;
      length = 0;
   }

   // Member methods
	
   public boolean isEmpty () {
      return first == null;
   }
	
   // Inserts a node at the front of the list.
   public void insertFront(final T data) {
      Link<T> newLink = new Link<T>(data);
      newLink.setNext(first);
      first = newLink;
      ++length;
      if(length == 1) last = first;
   }

   // Inserts a node at the back of the list
   public void insertBack(final T data) {
	  if (!isEmpty()) {
         last.setNext(new Link<T>(data));
         last = last.getNext();
	  }
	  else {
		  first = new Link<T>(data);
		  last = first;
	  }
	  ++length;
   }

   // Returns the amount of objects in the list.
   public int length() {
      return length;
   }
	
   // Removes the first node and returns the value stored in it.
   public T popFront() {
      T popped = first.getData();
      first = first.getNext();
      --length;
      return popped;
   }

   // Removes the last node and returns the value stored in it.
   // O(n)
   public T popBack() {
	   T popped = last.getData();
	   Link<T> location = first;
	   while(location.getNext() != last) {
		   location = location.getNext();
	   }
	   last = location;
	   last.setNext(null);
	   --length;
	   return popped;
	   
   }

   // Prints the list in order.
   //O(n)
   public void printList() {
      Link<T> location = first;

      while(location != null) {
         System.out.println(location.getData());
         location = location.getNext();
      }
   }
   
   //Returns a new List in reverse
   //O(n)
   public SingleLinkedList<T> getReverse() {
	   Link<T> location = first;
	   SingleLinkedList<T> reverse = new SingleLinkedList<T>();
	   for(int i = 0; i < length; ++i) {
		   reverse.insertFront(location.getData());
		   location = location.getNext();
	   }
	   return reverse;
   }

   // Prints the list in reverse
   //O(n)
   //I'm concerned that this method uses too much memory by creating a new list. Is there a better way to do this?
   public void printListReverse() {
	   getReverse().printList();
   }

   // Removes the first node in the list.
   public void removeFront() {
      first = first.getNext();
      --length;
   }

   // Removes the last node in the list.
   public void removeLast() {
      Link<T> location = first;
      while(location.getNext() != last) { //this loop makes location the second to last node
         location = location.getNext();
      }
      last = location;
      last.setNext(null);
      --length;
   }

} // end of class SingleLinkedList