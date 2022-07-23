## ThreadLocal

ThreadLocal可以解决多线程的数据安全问题

可以给当前线程关联一个数据（可以是普通变量、对象、集合和数组）

ThreadLocal特点：

- ThreadLocal可以给当前线程关联一个数据（即可以像Map一样存取数据，但是key为当前线程）
- 每个ThreadLocal只能关联一个数据，如果需要关联多个，则需要使用多个ThreadLocal对象实例
- 每个ThreadLocal对象实例定义时，一般是static类型
- ThreadLocal中保存的数据，在线程销毁后，会由JVM虚拟机自动释放

### 使用方法

```java
public class ThreadLocalTest {
    private static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

    private static class Task implements Runnable{
        @Override
        public void run() {
            // 获取随机数
            int value = random.nextInt(10000);

            // 获取线程名
            String threadName = Thread.currentThread().getName();
            System.out.println("线程" + threadName + "中的随机数：" + value);

            // 将数据保存到ThreadLocal中
            threadLocal.set(value);

            // 休眠一分钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 结束后打印数据
            System.out.println("线程：" + threadName + "，值为：" + threadLocal.get());
        }
    }
}
```

运行后，数据和每个线程都对应了

- set()：将数据设置到ThreadLocal中
- get()：获取ThreadLocal中的数据
- remove()：删除当前线程ThreadLocal中的数据