package buildPattern;

/**
 * 具体建造者
 * */
public class ConcreteBuilder implements Builder {

	//构建一个空的产品
	private Product p = new Product();
	
	@Override
	public void buildPartA() {
		p.setA("A-style");
	}

	@Override
	public void buildPartB() {
		p.setB("B-style");
	}

	@Override
	public void buildPartC() {
		p.setC("C-style");
	}

	@Override
	public Product getResult() {
		return p;
	}

}
