import Loosecoupling.AirtelSim;
import Loosecoupling.JioSim;
import Loosecoupling.Phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        System.out.println("Enter the sim type: "+ '\n'+"1. Airtel"+'\n'+"2. Jio");
//        int res=scan.nextInt();

        System.out.println(Runtime.getRuntime().availableProcessors());
        Phone jiophone= new Phone();

        AirtelSim sim1=new AirtelSim();
        JioSim sim2=new JioSim();
        jiophone.setSim(sim2);
        jiophone.browse();
        jiophone.call();



    }
}