package stack;

public class MyArrayStack<T> implements MyStack<T> {
	
	private Object[] obj = new Object[16];
	private int size = 0;
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			obj[i] = null ;
		}
		size = 0;
	}

	public boolean push(T data) {
		// TODO Auto-generated method stub
		if(size < obj.length){
			resize();
		}
		obj[size++]=data;
		return true;
	}
	
	private void resize(){
		Object temp[] = new Object[obj.length*3/2+1];
		for (int i = 0; i < obj.length; i++) {
			temp[i] = temp[i];
			
		}
		obj = temp;
	}
	
	public T pop() {
		// TODO Auto-generated method stub
		if(size == 0){
			return null;
		}
		return (T)obj[--size];
	}

	public int length() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String tostring(){
		StringBuffer sb = new StringBuffer();
		sb.append("MyArrayStack: [");
		for (int i = 0; i < size; i++) {
			sb.append(obj[i]);
			if(i!=size-1){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
