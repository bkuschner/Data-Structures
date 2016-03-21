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
      
      public boolean hasNext() {
    	  return next != null;
      }
   
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
	
   // Constructor(s)
   public SingleLinkedList() {
      first = null;
   }

   // Member methods
	
   public boolean isEmpty () {
      return first == null;
   }
	
   // Inserts a node at the front of the list.
   public void insertFront(T data) {
      Link<T> newLink = new Link<T>(data);

      newLink.setNext(first);
      first = newLink;
   }

   // Inserts a node at the back of the list
   public void insertBack(T data) {
      Link<T> last = first;
      while (last.hasNext()) { //sets last to the last node
    	  last = last.getNext();
      }
      last.setNext(new Link<T>(data));
   }

   // Returns the amount of objects in the list.
   public int length() {
      Link<T> location = first;
      int length = 0;
      while (location != null) {
         length++;
         location = location.getNext();
      }
      return length;
   }
	
   // Removes the first node and returns the value stores in it.
   public T popFront() {
      T popped = first.getData();
      first = first.getNext();
      return popped;
   }

   // Removes the last node and returns the value stores in it.
   public T popBack() {
	   Link<T> location = first;
	   while (location.getNext().hasNext()) {
		   location = location.getNext();
	   }
	   T popped = location.getNext().getData();
	   location.setNext(null);
	   return popped;
	   
   }

   // Prints the list in order.
   public void printList() {
      Link<T> location = first;

      while(location != null) {
         System.out.println(location.getData());
         location = location.getNext();
      }
   }

   // Prints the list in reverse
   public void printListReverse() {
	   int count = length() - 1;
	   Link<T> location;
	   while (count >= 0) {
		   location = first;
		   for(int i = 0; i < count; i++) {
			   location = location.getNext();
		   }
		   System.out.println(location.getData());
		   count--;
	   }
   }

   // Removes the first node in the list.
   //linear efficiency
   public void removeFront() {
      first = first.getNext();
	}

   // Removes the last node in the list.
   public void removeLast() {
      Link<T> location = first;
      while(location.getNext().hasNext()) { //this loop makes location the second to last node
         location = location.getNext();
      }
      location.setNext(null);
   }

} // end of class SingleLinkedList