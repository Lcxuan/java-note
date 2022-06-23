## System

### 常用方法

- exit：退出当前程序

```java
System.out.println("执行程序...");
System.exit(0);
System.out.println("退出程序...");
```

- arraycopy：复制数组元素，比较适合底层调用，一般使用Arrays.copyOf完成复制数组

```java
//参数一：源数组
//参数二：从源数组的哪个索引位置开始拷贝
//参数三：目标数组，即把源数组的数据拷贝到哪个数组
//参数四：把源数组的数据拷贝到目标数组的哪个索引
//参数五：从源数组拷贝多少个数据到目标数组
int[] src = {1,2,3};
int[] dest = new int[3];
System.arraycopy(src,0,dest,0,3);
System.out.println(Arrays.toString(dest));
```

- currentTimeMillis：返回当前时间举例1970-1-1的毫秒数

```java
System.out.println(System.currentTimeMillis());
```

- getProperty()方法：获取系统中属性名key对应的值
  
  - java.version：获取Java运行时环境版本
  
  - java.home：Java安装目录
  
  - os.name：操作系统的名称
  
  - os.version：操作系统的版本
  
  - user.name：用户的名称
  
  - user.home：用户的主目录
  
  - user.dir：用户的当前工作目录
  
  ```java
  
  ```
