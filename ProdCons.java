import java.util.LinkedList;
import java.util.Queue;

public class ProdCons{

    //lets take the capacity of queue to be 100
    private int capacity  = 100;
    Queue<Integer> data = new LinkedList<>();

    public void producer(){
        while(true){
            try {
                synchronized (data) {
                    while (data.size()==capacity){
                       data.wait();
                    }
                    data.add(1);
                    data.notifyAll();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void consumer(){
        while(true){
            try {
                synchronized (data) {
                    while (data.isEmpty()){
                       data.wait();
                    }
                    int consumingData = data.poll();
                    data.notifyAll();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ProdCons prodCons = new ProdCons();
        Thread producerThread = new Thread(()->{
            prodCons.producer();
        });
        Thread consumerThread = new Thread(()->{
            prodCons.consumer();
        });
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
