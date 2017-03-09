package stack;

public interface MyStack<T> {
	
	
	
	boolean isEmpty();
	
	void clear();
	
	boolean push(T data);
	
	T pop();
	
	int length();
}
