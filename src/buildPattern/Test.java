package buildPattern;

/**
 * ������ģʽ����
 * */
public class Test {

	public static void main(String[] args) {
		//���彨����
		ConcreteBuilder builder = new ConcreteBuilder();
		//ָ����
		Director director = new Director();
		//�������ߵĹ��ܽ���ָ����
		director.setBuilder(builder);
		//ָ����ָ�ӽ���
		Product pd = director.construct();
		//������Ʒ��
		pd.show();
		
	}

}
