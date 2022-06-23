## Scanner键盘获取

Scanner常用于控制台的输入,当需要使用控制台输入时即可调用这个类



### 实现步骤

1. 导入包：import java.util.Scanner

2. Scanner的实例化

```java
Scanner scanner = new Scanner(System.in);
```

3. 调用Scanner类的相关方法，来获取指定类型的变量

```java
int num = scanner.nextInt();
```



### 获取多种类型的数据

获取String类型的数据：使用next()、nextLine()

获取Int类型的数据：使用nextInt()

获取Float、Double类型的数据：nextFloat()、nextDouble()

获取Boolean类型的数据：nextBoolean()



对于char类型的数据，Scanner类没有提供对应的方法，解决方法：通过String类型中的charAt()方法

```java
String value = scanner.next();
char charAt = value.charAt(0);
```



**注意：需要根据对应的方法，来输入指定类型的值，如果输入的数据类型和要求的类型不相同，会报InputMisMatchException异常导致程序终止运行**
