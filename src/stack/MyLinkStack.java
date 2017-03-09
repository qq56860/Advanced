package stack;

public class MyLinkStack<T> implements MyStack<T> {
	
	private final class Node{
		private Node pre;
		private T data;
	}
	
	private Node top;
	private int size;
	
	public MyLinkStack(){
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size ==0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		top = null;
		size = 0;
	}

	public boolean push(T data) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data = data;
		node.pre = top;
		top = node;
		size++;
		return true;
	}

	public T pop() {
		// TODO Auto-generated method stub
		if(top != null){
			Node node = top;
			top = top.pre;
			size--;
			return node.data;
		}
		return null;
	}

	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

}
