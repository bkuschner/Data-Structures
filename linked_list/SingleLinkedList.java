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
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }

   // Returns the amount of objects in the list.
   public int length() {
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }
	
   // Removes the first node and returns the value stores in it.
   public T popFront() {
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }

   // Removes the last node and returns the value stores in it.
   public T popBack() {
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }

   // Prints the list in order.
   public void printList() {
      Link<T> currentNode = first;

      while(currentNode != null) {
         System.out.println(currentNode.getData());
         currentNode = currentNode.getNext();
      }
   }

   // Prints the list in reverse
   public void printListReverse() {
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }

   // Removes the first node in the list.
   public void removeFront() {
      first = first.getNext();
	}

   // Removes the last node in the list.
   public void removeLast() {
      throw new UnsupportedOperationException("Method not yet implemented, NYI.");
   }

} // end of class SingleLinkedList
