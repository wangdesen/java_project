package buildPattern;

/**
 * ��������
 * */
public interface Builder {

	/**
	 * ����Aģ��
	 * */
	public void buildPartA();
	
	/**
	 * ����Bģ��
	 * */
	public void buildPartB();
	
	/**
	 * ����Cģ��
	 * */
	public void buildPartC();
	
	/**
	 * ���س�Ʒ
	 * */
	public Product getResult();
}
