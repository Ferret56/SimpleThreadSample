package Sample.AccessProblem;

public class MyThread implements Runnable {
    private String name;
    private ArrayObj obj;
    public Thread t;

    public MyThread(final String name, ArrayObj obj){
        this.name = name;
        this.obj = obj;
        t = new Thread(this);
        System.out.println(name + " успешно создан");
    }

    public void changeArray(){
        t.start();
    }


    @Override
    public void run(){
        for(int i = 0; i < obj.array.length; ++i){
            try {
                Thread.sleep(1000);
                obj.array[i]++;
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println(name + " " + "прерывание!");
            }
        }
        System.out.println("\n" + name + " " + "завершён");
    }
}
