SpringCloud & SpringCloudAlibaba 相关组件应用

## 1.版本问题？
请检查您的`SpringBoot`、`SpringCloud`、`SpringCloudAlibaba`依赖版本支持与对应。（前两者看官方文档support，尤其是4.x开始的版本，Ablibaba则看Alibaba自己各个组件的文档版本支持）

## 2.为什么SpringCloudAlibaba 2025.1.0.0开始读取不到BootStrap.yml配置？
如果使用`Nacos`引入远端配置，则需要在配置文件中显式声明一个属性：
``` yaml
spring:
  config:
    import: nacos:borrow-service-dev.yml?refreshEnabled=true
```
同时还是建议`SpringCloudAlibaba-Nacos`用户将配置文件命名为`application.yml`
如果是`SpringCloud`原生的`Config`依赖，则只需要书写：
``` yaml
Spring:
  cloud:
    config:
      # 名称，其实就是文件名称
      name: borrow-service
      # config-server的地址
      uri: http://localhost:8300
      # 环境
      profile: dev
      # 分支
      label: main
```
