# 常见的数据系统

- 数据库
- 缓存
- 搜索引擎
- 流式处理
- 批处理
- 消息队列

# 日益复杂化

- Kafka：可以作为存储持久化一段时间日志数据、可以作为消息队列对数据进行分发、可以作为流式处理组件对数据反复蒸馏等等。
- Spark：可以对数据进行批处理、也可以化小批为流，对数据进行流式处理。
- Redis：可以作为缓存加速对数据库的访问、也可以作为事件中心对消息的发布订阅。

Redis 有三种读写策略分别是：旁路缓存模式策略、读写穿透策略、异步缓存写入策略
https://juejin.cn/post/7093452218535247886

书中用了三个词来回答：可靠性（Reliability）、可伸缩性（Scalability）、可维护性（Maintainability）

# 可靠性

如何衡量可靠性？

- 功能上: 满足 API 给出的行为; 误输入/误操作时，能够正常处理
- 性能上: 在给定硬件和数据量下，能够满足承诺的性能指标。
- 安全上: 能够阻止未授权、恶意破坏。

Chaos Monkey is responsible for randomly terminating instances in production to ensure that engineers implement their services to be resilient to instance failures.

两个易混淆的概念：Fault（系统出现问题） and Failure（系统不能提供服务）

## 硬件故障

在一个大型数据中心中，这是常态：

- 网络抖动、不通
- 硬盘老化坏道
- 内存故障
- 机器过热导致 CPU 出问题
- 机房断电

## 软件错误

- 不能处理特定输入，导致系统崩溃。
- 失控进程（如循环未释放资源）耗尽 CPU、内存、网络资源。
- 系统依赖组件变慢甚至无响应。
- 级联故障。

通常有一些环境假设，和一些隐性约束

## 人为问题

# 可伸缩性

## 衡量负载 -- 负载参数（load parameters）

系统负载是从用户视角来审视系统

- 应用日活月活
- 每秒向 Web 服务器发出的请求
- 数据库中的读写比率
- 聊天室中同时活跃的用户数量

## 描述性能

系统性能则是描述的系统的一种实际能力

- 吞吐量（throughput）： 每秒可以处理的单位数据量，通常记为 QPS。
- 响应时间（response time）： 从用户侧观察到的发出请求到收到回复的时间。
- 延迟（latency）：日常中，延迟经常和响应时间混用指代响应时间；

## 应对负载

- 纵向伸缩（scaling up）or 垂直伸缩（vertical scaling）
- 横向伸缩（scaling out）or 水平伸缩（horizontal scaling）
- 自动
- 手动

# 可维护性

- 可维护性（Operability） 便于运维团队无痛接手。
- 简洁性（Simplicity） 便于新手开发平滑上手：这需要一个合理的抽象，并尽量消除各种复杂度。如，层次化抽象。
- 可演化性（Evolvability） 便于后面需求快速适配：避免耦合过紧，将代码绑定到某种实现上。也称为可扩展性（extensibility），可修改性（modifiability） 或可塑性（plasticity）。
