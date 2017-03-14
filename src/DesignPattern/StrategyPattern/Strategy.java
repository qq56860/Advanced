package DesignPattern.StrategyPattern;

	/*
	 * 策略模式：
	 * 定义：把使用算法的责任和算法本身分割开来，委派给不同的对象管理。
	 * 通常把一个系列的算法包装到一系列的策略类里面，作为一个抽象策略类的子类。
	 * 用一句话来说，就是：“准备一组算法，并将每一个算法封装起来，使得它们可以互换”。
	 * 
	 * 环境(Context)角色：持有一个Strategy的引用。
	 * 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口
	 * 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为
	 * 
	 * 客户端自己选择调用哪个算法
	 * 
	 * */


interface MultStrategy {
	public void multiple();
}

class multiple1 implements MultStrategy{

	public void multiple() {
		// TODO Auto-generated method stub
		System.out.println("不加倍");
	}
	
}
class multiple2 implements MultStrategy{

	public void multiple() {
		// TODO Auto-generated method stub
		System.out.println("双倍");
	}
	
}
class multiple3 implements MultStrategy{

	public void multiple() {
		// TODO Auto-generated method stub
		System.out.println("三倍");
	}
	
}

class Context{
	private MultStrategy strategy; 
	
	public Context(MultStrategy strategy){
		this.strategy = strategy;
	}
	
	public void contextMultiple(){
		strategy.multiple();
	}
	
}

class Strategy{
	public static void main(String[] args) {
		MultStrategy strategy = new multiple2();
		Context  context = new Context(strategy);
		context.contextMultiple();
	}
}

