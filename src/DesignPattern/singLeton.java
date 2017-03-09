package DesignPattern;

public class singLeton extends Thread{
	public void run(){
		System.out.println(singLeton2.getinstance().hashCode());
	}
	
	public static void main(String[] args) {
		singLeton[] sing = new singLeton[10];
		for (int i = 0; i < sing.length; i++) {
			sing[i] = new singLeton();
		}
		for (int i = 0; i < sing.length; i++) {
			sing[i].start();
		}
		
		
		
	}
	
	
	
}
//懒汉 线程安全(效率极低)
class singLeton2{
	private static singLeton2 instance;
	private singLeton2(){};
	//public static synchronized singLeton2 getinstance(){
	public static singLeton2 getinstance(){
		if( instance == null){
			//instance = new singLeton2();
			try {
				if(instance != null){//懒汉式   
				    
				}else{  
				    //创建实例之前可能会有一些准备性的耗时工作   
				    Thread.sleep(300);  
				    instance = new singLeton2();  
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		return instance;
	}
}

//懒汉 双重检验锁 （不是一直同步，
//           第一步，当对象不存在，进入同步； 第二步，同步之后，再检验是否存在；第三步，创建对象）
class singLetion3{
	private static volatile singLetion3 instance;
	private singLetion3(){};
	public static singLetion3 getinstance(){
		if(instance == null){
			synchronized (singLetion3.class) {
				if(instance == null){
					instance = new singLetion3();
				}
			}
			
		}
		return instance;
	}
}

//饿汉   ********
class singLeton4{
	private static singLeton4 instance = new singLeton4();
	private singLeton4(){};
	public static singLeton4 getinstance(){
		return instance;
	}
}

//静态内部类
class singLeton5{
	private static class singLeton5Holder{
		private static final singLeton5 instance = new singLeton5();
	}
	private singLeton5(){}
	public static final singLeton5 getinstance(){
		return singLeton5Holder.instance;
	}
}

//枚举类型
enum singLeton6{
	INSTANCE;
	private singLeton6(){}
}




