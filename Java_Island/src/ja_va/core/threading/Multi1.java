package ja_va.core.threading;

class Practice1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Thread Is Running . . . Thread Class");
    }
}
class Practice2 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Thread Is Running . . . Runnable Interface");
    }
}
public class Multi1 {
    public static void main(String[] args){
        new Practice1().start();
        new Thread(new Practice2()).start();
    }
}
class Thread1{
    public static void main(String[] args){
        Thread t = new Thread("Sample Thread");
        t.start();
        System.out.println(t.getName());

    }
}
class Thread2{
    public static void main(String args[]){
        Thread t = new Thread(new Practice2(),"Practice_2");
        t.start();
        System.out.println(t.getState());
        System.out.println(t.getName());
    }
}