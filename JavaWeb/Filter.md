## Filter过滤器

Filter过滤器是JavaWeb三大组件之一

Filter过滤器是JavaEE的规范，也就是接口

Filter过滤器的作用是：拦截请求，过滤响应

- 拦截请求常用场景：权限检查、日记操作、事务管理等

### 基本使用

新建一个类 --> 继承 javax.servlet.Filter类，并重写方法

```java
public class AdminFilter implements Filter {
    /**
     * 专门用于拦截请求
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
```

### 实现拦截请求

新建一个类 --> 继承 javax.servlet.Filter类，并重写方法，编写代码

**filterChain.doFilter(servletRequest, servletResponse)：使代码往下执行**

```java
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            System.out.println("用户未登录");
            return;
        }
        System.out.println("用户登录成功");
        // 程序继续往下执行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

在web.xml文件中编写Filter的配置：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!-- 用于配置一个Filter过滤器 -->
    <filter>
        <!-- 起别名 -->
        <filter-name>AdminFilter</filter-name>
        <!-- 全类名 -->
        <filter-class>com.lcxuan.filter.AdminFilter</filter-class>
    </filter>
    <!-- 配置拦截路径 -->
    <filter-mapping>
        <!-- 哪个filter来拦截 -->
        <filter-name>AdminFilter</filter-name>
        <!--
            配置拦截路径
            /：表示拦截的请求地址为：http://ip:port/工程路径/
            /admin/*：表示拦截的请求路径为：http://ip:port/工程路径/admin/*
         -->
        <url-pattern>/admin/*</url-pattern>
    </filter-mapping>
</web-app>
```

### Filter的生命周期

包含几个方法：

- 构造器方法

- init初始化方法
  
  - 以上两步，在web工程启动的时候执行（Filter已经创建）

- doFilter过滤方法
  
  - 每次拦截到请求，就会执行

- destroy销毁方法
  
  - 停止web工程的时候，就会执行，会将Filter‘过滤器销毁


