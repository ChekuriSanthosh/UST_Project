package Collections;

import models.Status;
import models.Task;

import java.util.*;

public class queueandstackexmp_TODO{

    private Queue<Task> taskQueue=new PriorityQueue<>((Task o1,Task o2)->{
        return o1.getPriority()-o2.getPriority();
    });



    private Stack<Task> completedTask=new Stack<>();

    public void addTask(Task task){
        taskQueue.offer(task);
    }

    public void processTask(){
        while (!taskQueue.isEmpty()){
            Task res=taskQueue.peek();
            completedTask.push(taskQueue.poll());
            System.out.println(res.getTitle()+" Task Done");
        }
        System.out.println("Completed Task!!!");
    }

    public void displayCompleted(){
        System.out.println("The completed Tasks are: ");
        while(!completedTask.isEmpty()){
            Task res=completedTask.peek();
            completedTask.peek().setStatus(Status.COMPLETED);
            System.out.println(completedTask.peek().getTitle()+"  "+completedTask.peek().getStatus());
            completedTask.pop();
        }
    }

    public static void main(String[] args) {

        Task task1=new Task(1,"Learn Java");
        Task task2=new Task(2,"Learn Python");
        Task task3=new Task(3, "Learn Something");
        Task task4=new Task(4, "kick");

        queueandstackexmp_TODO mytodos=new queueandstackexmp_TODO();

        mytodos.addTask(task1);
        mytodos.addTask(task3);
        mytodos.addTask(task2);
        mytodos.addTask(task4);

        mytodos.processTask();
        mytodos.displayCompleted();

    }
}
