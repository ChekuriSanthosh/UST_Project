package multitreading;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;



public class PaytmOperation {
    public double balance;

    public PaytmOperation(double balance) {
        this.balance = balance;
//    System.out.println(Thread.currentThread().getName() + " - Wallet Balance: " + balance);
    }

    synchronized void addMoney(double amount) {
        balance += amount;
        notify();
        System.out.println(Thread.currentThread().getName() + " - Balance added " + amount + "       Total Balance " + balance);
    }

    synchronized void payBill(double amount) {
        Lock lock = new ReentrantLock();
        lock.lock();
        while (true) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " - Debited: " + amount + "        Total Balance: " + balance);
                System.out.println(Thread.currentThread().getName() + " - Bill paid successfully");
                break;
            } else if (amount > balance) {
                System.out.println(Thread.currentThread().getName() + " - Balance required to process the bill: Available Balance: " + balance);
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                notify();
                System.out.println(Thread.currentThread().getName() + " - Add balance of " + (amount - balance) + " to process the bill");

                Scanner scanner = new Scanner(System.in);
                System.out.println(Thread.currentThread().getName() + " - Enter amount to add: ");
                double res = scanner.nextDouble();
                addMoney(res);
            }
        }

        lock.unlock();
    }
}

class Wallet{
    public static void main(String[] args) throws InterruptedException {

        PaytmOperation paytm1=new PaytmOperation(100);
        PaytmOperation paytm2=new PaytmOperation(100);
//        paytm1.addMoney();


        Thread t1=new Thread(()->paytm1.payBill(400));
        Thread addMoney= new Thread(()->paytm1.addMoney(500));
//        Thread t2=new Thread(()->paytm2.payBill(80));
        t1.setName("paytm1");
//        t2.setName("paytm2");

        t1.start();
        t1.join();
        addMoney.start();
//        t2.start();

    }
}

