package cn.wukai.designmode.strategypattern;

public class Test {

	public static void main(String[] args) {
		Duck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		modelDuck.swim();
		
		System.out.println("-------d动态改变d-------");
		
		modelDuck.setFlyBehavior(new FlyWithWings());
		modelDuck.setQuackBehavior(new Quack());
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		modelDuck.swim();
		
	}
	
}
