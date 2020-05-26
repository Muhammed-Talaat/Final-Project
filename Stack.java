package PR;


public class Stack {
	private int size=0;
	private Node top=null;

    private class Node{
    	private Object elem=null;
    	private Node next=null;
    	private Node(Object element, Node Next) {
    		this.elem=element;this.next=Next;
    	}
    }
    
	public Object pop() {
		
		if(size==0) {throw new IllegalStateException("Stack is empty");}
		else {
			size--;
			Object temp=top.elem;
			top=top.next;
			return temp;
		}}


	public Object peek() {

		if(size==0) {throw new IllegalStateException("Stack is empty");}
		else {
			return top.elem;
		}
	}

	public void push(Object element) {
		if(size==0) {size++;top=new Node(element,null);}
		else {
			size++;Node u=new Node(element,top);
			top=u;
		}
	}
	
	public boolean isEmpty() {
		return(size==0);
	}

	public int size() {
		return this.size;
	}
}