package proAndCon;

/**
 * 生产者-消费者问题-产品池
 * */
public class Q {
	/* int n;
    synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }
    synchronized void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }*/
    
    
    int n;
    boolean valueSet = false;//true标识生产完毕，false标识正在生产
    
    synchronized int get() {
        if(!valueSet){
        	try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        //消费完毕，唤醒
        notify();
        return n;
    }
    
    synchronized void put(int n) {
        if(valueSet){
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        //生产完毕，唤醒
        notify();
    }
}
