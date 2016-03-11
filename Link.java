
public class Link {
	private Object data;
	private Link nextNode;
	
	public Link (Object data) {
		this.data = data;
		nextNode = null;
	}
	
	public Object getData () {
		return data;
	}
	
	public Link getNext() {
		return nextNode;
	}
	
	public void setNext(Link newNext) {
		nextNode = newNext;
	}
}
