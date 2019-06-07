package Sample;
import Sample.Threads.SimpleThread;

public class ThreadSample {
    public static void main(String[] args) {
        SimpleThread testThread = new SimpleThread("Первый поток");
        System.out.println("Второй поток успешно создан");

        for(int i = 0; i < 10; ++i){
            try {
                System.out.println("Второй поток: " + i);
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Второй поток прерывание!");
            }
        }
        try {
            testThread.t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Второй поток завершён");
    }


}
