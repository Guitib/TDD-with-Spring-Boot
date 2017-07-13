package com.bell.vas.tdd.servicestest;

import com.bell.vas.tdd.domain.Task;
import com.bell.vas.tdd.repositories.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by Boualem on 2017-07-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepositoryMock;

    @InjectMocks
    private TaskService taskService = new TaskService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();
        task.setStatus("Pending");
        task.setProject_name("Demo");

        when(taskRepositoryMock.save(task)).thenReturn(new Task());
        Task retTask = taskService.createTask(task);
        Assert.assertNull(retTask);
        task.setName("");
        retTask = taskService.createTask(task);
        Assert.assertNull(retTask);
        task.setName("Create DB");
        retTask = taskService.createTask(task);
        Assert.assertNotNull(retTask);
    }

}