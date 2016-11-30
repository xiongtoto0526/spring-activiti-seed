# usage

1.进入当前目录命令行
cd ./

2.配置表
修改generatorConfig.xml中，修改要生成的表名，和domain的实体类名。
<table tableName="yourNewTable" domainObjectName="yourNewTable"

3.检查脏目录
### 特别提示：
如果重复生成table， 需先删除 resource/mapper下的xml，否则会导致xml被重写两次，运行时则会报错如下：
 ---- Result Maps collection already contains value for com.seasun.management.mapper ---
 （mybatis-generator自身的bug）

4.执行
确认已经删除旧文件后，执行如下命令：
java -jar mybatis-generator-core-1.3.5.jar -configfile ./generatorConfig.xml -overwrite

4.检查
分别会在com.seasun.management.mapper
       com.seasun.management.model
       resource/mapper
下生成对应的类 或 xml 。

5.完成。
