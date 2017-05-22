package proAndCon;

/**
 * ������-����������-��Ʒ��
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
    boolean valueSet = false;//true��ʶ������ϣ�false��ʶ��������
    
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
        //������ϣ�����
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
        //������ϣ�����
        notify();
    }
}
