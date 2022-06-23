## Lambda表达式

Lambda 是一个匿名函数，使用它可以写出更简洁、更灵活的代码。

举例：

- 以前的使用方式：
  
  ```java
  Runnable runnable1 = new Runnable() {
      @Override
      public void run() {
          System.out.println("我爱Java");
      }
  };
  runnable1.
  ```

- 使用Lambda的方式：
  
  ```java
  Runnable runnable2 = () -> { System.out.println("我爱Java"); };
  runnable2.run();
  ```

- 左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）

- 右边：lambda体（其实就是重写的抽象方法的方法体）

### 六种情况

#### 语法格式一：无参，无返回值

```java
Runnable r1 = ()->{System.out.printIn("Hello Lambda");};
```

#### 语法格式二：Lambda需要一个参数，但是没有返回值

```java
Consumer<String> con = (String str)->{System.out.printIn(str);};
```

#### 语法格式三：数据类型可以省略

```java
Consumer<String> con = (str)->{System.out.printIn(str);};
```

#### 语法格式四：Lambda如果只有一个参数时，参数的小括号可省略

```java
Consumer<String> con = str->{System.out.printIn(str);};
```

#### 语法格式五：Lambda需要两个或以上的参数，多条执行语句，可以有返回值

```java
Comparator<Integer> con = (x, y)->{
    System.out.printIn("实现Lambda");
    return Integer.compare(x, y);
}
```

#### 语法格式六：Lambda体只有一条语句时，retuen和大括号可以省略

```java
Comparator<Integer> com = (x,y)->Integer.compare(x,y);
```

### lambda表达式使用场景

- 当需要对一个函数式接口实例化的时候，可以使用lambda表达式
