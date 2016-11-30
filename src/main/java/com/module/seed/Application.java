package com.module.seed;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan({"com.module.seed.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("applicantName", "John Doe");
                variables.put("email", "john.doe@activiti.com");
                variables.put("phoneNumber", "123456789");
                runtimeService.startProcessInstanceByKey("hireProcess", variables);

//                System.out.println("Number of process definitions : "
//                        + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
            }
        };

    }


    // 生产环境中不能这样,此为测试用的管理员
    @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

        return new InitializingBean() {
            public void afterPropertiesSet() throws Exception {

//                // 添加用户到数据库 ACT_ID_GROUP
//                Group group = identityService.newGroup("user");
//                group.setName("users");
//                group.setType("security-role");
//                identityService.saveGroup(group);
//
//                // 添加用户到数据库 ACT_ID_user
//                User admin = identityService.newUser("admin");
//                admin.setPassword("admin");
//                identityService.saveUser(admin);

                /**
                 * 然后,确保 build.gradle中加入了这个依赖:
                 * [ compile group: 'org.activiti', name: 'activiti-spring-boot-starter-rest-api', version: '5.22.0' ]
                 * 命令行执行:
                 * curl -u admin:admin -H "Content-Type: application/json" -d '{"processDefinitionKey":"hireProcess", "variables": [ {"name":"applicantName", "value":"John Doe"}, {"name":"email", "value":"john.doe@alfresco.com"}, {"name":"phoneNumber", "value":"1234567"} ]}' http://localhost:12356/runtime/process-instances
                 * 即启动一个新流程.类似于上面的:
                 * runtimeService.startProcessInstanceByKey("hireProcess", variables);
                 *
                 * 确保 build.gradle中加入了这个依赖:
                 * [     compile group: 'org.activiti', name: 'activiti-spring-boot-starter-actuator', version: '5.22.0']
                 * 然后访问: http://localhost:12356/activiti , 可获取activiti的一些统计信息,boom...
                 */

            }
        };
    }
}
