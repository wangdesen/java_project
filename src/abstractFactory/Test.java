package abstractFactory;

/**
 * 抽象工厂模式测试类
 * */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractFactory fc = new ConcreteFactory1();
		AbstractProductA pa1 = fc.createProductA();
		AbstractProductB pb1 = fc.createProductB();
		pa1.eat();
		pb1.use();
		
		AbstractFactory fc2 = new ConcreteFactory2();
		AbstractProductA pa2 = fc2.createProductA();
		AbstractProductB pb2 = fc2.createProductB();
		pa2.eat();
		pb2.use();
		
	}

}
