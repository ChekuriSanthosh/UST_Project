package models;

//import Collections.TaskComparator;

import java.util.Comparator;

public class Order implements Comparable<Order> {
    private String name;
    private String orderitem;
    private int priority;
    private Membership membership;

    private Status status;

    public Order(int priority, String name,String orderitem, Membership membership) {
        this.name = name;
        this.orderitem=orderitem;
        this.priority = priority;
        this.membership=membership;
        this.status=Status.PENDING;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getOrderitem(){
        return orderitem;
    }

    public Status getStatus() {
        return status;
    }
    public Membership getMembership(){
        return membership;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void setMembership(Membership membership){
        this.membership=membership;
    }

    public int compareTo(Order t) {
        if(t.getMembership()==Membership.PREMIUM && this.getMembership()==Membership.NORMAL){
            return 1;
        }else if(this.getMembership()==Membership.PREMIUM && t.getMembership()==Membership.NORMAL){
            return -1;
        }else{
            return 0;
        }
    }

}
