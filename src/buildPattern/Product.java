package buildPattern;

/**
 * 产品--可以有下列模块组合起来
 * */
public class Product {
	
	private String a;
	private String b;
	private String c;
	
	public void setA(String a) {
		this.a = a;
	}
	
	public void setB(String b) {
		this.b = b;
	}
	
	public void setC(String c) {
		this.c = c;
	}
	
	public void show(){
		System.out.println("product has" + a + b +c);
	}
}
