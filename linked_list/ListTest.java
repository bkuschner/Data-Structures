////////////////////////////////////////////////////////////////////////////////
// Author: Ben Kuschner
//
// Notes:
//
// Simple class to test the SingleLinkedList class.
//
////////////////////////////////////////////////////////////////////////////////

public class ListTest {

   public static void main (String[] args) {
      SingleLinkedList<String> myList = new SingleLinkedList<String>();
		
      myList.insertFront("Blastoff!");
      myList.insertFront("one");
      myList.insertFront("two");
      myList.insertFront("three");
      myList.insertFront("four");
      myList.insertFront("five");

      // Make sure the length is correct.
      assert myList.length() == 6;

      myList.printList();

      myList.insertBack("Hello");

      // Make sure popBack returns the correct value
      assert myList.popBack() == "Hello";

      // And removed correctly.
      assert myList.length() == 6;

      while (myList.length() > 0) {
         myList.removeFront();
      }

      // Test isEmpty
      assert myList.isEmpty();

      myList.insertFront("World");
      
      // Make sure popFront returns the correct value
      assert myList.popFront() == "World";

      // And removed correctly
      assert myList.isEmpty();

      myList.insertFront("World");
      myList.insertFront("Hello");

      myList.printListReverse();
   }

}
