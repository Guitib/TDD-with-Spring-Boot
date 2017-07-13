package com.bell.vas.tdd.web.rest;

import com.bell.vas.tdd.domain.Task;
import com.bell.vas.tdd.servicestest.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.xml.ws.RequestWrapper;
import java.util.List;


/**
 * Created by Boualem on 2017-07-12.
 */

@Controller
@RequestMapping("/V1.0")
public class TaskController {

    @Inject
    TaskService taskService;

    @RequestMapping (value = "/task",
                     method = RequestMethod.POST,
                     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask (@RequestBody Task task) {

        taskService.createTask(task);

        return new ResponseEntity(HttpStatus.OK);

    }


    @RequestMapping(value = "/task/{name}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retrieveTask(@PathVariable String name) {

        Task task = taskService.getTask(name);
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @RequestMapping(value="/task",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Task>> getAllTasks () {

        List<Task> taskList = taskService.getAllTasks();
        return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
    }
}