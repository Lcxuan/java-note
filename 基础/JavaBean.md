## JavaBean

一种Java语言写成的可重用组件

- 类是公共的

- 有一个无参的公共构造器

- 有属性，且有对应的get、set方法

```java
public class Person {
    String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```


