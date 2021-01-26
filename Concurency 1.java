import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) throws InterruptedException {
        // This code demonstrates synchronization keyword usage
        // Other threads are blocked if one of the threads is working with the synchronized method/code block

        // Class without synchronization
        C C = new C();
        ExecutorService service = Executors.newFixedThreadPool(3);
        IntStream.range(0, 1000).forEach(count -> service.submit(C::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(C.getSum());

        // Class with synchronization on the calculate() method level
        C1 C1 = new C1();
        ExecutorService service1 = Executors.newFixedThreadPool(3);
        IntStream.range(0, 1000).forEach(count -> service1.submit(C1::calculate));
        service1.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(C1.getSum());

        // Class with synchronization on the block of code inside the method
        C2 C2 = new C2();
        ExecutorService service2 = Executors.newFixedThreadPool(3);
        IntStream.range(0, 1000).forEach(count -> service2.submit(C2::calculate));
        service2.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(C2.getSum());
    }
}

class C {
    private int sum = 0;
    public void calculate() {
        setSum(getSum() + 1);
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}

class C1 {
    private int sum = 0;
    public synchronized void calculate() {
        setSum(getSum() + 1);
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}

class C2 {
    private int sum = 0;
    public void calculate() {
        synchronized(this){
            setSum(getSum() + 1);
        }
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}