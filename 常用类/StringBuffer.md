## StringBuffer类

代表可变的字符序列，可以对字符串内容进行增删

StringBuffer实现了Serializable，即StringBuffer可以串行化

在父类中，AbstractStringButter有属性char[] value ，不是final，该value数组存放字符串内容，存放存放在堆中的

StringBuffer是一个final类，不能被继承

**线程安全，效率较低**

### String和StringBuffer的区别

- String保存的是字符创常量，值不能更改，每次Stringl诶的更新实际上就是更改地址，效率低
- StringBuffer保存的是字符串变量，值可以更改，每次StringBuffer更新实际上可以更新内容，不用每次更新地址，效率较高

### 构造器

```java
//创建一个大小为16的char[]，用于存放字符内容
StringBuffer stringBuffer = new StringBuffer();

//通过构造器指定char[] 大小
StringBuffer stringBuffer1 = new StringBuffer(100);

//通过给一个String创建一个StringBuffer，char[] 大小就是str.length() + 16
StringBuffer stringBuffer2 = new StringBuffer("Hello");
```

### String和StringBuffer相互转换

#### String -> StringBuffer：

```java
//方式一：
String str = "Hello";
StringBuffer stringBuffer = new StringBuffer(str);

//方式二：
StringBuffer stringBuffer1 = new StringBuffer();
stringBuffer1.append(str);
```

#### StringBuffer -> String：

```java
//方式一：
StringBuffer stringBuffer2 = new StringBuffer("这是一个StringBuffer");
String s = stringBuffer2.toString();

//方式二：
String s2 = new String(stringBuffer2);
```

### StringBuffer类常见方法

- 增加：append

```java
StringBuffer stringBuffer = new StringBuffer("增加");
stringBuffer.append("你好");
System.out.println(stringBuffer);
```

- 删除：delete，删除指定位置的数据

```java
StringBuffer stringBuffer1 = new StringBuffer("这是一个StringBuffer的删除");
stringBuffer1.delete(1,2);
System.out.println(stringBuffer1);
```

- 修改：replace

```java
StringBuffer stringBuffer2 = new StringBuffer("这是一个StringBuffer的修改");
stringBuffer2.replace(0,3,"这是");
System.out.println(stringBuffer2);
```

- 查询：indexOf

```java
StringBuffer stringBuffer3 = new StringBuffer("这是StringBuffer的查询");
System.out.println(stringBuffer3.indexOf("查询"));
```

- 插入：insert，在指定的位置插入数据

```java
StringBuffer stringBuffer4 = new StringBuffer("这是StringBuffer的插入");
stringBuffer4.insert(2,"一个");
System.out.println(stringBuffer4);
```

- 长度：length，获取StringBuffer的总长度

```java
StringBuffer stringBuffer5 = new StringBuffer("这是StringBuffer的长度");
System.out.println(stringBuffer5.length());
```
