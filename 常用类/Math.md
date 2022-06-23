## Math类

Math类包含用于执行基本数学运算的方法

### 常用方法

- abs：绝对值

```java
int abs = Math.abs(-9);
System.out.println("绝对值为：" + abs);
```

- pow：求幂

```java
double mathPow = Math.pow(2,4);
System.out.println("2的4次方为：" + mathPow);
```

- ceil：向上取整

```java
double mathCeil = Math.ceil(3.6);
System.out.println("向上取整：" + mathCeil);
```

- floor：向下取整

```java
double mathFloor = Math.floor(3.5);
System.out.println("向下取整：" + mathFloor);
```

- round：四舍五入

```java
long mathRound = Math.round(3.6);
System.out.println("四舍五入：" + mathRound);
```

- sqrt：求开方

```java
double sqrt = Math.sqrt(9);
System.out.println("开方：" + sqrt);
```

- random：求随机数
  - 返回0-1之间的随机小数
  - 公式：(int)(a + Math.random() * ( b - a + 1))

```java
for (int i=0;i<10;i++){
    System.out.println((int)(0 + Math.random() * (9 - 0 + 1)));
}
```

- max：返回最大值

```java
//返回最大值：max
System.out.println(Math.max(100,200));
```

- min：返回最小值

```java
//返回最小值：min
System.out.println(Math.min(100,200));
```
