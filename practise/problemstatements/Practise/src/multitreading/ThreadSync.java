package multitreading;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ThreadSync {
    Lock lock=new ReentrantLock();
    public void printscores(String player, List<Integer> scores){
        lock.lock();
        System.out.println("Scores of "+player);
        scores.forEach(i-> System.out.println(i));
        lock.unlock();
    }

    public static void main(String[] args) {
        ThreadSync ts=new ThreadSync();
        List<Integer> sachinScore=List.of(85,28,44,61,30);
        List<Integer> viratScores=List.of(97,21,15,88,3);
        Thread t1=new Thread(()->ts.printscores("Sachin",sachinScore));
        Thread t2=new Thread(()->ts.printscores("Kohli",viratScores));

        t1.start();
        t2.start();

    }
}
