package buildPattern;

/**
 * 建造者模式测试
 * */
public class Test {

	public static void main(String[] args) {
		//具体建造者
		ConcreteBuilder builder = new ConcreteBuilder();
		//指挥者
		Director director = new Director();
		//将建造者的功能交给指挥者
		director.setBuilder(builder);
		//指挥者指挥建造
		Product pd = director.construct();
		//看看成品吧
		pd.show();
		
	}

}
