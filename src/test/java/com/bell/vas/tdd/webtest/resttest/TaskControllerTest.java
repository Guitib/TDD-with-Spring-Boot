package com.bell.vas.tdd.webtest.resttest;

import com.bell.vas.tdd.TddApplication;
import com.bell.vas.tdd.domain.Task;
import com.bell.vas.tdd.servicestest.TaskService;
import com.bell.vas.tdd.utils.TestUtil;
import com.bell.vas.tdd.web.rest.TaskController;
import jdk.net.SocketFlow;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Boualem on 2017-07-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest {

    @Inject
    TaskService taskService;

    MockMvc restMvc;

    @Before
    public void setUp () {

        MockitoAnnotations.initMocks(this);
        TaskController taskController = new TaskController();
        ReflectionTestUtils.setField(taskController, "taskService", taskService);
        this.restMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    @Transactional
    public void testCreateTask(){

        Task task = new Task();
        task.setName("Task10");
        task.setDescription("description of task10");
        task.setStatus("Pending");
        task.setOwner("Sam");
        task.setProject_name("prj10");


        try {
            restMvc.perform(
                    post("/V1.0/task")
                    .contentType(TestUtil.APPLICATION_JSON_UTF8)
                    .content(TestUtil.convertObjectToJsonBytes(task)))
               .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Transactional
    public void testListTasks(){

        Task task = new Task();
        task.setName("Task11");
        task.setDescription("description of task11");
        task.setStatus("Pending");
        task.setOwner("Sam");
        task.setProject_name("prj11");

        Task task2 = new Task();
        task2.setName("Task11");
        task2.setDescription("description of task11");
        task2.setStatus("Pending");
        task2.setOwner("Sam");
        task2.setProject_name("prj11");
        try {
            restMvc.perform(
                    post("/V1.0/task")
                            .contentType(TestUtil.APPLICATION_JSON_UTF8)
                            .content(TestUtil.convertObjectToJsonBytes(task2)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            restMvc.perform(
                    get("/V1.0/task")
                          .accept(TestUtil.APPLICATION_JSON_UTF8))
                          .andExpect(status().isOk());

        }catch (Exception e) {}
    }

}
