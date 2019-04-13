package com.sample.transformer;

import com.sample.dto.TaskDto;
import com.sample.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskTransformer implements ITaskTransformer {
    @Autowired
    private ModelMapper modelMapper;

    public TaskDto convertToDto(Task task) {
        TaskDto taskDto = modelMapper.map(task, TaskDto.class);
        return taskDto;
    }

    public Task convertToEntity(TaskDto taskDto){
        Task task = modelMapper.map(taskDto, Task.class);
        return task;
    }

    public List<TaskDto> convertToDto(List<Task> tasks){
        return tasks.stream().map(x->convertToDto(x)).collect(Collectors.toList());
    }
}
