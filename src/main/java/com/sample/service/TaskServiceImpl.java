package com.sample.service;

import java.util.List;

import com.sample.dto.TaskDto;
import com.sample.entity.Task;
import com.sample.repo.TaskRepository;
import com.sample.transformer.ITaskTransformer;
import com.sample.transformer.TaskTransformer;
import com.sample.transformer.Transformer;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private ITaskTransformer transformer;
    @Autowired
    private TaskRepository repository;

    @Override
    public void create(TaskDto taskDto) {
        Task task = transformer.convertToEntity(taskDto);
        repository.save(task);
    }

    @Override
    public void update(TaskDto taskDto) throws BadHttpRequest {
        Task task;
        if (taskDto.getId() != null) {
            if (repository.exists(taskDto.getId())) {
                task = transformer.convertToEntity(taskDto);
                repository.save(task);
            } else
                throw new BadHttpRequest();
        }

    }

    @Override
    public List<TaskDto> findAll() {
        return transformer.convertToDto(repository.findAll());
    }

    public List<TaskDto> findAllSorted(Sort.Direction direction, String sortBy) {
        Sort  sort = new Sort(new Sort.Order(direction, sortBy));
        return transformer.convertToDto(repository.findAll(sort));
    }
}
