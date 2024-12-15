package java.com.ust.traineapp.model;

import java.time.LocalDate;

public record Trainee(int id, String name, String location, LocalDate joinedDate) {
}
