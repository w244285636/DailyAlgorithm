package cn.wukai.designmode.strategypattern;

public class ModelDuck extends Duck {

	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I am a model duck");
	}

	
	
}
