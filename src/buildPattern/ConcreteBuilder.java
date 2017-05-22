package buildPattern;

/**
 * ���彨����
 * */
public class ConcreteBuilder implements Builder {

	//����һ���յĲ�Ʒ
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
