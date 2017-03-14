package DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

	/*
	 * 观察者模式：一对多的依赖关系，让多个观察者对象同时监听某一个主题对象
	 * 主题对象在状态上发生变化时，会通知所有观察者对象，让它们能够自动更新自己
	 * 
	 * 推模型:主题对象向观察者推送主题的详细信息，不管观察者是否需要，推送的信息通常是主题对象的全部或部分数据
	 * 拉模型:题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取，相当于是观察者从主题对象中拉数据。
	 * 		一般这种模型的实现中，会把主题对象自身通过update()方法传递给观察者，这样在观察者需要获取数据的时候，就可以通过这个引用来获取了。
	 * 
	 * 抽象主题(Subject)角色：把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，每个主题都可以有任何数量的观察者。
	 * 					抽象主题提供一个接口，可以增加和删除观察者对象，抽象主题角色又叫做抽象被观察者(Observable)角色。
	 * 具体主题(ConcreteSubject)角色：将有关状态存入具体观察者对象；在具体主题的内部状态改变时，给所有登记过的观察者发出通知。
	 * 							具体主题角色又叫做具体被观察者(Concrete Observable)角色。
	 * 抽象观察者(Observer)角色：为所有的具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫做更新接口。
	 * 具体观察者(ConcreteObserver)角色：存储与主题的状态自恰的状态。具体观察者角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态互相协调。
	 * 								如果需要，具体观察者角色可以保持一个指向具体主题对象的引用。
	 * 
	 * */


abstract class Subject{
	private List<Observer> list = new ArrayList<Observer>();
	private int i;
	//添加观察者
	public void add(Observer observer){
		list.add(observer);
	}
	//删除观察者
	public void delete(Observer observer){
		list.remove(observer);
	}
	
	public void notifyObserver(String newState){
		for(Observer observer : list){
			System.out.println("通知第"+(++i)+"个观察者");
			observer.update(newState);
		}
	}
	
}

//推模式 具体主题类
class ConcreteSubject extends Subject{
	private String state;
	
	public String getState(){
		return state;
	}
	
	public void change(String newState){
		System.out.println("主题发生改变~~~");
		this.notifyObserver(newState);
	}
	
}


interface Observer{
	public void update(String state);
}
//推模式 具体观察者类
class ConcreteObserver implements Observer{
	
	private String state;
	
	public void update(String state) {
		// TODO Auto-generated method stub
		System.out.println("收到状态---"+state);
		this.state = state;
	}
	
}
//拉模式 具体主题类



//拉模式具体观察者类
class ConcreteObserver_pull implements Observer{
	
	private String state;
	
	public void update(String state) {
		// TODO Auto-generated method stub
		System.out.println("收到状态---"+state);
		this.state = Subject.
	}
	
}

public class ObserverTest {
	public static void main(String[] args) {
		ConcreteSubject sub1 = new ConcreteSubject();

		ConcreteObserver ob1 = new ConcreteObserver();
		ConcreteObserver ob2 = new ConcreteObserver();
		ConcreteObserver ob3 = new ConcreteObserver();
		
		sub1.add(ob1);
		sub1.add(ob2);
		sub1.add(ob3);
		
		sub1.change("1");
		
	}
}
