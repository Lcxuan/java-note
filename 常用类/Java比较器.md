## Java比较器

- 在Java中经常会涉及到对象数组的排序问题，那么就涉及到对象之间的比较问题，但是正常情况下，只能使用==或者!=进行比较，不能使用 > 或 <

- Java实现对象排序的方式有两种
  
  - 自然排序：Comparable接口
  
  - 定制排序：Comparator接口

### 自然排序：Comparable接口

- 像String、包装类等都实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式

- 像String、包装类等重写compareTo()方法后，进行了从小到大的排序

- 重写compareTo(obj)的规则
  
  - 如果当前对象大于形参对象obj，则返回正整数
  
  - 如果当前对象小于形参对象obj，返回负整数
  
  - 如果当前对象等于形参对象obj，则返回0

```java
public class ComparableTest {
    public static void main(String[] args) {
        String[] strArr = {"AA", "CC", "BB", "DD", "FF", "EE"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
    }
}
```

#### 自定义类实现Comparable接口

- 如果需要排序，可以让自定义类实现Comparable接口，重写compareTo()方法

- 自定义类：
  
  ```java
  public class Goods implements Comparable{
      private String name;
      private double price;
  
      public Goods() {
      }
  
      public Goods(String name, double price) {
          this.name = name;
          this.price = price;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public double getPrice() {
          return price;
      }
  
      public void setPrice(double price) {
          this.price = price;
      }
  
      @Override
      public String toString() {
          return "Goods{" +
                  "name='" + name + '\'' +
                  ", price=" + price +
                  '}';
      }
  
      // 指明自定义类按照什么来比较
      @Override
      public int compareTo(Object o) {
          if (o instanceof Goods){
              Goods goods = (Goods) o;
              // 方式一
              if (this.price > goods.price){
                  return 1;
              }else if (this.price < goods.price){
                  return -1;
              }else {
                  return 0;
              }
  
              // 方式二
              //return Double.compare(this.price, goods.price);
          }
          throw new RuntimeException("传入的数据类型不一致");
      }
  }
  ```

- 测试类：
  
  ```java
  public class ComparableTest2 {
      public static void main(String[] args) {
          Goods[] arr = new Goods[4];
          arr[0] = new Goods("联想鼠标", 34);
          arr[1] = new Goods("戴尔鼠标", 43);
          arr[2] = new Goods("小米鼠标", 12);
          arr[3] = new Goods("罗技鼠标", 65);
  
          Arrays.sort(arr);
  
          System.out.println(Arrays.toString(arr));
      }
  }
  ```

### 定制排序：Comparator接口

- 当元素的类型没有实现Comparable接口而又不方便修改代码或者实现了Comparable接口的排序规则不适合当前的操作，那么可以使用Comparator接口的compare()方法来进行排序

- 重写compare(Object o1, Object o2)方法规则：
  
  - o1大于o2，则返回正整数
  
  - o1小于o2，则返回负整数
  
  - o1等于o2，则返回0

```java
public class ComparatorTest {
    public static void main(String[] args) {
        String[] strArr = {"AA", "CC", "BB", "DD", "FF", "EE"};
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 从大到小进行排序
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(strArr));
    }
}
```

#### 自定义类实现Comparator接口

- 自定义类
  
  ```java
  public class Goods{
      private String name;
      private double price;
  
      public Goods() {
      }
  
      public Goods(String name, double price) {
          this.name = name;
          this.price = price;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public double getPrice() {
          return price;
      }
  
      public void setPrice(double price) {
          this.price = price;
      }
  
      @Override
      public String toString() {
          return "Goods{" +
                  "name='" + name + '\'' +
                  ", price=" + price +
                  '}';
      }
  }
  ```

- 定制Comparator
  
  ```java
  public class ComparatorTest2 {
      public static void main(String[] args) {
          Goods[] arr = new Goods[5];
          arr[0] = new Goods("联想鼠标", 34);
          arr[1] = new Goods("戴尔鼠标", 43);
          arr[2] = new Goods("小米鼠标", 12);
          arr[3] = new Goods("小米鼠标", 34);
          arr[4] = new Goods("罗技鼠标", 65);
  
          Arrays.sort(arr, new Comparator<Goods>() {
              @Override
              public int compare(Goods o1, Goods o2) {
                  // 按照名称从低到高，再按照价格从高到低
                  if (o1.getName().equals(o2.getName())){
                      return -Double.compare(o1.getPrice(), o2.getPrice());
                  }else {
                      return o1.getName().compareTo(o2.getName());
                  }
              }
          });
          System.out.println(Arrays.toString(arr));
      }
  }
  ```

### Comparable接口和comparator接口的区别

- Comparable接口保证实现类的对象在任何位置都可以比较大小

- Comparator接口属于临时性的比较
