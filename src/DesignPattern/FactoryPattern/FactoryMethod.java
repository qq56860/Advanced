package DesignPattern.FactoryPattern;

	/*
	 * 简单工厂模式:
	 * 1、工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。
	 * 2、抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。
	 * 3、具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。
	 * 
	 * 工厂方法模式：
	 * 1、抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。在java中它由抽象类或者接口来实现。 
	 * 2、具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。
	 * 3、抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
	 * 4、具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。
	 * 
	 * 工厂角色的结构也是符合开闭原则
	 * 
	 * 
	 * 工厂方法模式的核心是一个抽象类，而不像简单工厂模式把核心放在一个实体类上
	 * 工厂方法模式可以允许很多实的工厂类从抽象工厂类继承下来
	 * 
	 * 
	 * 抽象工厂:
	 * 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）
	 * 抽象工厂类中有多个产品
	 * 
	 * */


//抽象产品类
abstract class Car{
	public abstract void create();
}

//抽象工厂类
abstract class CarFactory{
	public abstract Car design();
}

//产品实现
class BWM extends Car{

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("宝马生产出来了");
	}
	
}

class Benz extends Car{

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("奔驰生产出来了");
	}
	
}

//工厂实现类

class BWMFactory extends CarFactory{

	@Override
	public Car design() {
		// TODO Auto-generated method stub
		return new BWM();
	}
	
}

class BenzFactory extends CarFactory{

	@Override
	public Car design() {
		// TODO Auto-generated method stub
		return new Benz();
	}
	
}



public class FactoryMethod {
	public static void main(String[] args) {
		CarFactory bwmFactory = new BWMFactory();
		BWM bwm = (BWM) bwmFactory.design();
		bwm.create();
	}
}






