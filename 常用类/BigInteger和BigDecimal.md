## BigInteger和BigDecimal

### 应用场景

- BigInteger适合保存比较大的整型
- BigDecimal适合保存精度更高的浮点型（小数）

### BigInteger常用方法

- 加法：add

```java
BigInteger bigInteger = new BigInteger("4561231846513135465311322125341651");
BigInteger bigInteger1 = new BigInteger("11111");
//加法
BigInteger newAddBig = bigInteger.add(bigInteger1);
System.out.println(newAddBig);
```

- 减法：subtract

```java
BigInteger bigInteger = new BigInteger("4561231846513135465311322125341651");
BigInteger bigInteger1 = new BigInteger("11111");
//减法
BigInteger newSubtractBig = bigInteger.subtract(bigInteger1);
System.out.println(newSubtractBig);
```

- 乘法：multiply

```java
BigInteger bigInteger = new BigInteger("4561231846513135465311322125341651");
BigInteger bigInteger1 = new BigInteger("11111");
//乘法
BigInteger newMultiplyBig = bigInteger.multiply(bigInteger1);
System.out.println(newMultiplyBig);
```

- 除法：divide

```java
BigInteger bigInteger = new BigInteger("4561231846513135465311322125341651");
BigInteger bigInteger1 = new BigInteger("11111");
//除法
BigInteger newDivideBig = bigInteger.divide(bigInteger1);
System.out.println(newDivideBig);
```

### BigDecimal常用方法

- 加法：add

```java
BigDecimal bigDecimal = new BigDecimal("4515641541561465132.123165486498");
BigDecimal bigDecimal1 = new BigDecimal("21313465.1234564815365546684");
//加法：add
BigDecimal newAddBigDecimal = bigDecimal.add(bigDecimal1);
System.out.println(newAddBigDecimal);
```

- 减法：subtract

```java
BigDecimal bigDecimal = new BigDecimal("4515641541561465132.123165486498");
BigDecimal bigDecimal1 = new BigDecimal("21313465.1234564815365546684");
//减法：subtract
BigDecimal newSubtractBigDecimal = bigDecimal.subtract(bigDecimal1);
System.out.println(newSubtractBigDecimal);
```

- 乘法：multiply

```java
BigDecimal bigDecimal = new BigDecimal("4515641541561465132.123165486498");
BigDecimal bigDecimal1 = new BigDecimal("21313465.1234564815365546684");
//乘法：multiply
BigDecimal newMultiplyBigDecimal = bigDecimal.multiply(bigDecimal1);
System.out.println(newMultiplyBigDecimal);
```

- 除法：divide,需要指定精度,ROUND_CEILING会保留分子精度

```java
BigDecimal bigDecimal = new BigDecimal("4515641541561465132.123165486498");
BigDecimal bigDecimal1 = new BigDecimal("21313465.1234564815365546684");
//除法：divide,需要指定精度,ROUND_CEILING会保留分子精度
BigDecimal newDivideBigDecimal = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING);
System.out.println(newDivideBigDecimal);
```
