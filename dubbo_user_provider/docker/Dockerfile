# 基于哪个镜像
FROM java:8
# 拷贝文件到容器，也可以直接写成ADD xxxxx.jar /app.jar
COPY dubbo_user_provider-0.0.1-SNAPSHOT.jar /app.jar
# 声明需要暴露的端口
EXPOSE 20881
# 配置容器启动后执行的命令
ENTRYPOINT ["sh","-c","java -jar /app.jar"]