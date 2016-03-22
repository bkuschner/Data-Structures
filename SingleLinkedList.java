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
   private Link<T> head;
   private Link<T> tail;
   private int length;
   
   // Constructor(s)
   public SingleLinkedList() {
      head = null;
      tail = null;
      length = 0;
   }

   // Member methods

   public boolean isEmpty () {
      return head == null;
   }

   // Inserts a node at the front of the list.
   public void insertFront(final T data) {
      Link<T> newLink = new Link<T>(data);
      newLink.setNext(head);
      head = newLink;
      ++length;
      if(length == 1) tail = head;
   }

   // Inserts a node at the back of the list
   public void insertBack(final T data) {
      if (!isEmpty()) {
         tail.setNext(new Link<T>(data));
         tail = tail.getNext();
	  }
	  else {
         head = new Link<T>(data);
         tail = head;
      }
      ++length;
   }

   // Returns the amount of objects in the list.
   public int length() {
      return length;
   }

   // Removes the head node and returns the value stored in it.
   public T popFront() {
      T popped = head.getData();
      head = head.getNext();
      --length;
      return popped;
   }

   // Removes the tail node and returns the value stored in it.
   // O(n)
   public T popBack() {
      T popped = tail.getData();
      Link<T> location = head;
      while(location.getNext() != tail) {
         location = location.getNext();
      }
      tail = location;
      tail.setNext(null);
      --length;
      return popped;
      
   }

   // Prints the list in order.
   //O(n)
   public void printList() {
      Link<T> location = head;

      while(location != null) {
         System.out.println(location.getData());
         location = location.getNext();
      }
   }
   
   //Returns a new List in reverse
   //O(n)
   public SingleLinkedList<T> getReverse() {
      Link<T> location = head;
      SingleLinkedList<T> reverse = new SingleLinkedList<T>();
      for(int i = 0; i < length; ++i) {
         reverse.insertFront(location.getData());
         location = location.getNext();
      }
      return reverse;
   }
   
   private void printListReverseHelper(Link<T> node) {
      if (node != null) {
         printListReverseHelper(node.getNext());

         System.out.println(node.getData());
      }  
   }

   // Prints the list in reverse
   //O(n)
   public void printListReverse() {
      printListReverseHelper(head);
   }

   // Removes the head node in the list.
   public void removeFront() {
      head = head.getNext();
      --length;
   }

   // Removes the tail node in the list.
   public void removetail() {
      Link<T> location = head;
      while(location.getNext() != tail) { //this loop makes location the second to tail node
         location = location.getNext();
      }
      tail = location;
      tail.setNext(null);
      --length;
   }

} // end of class SingleLinkedList