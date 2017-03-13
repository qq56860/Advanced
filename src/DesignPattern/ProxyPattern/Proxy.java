package DesignPattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

	/*
	 * 代理模式：通俗的讲，一个人要租房子，但对当地不熟悉，所以要找中介作代理。
	 * 
	 * 静态代理：一个委托类对应一个代理类，代理类在编译期间就已经确定
	 * 
	 * jdk动态代理：代理类在运行时期生成，运用反射机制动态创建而成(invoke方法)
	 * jdk动态代理使用的局限性：
	 * 通过反射类Proxy和InvocationHandler回调接口实现的jdk动态代理，要求委托类必须实现一个接口，但事实上并不是所有类都有接口，对于没有实现接口的类，便无法使用该方方式实现动态代理。
	 * 
	 * 
	 * Cglib动态代理：对代理那些没有实现接口的类非常有用
	 * 通过动态的生成一个子类去覆盖所要代理类的不是final的方法，并设置好callback，则原有类的每个方法调用就会转变成调用用户定义的拦截方法（interceptors），这比JDK动态代理方法快多了。
	 * 可见，Cglib的原理是对指定的目标类动态生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类和final方法进行代理。
	 * 
	 * 
	 * RealSubject 是委托类，Proxy 是代理类
	 * Subject 是委托类和代理类的接口
	 * 
	 * */

//静态代理
interface Subject{
	
	void rent();
	
}

class RealSubject implements Subject{

	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("租房子");
	}
	
}

class lianjiaProxy implements Subject{
	
	private Subject sub;
	
	public lianjiaProxy(Subject sub){
		this.sub = sub;
	}
	
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("链家帮忙");
		sub.rent();
	}
	
}

//动态代理：jdk动态代理
class myInvocationHandler implements InvocationHandler{
	
	private Object obj;
	
	public myInvocationHandler(Object obj){
		this.obj = obj;
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("代理前~做点什么");
		Object result = method.invoke(obj, args);//args 方法数组
		System.out.println("代理后~做什么");
		return result;
	}
	
	//生成动态代理类对象
	public Object getProxy(){
		ClassLoader load = Thread.currentThread().getContextClassLoader();
		Class[] interfaces = obj.getClass().getInterfaces();
		
		return java.lang.reflect.Proxy.newProxyInstance(load, interfaces, this);
	}
	
}

//cglib动态代理：代理类不必要实现接口

class cglibSubject{
	public void rent(){
		System.out.println("cglib租房子");
	}
}

class cglibProxy implements MethodInterceptor{
	
	private Object obj;
	
	public cglibProxy(Object obj){
		this.obj = obj;
	}
	
	public Object creatProxy(){
		Enhancer en = new Enhancer();
		en.setSuperclass(this.obj.getClass());// 设置要代理的目标类，以扩展它的功能
		en.setCallback(this);// 设置单一回调对象，在回调中拦截对目标方法的调用
		en.setClassLoader(obj.getClass().getClassLoader());//设置类装载器 
		
		return en.create();//返回代理对象
		
	}
	
	
	public Object intercept(Object obj, Method method, Object[] arg0,
			MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("代理前~做点什么");
		
		Object result = methodProxy.invokeSuper(obj, arg0);
		
		System.out.println("代理后~做点什么");
		
		return result;
	}
	
	
	
}


public class Proxy {
	public static void main(String[] args) {
//		//静态代理
//		Subject sub = new RealSubject();
//		lianjiaProxy lianjia = new lianjiaProxy(sub);
//		lianjia.rent();
		
//		//jdk动态代理
//		Subject sub = new RealSubject();
//		myInvocationHandler my = new myInvocationHandler(sub);
//		Subject lianjia = (Subject) my.getProxy();
//		lianjia.rent();
		
		//cglib动态代理
		cglibSubject cglib = new cglibSubject();
		cglibProxy cg = new cglibProxy(cglib);
		cglibSubject cgProxy = (cglibSubject) cg.creatProxy();
		cgProxy.rent();
	}
}
