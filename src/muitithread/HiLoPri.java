package muitithread;

public class HiLoPri {

	public static void main(String[] args) {
		//���߳�Ϊ������ȼ�
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		//����hi��lo�ֱ�Ϊ7��3
        clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
        clicker lo = new clicker(Thread.NORM_PRIORITY - 2);
        lo.start();
        hi.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        //�Ⱥ�ֹͣ�����̣߳�Ȼ�����CPU
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
