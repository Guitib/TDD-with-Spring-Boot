package com.bell.vas.tdd.servicestest;

import com.bell.vas.tdd.domain.Task;
import com.bell.vas.tdd.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Boualem on 2017-07-12.
 */
@Service
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public Task createTask (Task task){

        Task savedTask = null;
        if (task.getName() != null && !task.getName().isEmpty()) {
            savedTask = taskRepository.save(task);
        }
        return savedTask;
    }

    public Task getTask(String name) {

        Optional<Task> task = taskRepository.findOneByName(name);
        if (task.isPresent()) {
            return task.get();
        } else {
            return null;
        }
    }

    public List<Task> getAllTasks(){
        List <Task> list = new ArrayList();
        Iterable<Task> iter = taskRepository.findAll();
        for (Task i : iter){
            list.add(i);
        }
        return list;
    }
}
