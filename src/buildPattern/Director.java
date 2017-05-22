package buildPattern;

/**
 * ָ����
 * 
 * �ۺϳ������ߣ�ָ�ӽ�����һ������װ��Ʒ
 * */
public class Director {
	
	private Builder builder;

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * ��װ��Ʒ
	 * */
	public Product construct(){
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		
		return builder.getResult();
	}

}
