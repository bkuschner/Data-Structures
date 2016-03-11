
public class LinkedList {
	private Link first;
	
	public LinkedList () {
		first = null;
	}
	
	public boolean isEmpty () {
		return (first == null);
	}
	
	public void insert (Object data) {
		Link newLink = new Link(data);
		newLink.setNext(first);
		first = newLink;
	}
	
	public void delete () {
		first = first.getNext();
	}
	
	public void printList () {
		Link currentNode = first;
		while(currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}
