
-- 每次部署后生成这三张表的数据
select * FROM activiti.ACT_RE_DEPLOYMENT; -- 部署后自动创建,每部署一次增加一条记录
SELECT * FROM activiti.ACT_RE_PROCDEF; -- 流程定义表，部署后自动创建
SELECT * FROM activiti.ACT_GE_PROPERTY; -- 主键生成策略表
select * from activiti.act_ge_bytearray; -- javabean类型,实际存储位置，-- 不变资源相关,repository

-- 历史信息相关, history
SELECT * FROM activiti.ACT_HI_ACTINST where PROC_DEF_ID_ like '%myProcess%';  -- 存放历史所有节点的活动，包括开始和结束节点
SELECT * FROM activiti.ACT_HI_PROCINST where PROC_DEF_ID_ like '%myProcess%'; -- 流程实例的历史表，存放执行完毕的流程实例信息
SELECT * FROM activiti.ACT_HI_TASKINST where PROC_DEF_ID_ like '%myProcess%';  -- 已经执行完的历史任务信息，只包括task

-- 执行相关,run
select * from activiti.ACT_RU_IDENTITYLINK; -- 流程相关的主体人员表
SELECT * FROM activiti.ACT_RU_EXECUTION where PROC_DEF_ID_ like '%myProcess%'; --  正在执行的执行对象表，执行的所有节点d都会在这里显示
SELECT * FROM activiti.ACT_RU_TASK where PROC_DEF_ID_ like '%myProcess%';-- 正在执行的任务表，只有user-task才会产生这条记录
select * from activiti.ACT_RU_JOB; -- 无记录
SELECT * FROM act_ru_variable; -- 查看流程变量，若类型为serializable,则代表为javabean类型,实际存储在act_ge_bytearray中

-- 权限，认证 identify
select * from activiti.ACT_ID_GROUP;
select * from activiti.ACT_ID_user;



CREATE TABLE GAME_INFO (
    id INT NOT NULL AUTO_INCREMENT,
    xg_appid VARCHAR(64) COMMENT '西瓜APPID',
    platform ENUM('android', 'ios') NOT NULL DEFAULT 'android' COMMENT 'platform',
    game_name VARCHAR(64) COMMENT '游戏名',
    active_version INT COMMENT '当前用户可下载的版本',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE(xg_appid, platform)
);
ALTER TABLE GAME_INFO COMMENT '游戏信息表';

