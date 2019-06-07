package Sample.AccessProblem;

public class AccessProblem {
    public static void main(String[] args) {
        ArrayObj obj = new ArrayObj();
        MyThread testThread = new MyThread("Первый поток", obj);
        System.out.println("Второй поток успешно создан");
        System.out.print("До выполнения: ");
        obj.print();
        testThread.changeArray();

        for(int i = 0; i < obj.array.length; ++i){
            try {
                Thread.sleep(500);
                obj.array[i]++;
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Второй поток прерывание!");
            }
        }

        try{
            testThread.t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("\nВторой поток завершён");
        System.out.print("После выполнения: ");
        obj.print();
    }
 }




