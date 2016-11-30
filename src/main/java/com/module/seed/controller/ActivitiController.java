package com.module.seed.controller;


import com.module.seed.mapper.PersonMapper;
import com.module.seed.model.Person;
import com.module.seed.model.TaskRepresentation;
import com.module.seed.service.ActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivitiController {

    @Autowired
    ActivitiService activitiService;

    @Autowired
    PersonMapper personMapper;

    //    curl -X POST  http://localhost:12356/process
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public void startProcessInstance() {
        activitiService.startProcess();
    }


    //    curl -X POST  http://localhost:12356/process/person?name=bear
    @RequestMapping(value = "/process/person", method = RequestMethod.POST)
    public void startProcessInstanceByPerson(@RequestParam String name)
    {
        Person person = personMapper.selectByPrimaryKey(1L);
        activitiService.startProcessByPerson(person);
    }


    //    http://localhost:12356/tasks
    @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskRepresentation> getTasks() {
        List<Task> tasks = activitiService.getAllTasks();
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    //    http://localhost:12356/tasks?assignee=oneTaskProcess
    @RequestMapping(value = "/task", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskRepresentation> getTask(@RequestParam String assignee) {
        List<Task> tasks = activitiService.getTaskByKey(assignee);
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }
}
