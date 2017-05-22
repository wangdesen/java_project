package synchronization;

public class Callme {

	//同步call方法
	synchronized void call(String msg) {
		System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
       }
       System.out.println("]");
	}

}
