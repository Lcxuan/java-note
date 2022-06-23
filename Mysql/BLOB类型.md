### BLOB类型字段

- MySQL中，BLOB是一个二进制大型对象，是一个可以存储大量数据的容器，能容纳不同大小的数据

- MySQL的四种BLOB类型（除了在存储的最大信息量张不同外，其他是等同的）
  
  - TinyBlob类型：最大255字节
  
  - Blob类型：最大65K
  
  - MediumBlob类型：最大16M
  
  - LongBlob类型：最大4G

- 实际使用中根据需要存储的数据大小定义不同的BLOB类型

- **注意：** 如果存储的文件过大，数据库的性能会下降

- 如果在指定了相关的Blob类型后，报错：xxx too large，那么子啊mysql的安装目录中，找到my.ini文件加上如下配置，修改完后，需要重启mysql服务：
  
  ```mysql
  max_allowed_packet=16M
  ```
  
  


