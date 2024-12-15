package Collections;

import models.Membership;
import models.Status;
import models.Order;

import java.util.*;

public class Zomato {

    private Queue<Order> taskQueue=new PriorityQueue<>();
    private Stack<Order> completedTask=new Stack<>();

    public void addTask(Order order){
        taskQueue.offer(order);
    }

    public void processTask(){
        while (!taskQueue.isEmpty()){
            Order res=taskQueue.peek();
            completedTask.push(taskQueue.poll());
            completedTask.peek().setStatus(Status.PROCESSING);
            System.out.println(completedTask.peek().getName()+" "+completedTask.peek().getMembership()+" "+completedTask.peek().getStatus());
        }
        System.out.println("Processed Task!!!");
        System.out.println("________________________________________________________________________");
    }

    public void displayCompleted(){
        System.out.println("The completed Tasks are: ");
        while(!completedTask.isEmpty()){
            Order res=completedTask.peek();
            completedTask.peek().setStatus(Status.COMPLETED);
            System.out.println(completedTask.peek().getName()+" "+completedTask.peek().getOrderitem()+"  "+completedTask.peek().getStatus());
            completedTask.pop();
        }
    }

    public static void main(String[] args) {

        Order task1=new Order(1,"Santhosh","Chicken Biryani", Membership.NORMAL);
        Order task2=new Order(2,"Pranith", "Mutton Biryani", Membership.PREMIUM);
        Order task3=new Order(3, "Kodi", "Fried Rice", Membership.NORMAL);
        Order task4=new Order(4, "Loki","Appam", Membership.PREMIUM);

        Zomato mytodos=new Zomato();

        mytodos.addTask(task1);
        mytodos.addTask(task3);
        mytodos.addTask(task2);
        mytodos.addTask(task4);

        mytodos.processTask();
        mytodos.displayCompleted();

    }
}
