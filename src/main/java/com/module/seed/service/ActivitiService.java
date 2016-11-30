package com.module.seed.service;


import com.module.seed.model.Person;
import org.activiti.engine.task.Task;

import java.util.List;

public interface ActivitiService {

    public void startProcess();

    public void startProcessByPerson(Person person);

    public List<Task> getAllTasks();

    public List<Task> getTaskByKey(String key);

}
