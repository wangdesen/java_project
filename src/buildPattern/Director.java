package buildPattern;

/**
 * 指挥者
 * 
 * 聚合抽象建造者，指挥建造者一步步组装产品
 * */
public class Director {
	
	private Builder builder;

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * 组装产品
	 * */
	public Product construct(){
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		
		return builder.getResult();
	}

}
