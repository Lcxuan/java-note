## final关键字

final主要用来修饰：类、方法、变量



### final修饰类

```java
final class FinalA{
}

// class FinalB extends FinalA{}    // 报错：FinalB不能作为FinalB的子类
```

使用final修饰类则说明该类不能被其他类所继承

例如：String类、System类、StringBuffer类



### final修饰方法

```java
public class FinalTest2 {
    public final void show(){}
}

class FinalTest2A extends FinalTest2{
    
    // 当重写父类的final修饰的方法时报错
    //@Override
    //public void show() {
    //    super.show();
    //}
}
```

使用final修饰的方法表示此方法不可以被重写

例如：Object类中的getClass()方法



### final修饰变量

如果final用来修饰变量，则表明该变量是一个常量

#### 修饰属性

只可以在定义属性时直接初始化属性、代码块中进行赋值、构造器中进行赋值

```java
public class FinalTest3 {

    final int WIDTH = 1;
    final int LEFT;
    final int RIGHT;

    {
        LEFT = 2;
    }

    public FinalTest3() {
        this.RIGHT = 3;
    }

    public static void main(String[] args) {
        // WIDTH = 20;  // 当final修饰变量后，则不能重新进行赋值
    }
}
```

#### 修饰局部变量

```java
public class FinalTest4 {
    public static void main(String[] args) {
        FinalTest4 finalTest4 = new FinalTest4();
        finalTest4.show(10);
    }

    public void show(){
        final int NUM = 10; // 常量
        //NUM += 10;  // 此时就不能重新进行赋值了
    }

    // 当修饰形参时，只能对形参进行调用，而不能进行重新赋值了
    public void show(final int num){
        System.out.println("num:" + num);
    }
}
```



### static fianl

主要用来修饰属性【全局常量】、方法【不能重写方法】