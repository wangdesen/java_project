package muitithread;

/**
 * 创建多线程demo
 * */
public class MultiThreadDemo {

	public static void main(String[] args) {
		new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");
        try {
        	// wait for other threads to end
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
	}

}
