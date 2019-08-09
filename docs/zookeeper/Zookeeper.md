# 一句话Zookeeper

Zookeeper是一个高性能、高可用以及易使用的分布式协调服务，

**协调**：协调服务之间的一致性

所以其多用做服务注册中心以及分布式锁



# Zookeeper的节点特性

- 持久化节点
- 临时节点
- 顺序节点
- TTL节点
- 容器节点
- 同级节点名称唯一
- 临时节点不允许创建子节点

# Zookeeper单机搭建

#### 安装Java

- 下载JDK8:https://www.oracle.com/technetwork/java/javase/downloads/index.html

- 将JDK压缩包传输到Linux服务器

- ```
  tar -zxvf
  ```

- 配置环境变量

  - ```
    vim /etc/profile
    ```

  - ```shell
    #Java
    JAVA_HOME=/usr/java/jdk1.8.0_221
    PATH=$PATH:$JAVA_HOME/bin
    CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
    export JAVA_HOME CLASSPATH PATH
    ```

#### 安装Zookeeper

- 下载

- 配置环境变量
  - ```
    vim /etc/profile
    ```

  - ```shell
    # zookeeper
    export ZK_HOME=/sen/zookeeper/zookeeper-3.4.14
    export PATH=$ZK_HOME/bin:$PATH
    ```

#### 连接并操作Zookeeper

```shell
zkCli.sh -timeout 5000 -server 127.0.0.1:2181
```

- https://blog.csdn.net/xyang81/article/details/53053642



# Zookeeper集群搭建

## 一、安装前准备

1. 三台Linux虚拟机
2. 虚拟机上安装JDK
3. 下载Zookeeper程序包
   下载地址：https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.5.5/

## 二、搭建步骤

1. 解压zk程序包到指定目录下
2. 进入zk安装目录中的conf目录，在该目录下复制一份zoo_sample.cfg文件，并重命名成zoo.cfg
3. 打开zoo.cfg文件,可自由配置数据目录dataDir、服务启动的端口号clientPort、日志数据目录dataLogDir；
   !图片.png](https://gper.club/server-img//mdEditors/2019/7/6b1a45de772548c6a268c6b00889938f.png)
4. 进入dataDir所配置的目录,创建myid文件，并在该文件中定义该zk节点的id【配置范围1~255】，如下图
   **注意：该id在集群的所有节点中不可重复!!**
5. 在另外2台虚拟机上重复1-4步骤，【注意myid不要重复】
6. 再次编辑zoo.cfg文件，按server.A=ip:port1:port2的格式配置；
   其中，
   A 指的是每台zk服务定义的myid;
   ip 为zk服务所对应虚拟机的ip地址；
   port1 为这台服务器与集群中的Leader服务器交换信息的端口；
   port2 表示的是万一集群中的Leader服务器挂了，需要一个端口来重新进行选举，选出一个新的Leader，这个端口就是用来执行选举时服务器相互通信的端口。
   如下图

![图片.png](https://gper.club/server-img//mdEditors/2019/7/07df1ff531b74d5a84d8245950523e04.png)

**注意1：每个zk节点都需配置上所有节点对应的服务信息【即3个服务节点每个都要在zoo.cfg文件中配置server.1、server.2、server.3的内容】注意2：如果是伪集群搭建【即在一台机器上搭建集群，每个server的端口port1和port2配置都不可重复】**

## 三、启动集群

进入每个zk节点安装目录下的bin文件夹，输入命令 ./zkServer.sh start,启动zk服务。
启动所有zk服务节点之后，输入./zkServer.sh status 查看状态,出现类似如下内容即集群搭建成功。
![图片.png](https://gper.club/server-img//mdEditors/2019/7/932feeec01a9428f8196d93b7428ebb5.png)