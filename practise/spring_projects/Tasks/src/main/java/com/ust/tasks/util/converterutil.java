package com.ust.tasks.util;

import com.ust.tasks.dto.TaskDto;
import com.ust.tasks.model.Task;

public class converterutil {
    public static TaskDto taskconvertToDto(Task t){
        TaskDto taskDto=new TaskDto(
                t.getId(),
                t.getName(),
                t.getDescription(),
                t.getDate(),
                t.getCompleted(),
                t.getDeleteStatus()
        );
        return taskDto;
    }

    public static Task DtoconvertToTask(TaskDto taskDto){
        Task t=new Task(
                taskDto.id(),
                taskDto.name(),
                taskDto.description(),
                taskDto.date(),
                taskDto.completed(),
                taskDto.deleteStatus()
        );
        return t;
    }
}
