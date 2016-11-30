package com.module.seed.service.impl;

import com.module.seed.model.Person;
import com.module.seed.service.ActivitiService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiServiceImpl implements ActivitiService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Transactional
    @Override
    public void startProcessByPerson(Person person) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess",variables);
    }


    @Transactional
    @Override
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
    }

    @Override
    public List<Task> getAllTasks() {
        return taskService.createTaskQuery().list();
    }

    @Override
    public List<Task>  getTaskByKey(String key) {
        return taskService.createTaskQuery().processDefinitionKey(key).list();
    }

}
