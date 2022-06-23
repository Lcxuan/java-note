## StringBuilder类

### 基本介绍

一个可变的字符序列，提供一个与StringBuffer兼容的API，不保证同步（不是线程安全），该类设计用作StringBuffer的一个简易替换，**用在字符串缓冲区被单个线程使用的时候**，【建议优先采用StringBuilder，在大多实现中，比StringBuffer快】

主要操作是append和insert方法，可重载



StringBuilder继承AbstractStringBuilder类

实现了Serializable，说明StringBuilder对象是可以串行化（对象可以网络传输，可以保存文件）

StringBuilder是final类，不能被继承

StringBuilder对象字符序列仍然是存放在其父类AbstractStringBuilder的char[] value；因此，字符序列是在堆中

StringBuilder的方法没有做互斥处理，即没有synchronized关键字，因此在单线程中使用

**线程不安全，效率相对较高**



### String、StringBuffer和StringBuilder的比较

- StringBuilder和StringBuffer类似，均代表可变的字符序列，而且方法一样
- String：不可变字符序列，效率低，但是复用率搞
- StringBuffer：可变字符序列，效率较高、线程安全
- StringBuilder：可变字符序列、效率最高、线程不安全

如果对String做大量修改，不要使用String

效率：StringBuilder > StringBuffer > String



### 使用原则

- 如果字符串存在大量的修改操作，一般使用StringBuffer或StringBuilder
- 如果字符串存在大量的修改操作，并在单线程的情况，使用StringBuilder
- 如果字符串存在大量的修改操作，并在多线程的情况，使用StringBuffder
- 如果字符串很少修改，被多个对象引用，使用String，比如配置信息等