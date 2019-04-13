package com.sample.controller;

import java.util.List;


import com.sample.dto.TaskDto;
import com.sample.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Api(description = "Task controller")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @ApiOperation("Create task")
    public ResponseEntity createTask(@RequestBody TaskDto taskDto) {
        taskService.create(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    @ApiOperation("Update task")
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto) throws BadHttpRequest {
        taskService.update(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @ApiOperation("find all tasks")
    public List<TaskDto> getAll() {
        return taskService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sort-by")
    @ApiOperation("find all with condition")
    public List<TaskDto> getAll(@RequestParam(value = "sortBy", defaultValue = "first_name") String sortBy, @RequestParam(value = "sortWay", defaultValue = "asc") String sortWay) throws BadHttpRequest {
        if (sortWay.toLowerCase().equals("asc")) {
           return taskService.findAllSorted(Sort.Direction.ASC, sortBy);
        }
        else if (sortWay.toLowerCase().equals("desc")) {
            return taskService.findAllSorted(Sort.Direction.DESC, sortBy);
        }
        throw new BadHttpRequest();
    }
}
