import com.ust.task.model.Developer;
import com.ust.task.model.Employee;
import com.ust.task.model.Manager;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 80000.0, 22, 5);
        Developer developer=new Developer("Alice", 80000.0, 22, "HTML");
        manager.displayDetails();
        developer.displayDetails();
    }
}