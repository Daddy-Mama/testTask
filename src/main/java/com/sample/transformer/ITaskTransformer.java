package com.sample.transformer;

import com.sample.dto.TaskDto;
import com.sample.entity.Task;

public interface ITaskTransformer extends Transformer<Task, TaskDto> {
}
