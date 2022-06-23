## Arrays类

Arrays类为操作数组的工具类，包含了用来操作数组（比如排序和搜素）的各种方法

### 常见方法

- toString：返回数组的字符串形式

```java
Integer[] integers = {1,20,30,50,20,10,35,70};
System.out.println(Arrays.toString(integers));
```

- sort：排序
- 由于数组是引用类型，所以sort排序后，会直接影响到实参
- 可以通过传入一个接口 Comparator 实现定制排序

```java
Integer[] integers = {1,20,30,50,20,10,35,70};        
//默认排序
Arrays.sort(integers);
System.out.println(Arrays.toString(integers));

//定制排序
Arrays.sort(integers, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 1;
    }
});
System.out.println(Arrays.toString(integers));
```

- binarySearch：通过二分搜索法进行查找，数组必须是有序的，如果不存在则返回-1

```java
Integer[] integers1 = {10,20,30,40,50,60,70,80,90};
int index = Arrays.binarySearch(integers1,30);
System.out.println("索引为：" + index);
```

- copyOf：数组元素复制

```java
Integer[] integers = {1,20,30,50,20,10,35,70};    
Integer[] newArr = Arrays.copyOf(integers,integers.length);
System.out.println(Arrays.toString(newArr));
```

- fill：数组填充

```java
Integer[] integers2 = {1,2,3,4,5,6,7,8,9};
Arrays.fill(integers2,10);
System.out.println(Arrays.toString(integers2));
```

- equals：比较两个数组元素内容是否完全一致,完全则返回true，否则为false

```java
boolean equals = Arrays.equals(integers1,integers2);
System.out.println(equals);
```

- asList：将一组值转换成list

```java
List<Integer> asList = Arrays.asList(2,3,4,5,6,7,8,9);
System.out.println(asList);
```
