package models;

//import Collections.TaskComparator;

import java.util.Comparator;

public class Task{
    private String title;
    private int priority;
    private Status status;

    public Task(int priority, String title) {
        this.title = title;
        this.priority = priority;
        this.status=Status.PENDING;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public int compareTo(Task t) {
//
//        return this.priority-t.priority;
//    }

//    Comparator<Task> compareTo =new Comparator<Task>() {
//        @Override
//        public int compare(Task o1, Task o2) {
//            return o1.priority-o2.priority;
//        }
//    };
}
