package multitreading;

public class Main {
    public static void main(String[] args) {
        Runnable runnable= new MultithreadingWithRunnable();
        Thread downloader1=new Thread(runnable);

        Thread downloader2=new Thread(runnable);

//        MultiThreading task=new MultiThreading();
//        Thread downloader1=new Thread(()-> task.download());
//        Thread downloader2= new Thread(()->task.download());

        downloader1.setName("Downloader 1");
        downloader2.setName("Downloader 2");
        downloader2.setPriority(Thread.MAX_PRIORITY);
        downloader1.setPriority(Thread.MIN_PRIORITY);
        downloader1.start();
        downloader2.start();
    }
}
