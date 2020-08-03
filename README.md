# SSMPractice
## ssm_demo概要
ssm_demo 是一个小的ssm框架整合的demo， 包括的主要内容：  
* spring+ mybatis 整合
* 数据库的连接配置文件
* json 格式的springmvc 响应
* ssm 配置的pom , mybatis 配置， spring mvc 配置， spring, test 配置

---
* 更新
  * 2020-07-19 添加简单切面（日志）
  * 2020-07-19 添加redis，避免多次访问数据库，提高响应和性能

## 项目打包
* 项目采用maven 管理，打包操作要求maven工具的使用
```
mvn clean
```
下载依赖
```
mvn install
```
打包
```
mvn package
```

## 几点说明
* <a href="http://www.bingmax.site/blog/2020/07/15/SSM-%E7%AE%80%E5%8D%95%E5%AE%9E%E6%88%98/">项目的具体部署博客</a>
* 项目主要负责响应前端的数据请求
* 后续项目有新的内容再更新
