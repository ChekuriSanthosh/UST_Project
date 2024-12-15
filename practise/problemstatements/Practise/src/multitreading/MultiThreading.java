package multitreading;

public class MultiThreading{


    public void download(){
        for(int i=0;i<=100;i+=10){
            System.out.println("From "+Thread.currentThread().getName()+" Downloaded: "+i+"%");
//            try {
//                Thread.sleep(10);
//            }catch (InterruptedException ex){
//                System.err.println(ex.getMessage());
//            }
        }
        System.out.println("Download Complete");
    }
}
