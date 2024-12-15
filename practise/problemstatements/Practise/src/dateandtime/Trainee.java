package dateandtime;

import java.time.LocalDate;
import java.util.Date;

public class Trainee {
    private int id;
    private String name;
    private LocalDate datejoined;

    public Trainee(int id, String name, LocalDate datejoined) {
        this.id = id;
        this.name = name;
        this.datejoined = datejoined;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(LocalDate datejoined) {
        this.datejoined = datejoined;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
