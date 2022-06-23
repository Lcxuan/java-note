## String类

String代表字符串，Java程序中的所有字符串字面值（如："abc"）都作为此类的实例实现

String是一个final类，不可以改变

String是常量，用双引号引起来表示，它们的值在创建后不能改变

String的内容是存储在一个字符数组value[]中

String实现了多个接口：

- 实现了Serializable接口，表示字符串是支持序列化的

- 实现了Comparable接口，表示String可以比较大小

通过字面量的方式给字符串赋值，此时的字符串值声明在字符串常量池中

```java
public class StringTest {
    @Test
    public void test1(){
        String s1 = "abc";  // 字面量的定义方式
        String s2 = "abc";

        // 通过字面量的定义方式，值存储在字符串常量池中
        // 字符串常量池中不能有多个相同的值，会复用相同的值
        System.out.println(s1 == s2);   // true
    }
}
```

### String对象的创建

#### 方式一：通过字面量定义的方式

```java
String str1 = "abc";
```

#### 方式二：通过new + 构造器的方式

```java
String str = new String("abc");
```

#### 两种方式的区别

```java
public class StringTest2 {
    public static void main(String[] args) {
        // 通过字面量的方式：数据值声明在方法区中的字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";

        // 通过new + 构造器的方式：保存的地址值是数据值在堆中对应的地址值
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);   // true
        System.out.println(s1 == s3);   // false
        System.out.println(s1 == s4);   // false
        System.out.println(s3 == s4);   // false
    }
}
```

### String和char[]之间的转换

```java
public class StringTest4 {
    public static void main(String[] args) {
        // String转换为char[]：使用toCharArray()方法
        String s1 = "abc123";
        System.out.println(Arrays.toString(s1.toCharArray()));

        // char[]转换为String：调用String的构造器
        char[] charArr = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        String str = new String(charArr);
        System.out.println(str);
    }
}
```

### String 和byte[]之间的转换

- 解码时，要求解码使用的字符集必须与编码时使用得字符集一致，否则出现乱码

```java
public class StringTest5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // String转换为byte[]：getBytes()方法
        String s1 = "abc123中国";
        byte[] bytes1 = s1.getBytes(); // 使用默认的字符集转换
        byte[] bytes2 = s1.getBytes("gbk"); // 使用其他字符集转换
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));

        // byte[]转换为String：调用String的构造器
        String str1 = new String(bytes1); // 使用默认字符集，进行转换
        String str2 = new String(bytes2, "gbk"); // 使用指定字符集，进行转换

        System.out.println(str1);
        System.out.println(str2);
    }
}
```

### String不同拼接的对比

- 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量

- 只要其中有一个是变量，结果就在堆中

- 如果拼接的结果调用intern()方法，返回值就在常量池中

```java
public class StringTest3 {
    public static void main(String[] args) {
        String s1 = "JAVA";
        String s2 = "PHP";

        String s3 = "JAVAPHP";
        String s4 = "JAVA" + "PHP";
        String s5 = s1 + "PHP";
        String s6 = "JAVA" + s2;
        String s7 = s1 + s2;
        String s8 = (s1 + s2).intern();

        System.out.println(s3 == s4);   // true
        System.out.println(s3 == s5);   // false
        System.out.println(s3 == s6);   // false
        System.out.println(s3 == s7);   // false
        System.out.println(s5 == s6);   // false
        System.out.println(s5 == s7);   // false
        System.out.println(s6 == s7);   // false
        System.out.println(s3 == s8);   // true
    }
}
```

### String常用方法

#### 1、lenght()

- 返回字符串的长度
  
  ```java
      @Test
      public void test1(){
          String s1 = "helloworld";
          System.out.println("长度为：" + s1.length());    // 10
      }
  ```

#### 2、charAt(int index)

- 返回某索引处的字符
  
  ```java
      @Test
      public void test2(){
          String s1 = "helloworld";
          System.out.println("获取到的字符：" + s1.charAt(0)); // h
      }
  ```

#### 3、isEmpty()

- 判断是否是空字符串
  
  ```java
      @Test
      public void test3(){
          String s1 = "helloworld";
          System.out.println("是否是空字符串：" + s1.isEmpty());  // false
      }
  ```

#### 4、toLowerCase()

- 使用默认语言环境，将String中的所有字符转换成小写
  
  ```java
      @Test
      public void test4(){
          String s1 = "HELLOWORLD";
          System.out.println("转换成小写：" + s1.toLowerCase()); // helloworld
      }
  ```

#### 5、toUpperCase()

- 使用默认语言环境，将String中的所有字符转换成大写
  
  ```java
      @Test
      public void test5(){
          String s1 = "helloworld";
          System.out.println("转换成大写：" + s1.toUpperCase()); // HELLOWORLD
      }
  ```

#### 6、trim()

- 返回字符串的副本，忽略前面空白和尾部空白
  
  ```java
      @Test
      public void test6(){
          String s1 = "    helloworld    ";
          System.out.println("忽略前后空格：" + s1.trim()); // helloworld
      }
  ```

#### 7、equals(Object obj)

- 比较字符串的内容是否相同
  
  ```java
      @Test
      public void test8(){
          String s1 = "hEllowoRld";
          String s2 = "helloworld";
          System.out.println("是否相同（忽略大小写）：" + s1.equalsIgnoreCase(s2)); // true
      }
  ```

#### 8、equalsIgnoreCase(String anotherString)

- 与equals方法类似，忽略大小写
  
  ```java
      @Test
      public void test9(){
          String s1 = "hEllowoRld";
          String s2 = "helloworld";
          System.out.println("是否相同（忽略大小写）：" + s1.equalsIgnoreCase(s2)); // true
      }
  ```

#### 9、concat(String str)

- 将指定字符串连接到此字符串的结尾，等价于”+“
  
  ```java
      @Test
      public void test10(){
          String s1 = "abc";
          String newStr = s1.concat("def");
          System.out.println("拼接后的字符串：" + newStr); // abcdef
      }
  ```

#### 10、compareTo(String anotherString)

- 比较两个字符串内容的大小

- 负数：当前字符串小，正数：当前字符串大，0两个相等
  
  ```java
      @Test
      public void test11(){
          String s1 = "abc";
          String s2 = new String("abd");
          System.out.println("大小为：" + s1.compareTo(s2)); // -1
      }
  ```

#### 11、substring(int beginIndex)

- 返回一个新的字符串，从beginIndex开始截取到结尾的一个子字符串
  
  ```java
      @Test
      public void test12(){
          String s1 = "helloworld";
          String s2 = s1.substring(3);
          System.out.println("截取的字符串：" + s2); // loworld
      }
  ```

#### 12、substring(int beginIndex, int endIndex)

- 返回一个新的字符串，从beginIndex开始截取到endIndex（不包含）的一个子字符串
  
  ```java
      @Test
      public void test13(){
          String s1 = "helloworld";
          String s2 = s1.substring(3, 5);
          System.out.println("截取的字符串：" + s2); // lo
      }
  ```

#### 13、endsWith(String suffix)

- 测试此字符串是否以指定的后缀结束
  
  ```java
      @Test
      public void test1(){
          String s1 = "helloworld";
          System.out.println("是否以指定内容结尾：" + s1.endsWith("ld")); // true
      }
  ```

#### 14、startsWith(String prefix)

- 测试此字符串是否以指定的前缀开始
  
  ```java
      @Test
      public void test2(){
          String s1 = "helloworld";
          System.out.println("是否以指定内容开始：" + s1.startsWith("ld")); // false
      }
  ```

#### 15、startsWith(String prefix, int toffset)

- 测试此字符串从指定索引开始的字符串是否以前缀开始
  
  ```java
      @Test
      public void test3(){
          String s1 = "helloworld";
          System.out.println("是否以指定内容开始：" + s1.startsWith("lo", 3)); // true
      }
  ```

#### 16、contains(CharSequences)

- 当且仅当此字符串包含指定的char值序列时，返回true
  
  ```java
      @Test
      public void test4(){
          String s1 = "helloworld";
          System.out.println("是否包含指定字符：" + s1.contains("llow")); // true
      }
  ```

#### 17、indexOf(String str)

- 返回指定子字符串在此字符串中第一次出现处的索引

- 未找到返回-1
  
  ```java
      @Test
      public void test5(){
          String s1 = "helloworld";
          System.out.println("首次出现的内容索引：" + s1.indexOf("l")); // 2
      }
  ```

#### 18、indexOf(String str, int fromIndex)

- 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始

- 未找到返回-1
  
  ```java
      @Test
      public void test6(){
          String s1 = "helloworld";
          System.out.println("首次出现的内容索引：" + s1.indexOf("l", 3)); // 3
      }
  ```

#### 19、lastIndexOf(String str)

- 返回指定子字符串在此字符串中最右边出现处的索引

- 未找到返回-1
  
  ```java
      @Test
      public void test7(){
          String s1 = "helloworld";
          System.out.println("最后出现的内容索引：" + s1.lastIndexOf("l")); // 8
      }
  ```

#### 20、lastIndexOf(String str, int fromIndex)

- 返回指定子字符串在此字符串中最后一次出现处的索引，从指定索引开始反向搜索

- 未找到返回-1
  
  ```java
      @Test
      public void test8(){
          String s1 = "helloworld";
          System.out.println("最后出现的内容索引：" + s1.lastIndexOf("l", 4)); // 3
      }
  ```

#### 21、replace(char oldChar, char newChar)

- 返回一个新的字符串，通过用newChar替换此字符串中出现的所有oldChar得到的
  
  ```java
      @Test
      public void test1(){
          String s1 = "张三李四张四";
          String s2 = s1.replace('张', '王');
          System.out.println("替换后的字符串：" + s2); // 王三李四王四
      }
  ```

#### 22、replace(CharSequence targer, CharSequence replacement)

- 使用指定的字面量替换此字符串所有匹配字面值目标序列的子字符串
  
  ```java
      @Test
      public void test2(){
          String s1 = "张三李四张四";
          String s2 = s1.replace("张三", "王五");
          System.out.println("替换后的字符串：" + s2); // 王五李四张四
      }
  ```

#### 23、replaceAll(String regex, String replacement)

- 使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
  
  ```java
      @Test
      public void test3(){
          String s1 = "hellow1world234asd";
          // 将字符串中的数字替换成","
          String s2 = s1.replaceAll("\\d+", ",");
          System.out.println("替换后的字符串：" + s2); // hellow,world,asd
      }
  ```

#### 24、replaceFirst(String regex, String replacement)

- 使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串
  
  ```java
      @Test
      public void test4(){
          String s1 = "hellow1world234asd";
          // 将字符串中的首次出现的数字替换成","
          String s2 = s1.replaceFirst("\\d+", ",");
          System.out.println("替换后的字符串：" + s2); // hellow,world234asd
      }
  ```

#### 25、matches(String regex)

- 告知此字符串是否匹配给定的正则表达式
  
  ```java
      @Test
      public void test5(){
          String s1 = "12345";
          // 判断字符串是否全部由数字组成
          boolean matches = s1.matches("\\d+");
          System.out.println("是否匹配正则：" + matches); // true
      }
  ```

#### 26、split(String regex)

- 根据给定正则表达式的匹配拆分此字符串
  
  ```java
      @Test
      public void test6(){
          String s1 = "hello|world|java";
          String[] split = s1.split("\\|");
          System.out.println(Arrays.toString(split));
      }
  ```

#### 27、split(String regex, int limit)

- 根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中
  
  ```java
      @Test
      public void test7(){
          String s1 = "hello|world|java";
          String[] split = s1.split("\\|", 2);
          System.out.println(Arrays.toString(split)); // [hello, world|java]
      }
  ```
