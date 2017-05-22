package buildPattern;

/**
 * 抽象建造者
 * */
public interface Builder {

	/**
	 * 加入A模块
	 * */
	public void buildPartA();
	
	/**
	 * 加入B模块
	 * */
	public void buildPartB();
	
	/**
	 * 加入C模块
	 * */
	public void buildPartC();
	
	/**
	 * 返回成品
	 * */
	public Product getResult();
}
