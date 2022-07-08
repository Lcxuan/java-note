## EL表达式

EL表达式全称：Expression Language，是表达式语言

EL表达式作用：主要是替代Jsp页面中的表达式脚本**在Jsp页面中进行数据的输出**

由于EL表达式在输出数据时，要比Jsp表达式脚本要简洁，所以使用EL表达式替代Jsp表达式

**EL表达式的格式：${表达式}**

EL表达式和JSP表达式不同的地方：

- EL表达式在输出null值的时候，输出的是空串

- JSP表达式脚本在输出null值时，输出的是null字符串

### EL表达式搜索域对象数据

获取域中的对象数据，只需要：${key}即可

```java
<body>
    <%pageContext.setAttribute("key", "pageContext");%>
    ${key}
</body>
```

当四个域中都有相同的key数据时，EL表达式会按照四个域的从小到大排序进行查找

### EL表达式输出Bean中属性、数组、List集合和Map集合

- EL表达式在输出属性时，并不是直接去找属性，而是找getXxx()方法

```java
<body>
    <%
        Person person = new Person();
        person.setName("张三");
        person.setPhones(new String[]{"12345678901", "09876543211", "12345098761"});

        List<String> cities = new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("广州");
        cities.add("深圳");
        person.setCities(cities);

        Map<String, Object> maps = new HashMap<>();
        maps.put("username", "张三");
        maps.put("password", "123456");
        person.setMaps(maps);

        pageContext.setAttribute("person", person);
    %>

    输出person：${person}<br>
    输出person的name属性：${person.name}<br>
    输出person的phones数组第一个值：${person.phones[0]}<br>
    输出person的list集合：${person.cities}<br>
    输出person的list集合第一个值：${person.cities[0]}<br>
    输出person的map集合：${person.maps}<br>
    输出person的map集合username的值：${person.maps.username}
</body>
```

### 运算符

语法：${ 运算表达式 }

#### 关系运算符

| 关系运算符   | 描述   | 例子                   | 结果    |
| ------- | ---- | -------------------- | ----- |
| == 或 eq | 等于   | ${5 == 5 或 5 eq 5}   | true  |
| != 或 ne | 不等于  | ${5 != 5 或 5 ne 5}   | false |
| < 或 lt  | 小于   | ${3 < 5 或 3 lt 5}    | true  |
| > 或 gt  | 大于   | ${2 > 10 或 2 gt 10}  | false |
| <= 或 le | 小于等于 | ${5 <= 12 或 5 le 12} | true  |
| >= 或 ge | 大于等于 | ${3 >= 5 或 3 ge 5}   | false |

#### 逻辑运算符

| 运算符      | 描述      | 例子                                            | 结果            |
| -------- | ------- | --------------------------------------------- | ------------- |
| && 或 and | 与运算     | ${12 == 12 && 12 < 11 或 12 == 12 and 12 < 11} | false         |
|          | \| 或 or | 或运算                                           | ${12 == 12 \| |
| ! 或 not  | 取反运算    | ${!true 或 not true}                           | false         |

#### 算数运算符

| 运算符     | 描述  | 例子                     | 结果  |
| ------- | --- | ---------------------- | --- |
| +       | 加法  | ${12 + 12}             | 24  |
| -       | 减法  | ${30 - 10}             | 20  |
| *       | 乘法  | ${20 * 20}             | 400 |
| / 或 div | 除法  | ${20 / 20 或 20 div 20} | 1   |
| % 或 mod | 取模  | ${10 %  3 或 10 mod 3}  | 1   |

#### empty运算

可以判断一个数据是否为空，如果为空，则输出true，不为空输出false

语法：${empty 数据}

```java
<%
    pageContext.setAttribute("key", null);
%>
${empty key}
```

#### 三元运算

语法：表达式1 ? 表达式2 : 表达式3

#### "." 点运算和 [] 中括号运算

"." 点运算：可以输出bean对象中某个属性的值

 [] 中括号运算：可以输出有序集合中某个元素的值，并且可以输出map集合中key里含有特殊字符的值key的值

### EL表达式的11个隐含对象

| 变量               | 类型                    | 作用                                    |
| ---------------- | --------------------- | ------------------------------------- |
| pageContext      | PageContextImpl       | 可以获取jsp中的九大内置对象                       |
| pageScope        | Map<String, Object>   | 可以获取pageContext域中的数据                  |
| requestScope     | Map<String, Object>   | 可以获取request域中的数据                      |
| sessionScope     | Map<String, Object>   | 可以获取session域中的数据                      |
| applicationScope | Map<String, Object>   | 可以获取ServletContext域中的数据               |
| param            | Map<String, String>   | 可以获取请求参数的值（一个）                        |
| paramValues      | Map<String, String[]> | 可以获取请求参数的值（多个）                        |
| header           | Map<String, String>   | 可以获取请求头的信息（一个）                        |
| headerValues     | Map<String, String[]> | 可以获取请求头的信息（多个）                        |
| cookie           | Map<String, Cookie>   | 可以获取当前请求的Cookie信息                     |
| initParam        | Map<String, String>   | 可以获取web.xml文件中配置的<context-param>上下文参数 |

#### 获取四大域中的属性

```java
<body>
    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    ${pageScope.key}<br>
    ${requestScope.key}<br>
    ${sessionScope.key}<br>
    ${applicationScope.key}<br>
</body>
```

#### pageContext对象

可以获取九大内置对象

```java
<body>
    协议：${pageContext.request.scheme}<br>
    服务器IP：${pageContext.request.serverName}<br>
    服务器端口：${pageContext.request.serverPort}<br>
    获取工程路径：${pageContext.request.contextPath}<br>
    获取请求方法：${pageContext.request.method}<br>
    获取客户端IP地址：${pageContext.request.remoteHost}<br>
    获取会话IP编号：${pageContext.session.id}<br>
</body>
```

#### 其他隐含对象

```java
<body>
    输出请求参数username的值：${param.username}<br>
    输出请求的username参数：${paramValues.username[0]}<br>
    输出请求头【User-Agent】的值（获取一个时）：${header["User-Agent"]}<br>
    输出请求头【User-Agent】的值（获取多个时）：${headerValues["User-Agent"][0]}<br>

    获取cookie的名称：${cookie.JSESSIONID.name}<br>
    获取cookie的值：${cookie.JSESSIONID.value}<br>

    获取参数的值：${initParam.username}
</body>
```
