package proAndCon;

public class Pc {

	public static void main(String[] args) {
		//��ˮ��
		Q q = new Q();
		
        new Producer(q);
        new Consumer(q);
        
        System.out.println("Press Control-C to stop.");

	}

}
