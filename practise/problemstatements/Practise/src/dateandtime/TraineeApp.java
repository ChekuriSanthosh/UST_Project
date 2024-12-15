package dateandtime;

import java.time.LocalDate;
import java.util.List;

public class TraineeApp {
    public static void main(String[] args) {
        Trainee t1 = new Trainee(1,"Manya", LocalDate.parse("2022-10-02"));
        Trainee t2 = new Trainee(2,"Russel",LocalDate.parse("2023-10-11"));
        Trainee t3 = new Trainee(3,"Joel",LocalDate.parse("2022-12-01"));
        Trainee t4 = new Trainee(4,"Akash",LocalDate.parse("2024-12-01"));
        Trainee t5= new Trainee(5,"Pranith",LocalDate.parse("2023-12-01"));


        List<Trainee> res= List.of(t1,t2,t3,t4,t5);
        Trainee san=res.stream().min((t11,t22)->t11.getDatejoined().compareTo(t22.getDatejoined())).get();
        System.out.println(san.getName());
    }
}
