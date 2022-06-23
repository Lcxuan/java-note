## super关键字

super可以理解为：父类的

主要用来调用：属性、方法、构造器



### 使用说明

调用属性和方法

- 可以在子类方法或者构造器中。通过使用**super.属性**或者**super.方法**的方式，显示的调用父类中声明的属性或者方法。但是，通常情况下，省略"super."

- 特殊情况，当子类和父类中定义同名的属性时，要想在子类中调用父类中声明的属性，则必须显式的使用**super.属性**的方式，表示调用的是父类中声明的属性

- 特殊情况，当子类重写了父类中的方法后，要想在子类中调用父类中被重写的方法，则必须显式的使用**super.方法名**的方式，表示调用的是父类中被重写的方法

调用构造器

- 可以在子类的构造器中显示的使用**super(形参列表)** 方式，调用父类中声明的指定的构造器

- **super(形参列表)** 的使用，必须声明在子类构造器的首行

- 在类的构造器中，**this(形参列表)** 或者 **super(形参列表)** 只能二选一，不能同时出现

- 在子类构造器的首行，没有显式的声明**this(形参列表)** 或者 **super(形参列表)**，则默认调用的是父类中空参的构造器：**super()**

- 在类的多个构造器中，至少有一个类的构造器中使用了**super(形参列表)**，调用了父类中的构造器

### 代码体现

- 父类体现：
  
  ```java
  public class Person {
  
      int id = 1001;
      String name;
      int age;
  
      public Person() {
          System.out.println("Person 无参构造器");
      }
  
      public Person(String name) {
          this.name = name;
      }
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public void eat(){
          System.out.println("Person 吃饭");
      }
  }
  ```

- 子类体现：
  
  ```java
  public class Student extends Person{
  
      int id = 1002;
      String major;
  
      public Student() {
          // 默认调用父类中的空参构造器
      }
  
      public Student(String major) {
          // 默认调用父类中的空参构造器
          this.major = major;
      }
  
      public Student(String name, int age, String major) {
          // 调用父类的构造器，可以使用super(参数...)
          super(name, age);
          this.major = major;
      }
  
      @Override
      public void eat() {
          System.out.println("Student 吃饭");
      }
  
      // 调用方法
      public void superMethod(){
          // 当父类和子类拥有相同的方法时，默认调用子类中方法
          this.eat();
          // 如果想调用父类中方法，可以使用super.方法名
          super.eat();
      }
  
      // 调用属性
      public void superField(){
          // 父类定义的属性，而子类没有定义的属性时，super和this一样使用
          System.out.println("name:" + this.name + ", age:" + super.age);
          // 父类和子类定义相同名的属性时，默认使用子类定义好的属性
          System.out.println("Student id:" + id); // 相当于this.id
          // 可以使用super.属性名即可使用父类的属性
          System.out.println("Person id:" + super.id);
      }
      
      // 测试调用了父类的构造器
      public void testConstructor(){
          System.out.println("name:" + name + ", age:" + age + ", major:" + major);
      }
  }
  ```

- 测试
  
  ```java
  public class SuperTest {
  
      public static void main(String[] args) {
          Student student = new Student("张三", 18, "计算机");
          student.testConstructor(); // 测试调用了父类的构造器
          System.out.println("----------分割线----------");
          student.superField(); // 测试super.属性
          System.out.println("----------分割线----------");
          student.superMethod(); // 测试super.方法
          System.out.println("----------分割线----------");
          Student defaultSuper = new Student(); // 测试默认调用的
      }
  }
  ```


