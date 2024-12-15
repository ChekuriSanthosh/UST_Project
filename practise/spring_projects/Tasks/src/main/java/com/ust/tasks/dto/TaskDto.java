package com.ust.tasks.dto;

import com.ust.tasks.model.DeleteStatus;
import com.ust.tasks.model.Status;

import java.time.LocalDate;

public record TaskDto(int id, String name, String description, LocalDate date, Status completed, DeleteStatus deleteStatus) {
}
