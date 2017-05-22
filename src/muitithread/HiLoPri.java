package muitithread;

public class HiLoPri {

	public static void main(String[] args) {
		//主线程为最高优先级
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		//设置hi和lo分别为7和3
        clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
        clicker lo = new clicker(Thread.NORM_PRIORITY - 2);
        lo.start();
        hi.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        //先后停止两个线程，然后分配CPU
        lo.stop();
        hi.stop();
        try {
            hi.t.join();
            lo.t.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Low-priority thread: " + lo.click);
        System.out.println("High-priority thread: " + hi.click);
	}

}
