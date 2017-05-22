package proAndCon;

public class Pc {

	public static void main(String[] args) {
		//ÐîË®³Ø
		Q q = new Q();
		
        new Producer(q);
        new Consumer(q);
        
        System.out.println("Press Control-C to stop.");

	}

}
