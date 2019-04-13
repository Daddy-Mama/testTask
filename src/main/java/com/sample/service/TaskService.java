package com.sample.service;

import com.sample.dto.TaskDto;
import com.sample.entity.Task;
import javassist.tools.web.BadHttpRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TaskService {
	void create(TaskDto taskDto);
	void update(TaskDto taskDto) throws BadHttpRequest;
	List<TaskDto> findAll();
	List<TaskDto> findAllSorted(Sort.Direction direction, String sortBy);
}
