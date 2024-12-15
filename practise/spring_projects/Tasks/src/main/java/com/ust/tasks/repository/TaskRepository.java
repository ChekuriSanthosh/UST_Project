package com.ust.tasks.repository;

import com.ust.tasks.model.Status;
import com.ust.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Integer> {

    @Query("SELECT t FROM Task t WHERE LOWER(t.name) LIKE LOWER(CONCAT(:name,'%'))")
    List<Task> findByName(String name);

    @Query("SELECT t FROM Task t WHERE t.completed = :status")
    List<Task> findByStatus(Status status);

    @Query("SELECT t FROM Task t WHERE t.completed = 'PENDING' AND t.date < CURRENT_DATE")
    List<Task> overDueTasks();

    @Query("SELECT t FROM Task t ORDER BY t.date")
    List<Task> sortByDueDate();

    @Query("SELECT t FROM Task t WHERE t.deleteStatus='DELETED'")
    List<Task> retrivedeletetasks();

    @Query(value = "SELECT * from tasks where extract(month from date)=:month and extract(year from date)=:year",nativeQuery = true)
    List<Task> getallbyMonthandYear(int month,int year);



//    void addTask(Task t);
//
//    List<Task> displayTasks();
//
//    boolean Taskexists(int id);
//
//    Task getTask(int id);
//
//    void deletebyid(int id);
//
//    void updatetask(Task t);
//
//    Task getTaskName(String name);
}
