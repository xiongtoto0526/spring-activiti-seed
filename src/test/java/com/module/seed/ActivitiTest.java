package com.module.seed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles("local")
public class ActivitiTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationTest.class);

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	
	@Test
	public void testDeleteDeployment() {
//		repositoryService.deleteDeployment("1",true);
	}
	
	@Test
	public void testProcess() {
		
		// 开启
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("day", "周末");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variables);
        logger.debug("process is running ...");
        
        // 查看任务
        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId()).list();
                ;
        for(Task task: tasks){
        	logger.debug("find task name :"+task.getName());
        }
        
        // 完成任务
        taskService.complete(tasks.get(0).getId());

	}

}
