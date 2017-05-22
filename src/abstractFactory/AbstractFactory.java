package abstractFactory;

/**
 * 抽象工厂
 * */
public interface AbstractFactory {

	/**
	 * 负责生产A
	 * */
	public AbstractProductA createProductA();
	
	/**
	 * 负责生产B
	 * */
	public AbstractProductB createProductB();
}
