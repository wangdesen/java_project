package muitithread;

/**
 * 测试模拟线程优先级线程
 * */
public class clicker implements Runnable {

	int click = 0;
    Thread t;
    private volatile boolean running = true;
    public clicker(int p) {
        t = new Thread(this);
        t.setPriority(p);
    }

	@Override
	public void run() {
		while (running) {
            click++;
        }
	}

	public void stop() {
        running = false;
    }

    public void start() {
        t.start();
    }
}
