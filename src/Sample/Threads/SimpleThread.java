package Sample.Threads;

public class SimpleThread implements Runnable {
    private String name;
    public Thread t;

    public SimpleThread(final String name){
        this.name = name;
        t = new Thread(this);
        System.out.println(name + " успешно создан");
        t.start();
    }

    @Override
    public void run(){
        for(int i = 10; i > 0; --i){
            try {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println(name + " " + "прерывание!");
            }
        }
        System.out.println(name + " " + "завершён");
    }

}
