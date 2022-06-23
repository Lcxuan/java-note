## Object类

Object类是所有Java类的根父类

如果在类的声明中未使用extends关键字指明其父类，默认父类则是Object类

Object类只声明了一个空参的构造器

### clone()方法

复制一个对象

### equals()方法

判断两个对象是否相等，并且只能用于引用数据类型

Object类中定义的equals()定义：

```java
    public boolean equals(Object obj) {
        return (this == obj);
    }
```

Object类中定义的equals()是比较两个引用地址是否相同

但是在String、Date、File、包装类等都重写了Object类中的equals()方法，重写后，比较的不是两个引用的地址是否相同，而是**比较两个对象的实体内容是否相同**

#### 代码实现

- 重写equals()方法
  
  ```java
  public class Customer {
  
      String name;
      int age;
  
      public Customer() {
      }
  
      public Customer(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      // 重写原则，比较两个对象的实体内容是否相同
      @Override
      public boolean equals(Object o) {
          if (this == o){
              return true;
          }
          if (o instanceof Customer){
              Customer customer = (Customer) o;
              return this.name.equals(customer.name) && this.age == customer.age;
          }
          return false;
      }
  }
  ```

- 测试
  
  ```java
  
  ```

### finalize()方法

当垃圾回收确定不再有对象的引用时，垃圾回收器对该对象调用

可以通过**System.gc()或者Runtime.getRuntime().gc()** 来通知系统进行垃圾回收，但是系统是否进行垃圾回收仍然不确定

垃圾回收机制回收任何对象钱，会先调用finalize方法

#### 代码实现

- Person类对象
  
  ```java
  public class Person {
      @Override
      protected void finalize() throws Throwable {
          System.out.println("对象被释放");
      }
  }
  ```

- 测试类
  
  ```java
  public class FinalizeTest {
      public static void main(String[] args) {
          Person person = new Person();
          person = null;
          System.gc();
      }
  }
  ```

### getClass()方法

获取当前对象所处的类

```java
Person person = new Person();
System.out.printIn(person.getClass();
```

### hashCode()方法

返回当前对象的哈希值

### notify()和notifyAll()方法

### wait()方法

### toString()方法

当输出一个对象的引用时，实际上就是调用当前对象的toString()

当重写toString()方法时，默认输出当前类加地址值

Object类中定义的toString()：

```java
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

但是在String、Date、File、包装类等都重写了Object类中的toString()方法

#### 代码实现

- 重写toString()方法
  
  ```java
  public class ToString {
  
      String name;
      int age;
  
      public ToString() {
      }
  
      public ToString(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "ToString{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

- 测试
  
  ```java
  public class ToStringTest {
      public static void main(String[] args) {
          ToString test = new ToString("张三", 18);
          // 输出：ToString{name='张三', age=18}
          System.out.println(test);
      }
  }
  ```
