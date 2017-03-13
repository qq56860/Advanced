package DesignPattern.AdapterPattern;
	/*
	 * 适配器模式：
	 * 把一个类的接口变换成所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
	 * 目标(Target)角色、源(Adapee)角色、适配器(Adaper)角色
	 * 
	 * 有两种形式：类适配器模式、对象适配器模式
	 * 
	 * 类适配器模式：实现接口继承抽象类方式、可以重定义Adaptee的部分行为
	 * 对象适配器模式：引用对象得到Adaptee、动态组合
	 * 
	 * 缺点：比如明明看到调用的是A接口，其实内部被适配成了B接口的实现
	 * 
	 * 
	 * adp项目很好的应用了适配器模式，一套软件系统，有多个厂家需要连接，而每个厂家的设备又有差异。
	 * 不仅能对差异性作适配，而且还能分担服务器压力。
	 * 
	 * */

//对象适配器模式

//目标接口希望有 跑 和 吃 两个行为
interface Target{
	public void run();
	
	public void eat();
}

//但是源接口只有跑的行为
class Adaptee{
	
	public void run(){
		System.err.println("跑起来");
	}
}

//在adp中增加吃的行为
public class Adapter {
	private Adaptee adp;
	public Adapter(Adaptee adp){
		this.adp = adp;
	}
	
	public void run(){
		this.run();
	}
	
	public void eat(){
		System.out.println("吃两顿饭");
	}
	
}

