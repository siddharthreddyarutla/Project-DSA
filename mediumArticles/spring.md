# Spring

## Improving spring performance

[Medium url](https://medium.com/@gaddamnaveen192/interview-how-would-you-optimize-the-performance-of-a-spring-boot-application-dea8e077d1dc)

## Try catch and finally

[Medium url](https://medium.com/@poojaauma/will-finally-block-execute-if-there-is-a-return-statement-in-catch-33380650e0d6)

## 300+ Spring Boot interview questions

[Medium article](https://codefarm0.medium.com/300-spring-boot-interview-questions-43393e1c2bef)

## Constructor injection vs field injection in spring
[Medium article](https://medium.com/devdomain/spring-boots-autowired-vs-constructor-injection-a-detailed-guide-1b19970d828e#:~:text=Field%20Injection%3A%20The%20userRepository%20field,final%20%2C%20preventing%20reassignment%20after%20construction.)

## @PostConstruct and @PreDestroy with modern solutions

[Medium article](https://medium.com/@gaddamnaveen192/springboot3-lifecycle-replace-postconstruct-and-predestroy-with-modern-solutions-219be6f4e9d5)


### GZIP Compression of API response

[Medium article](https://medium.com/@meena07jadhav/this-spring-boot-trick-made-my-rest-api-3x-faster-no-code-rewrite-required-ede46f7ea09f)

```java
server.compression.enabled=true
server.compression.mime-types=application/json,application/xml,text/html,text/plain
server.compression.min-response-size=1024
```

>Now every response larger than 1 KB is automatically GZIP-compressed — reducing payload size by up to 90%.


### Filter and interceptors

Both Filters and Interceptors are used to process requests in Spring, but they differ in terms of scope and usage. Let's break them down:

#### Filter

- Definition: Filters are part of the Servlet specification. They are part of the `javax.servlet` package and operate on HTTP requests and responses. Filters are used to perform tasks like logging, authentication, input validation, etc.

- Execution Scope: Filters are invoked before and after the servlet processing the request. They can modify the request and response objects.

- Implementation: Implement the `javax.servlet.Filter` interface.

```java
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic (optional)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request URI: " + httpRequest.getRequestURI());
        
        // Proceed with the next filter or target resource
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic (optional)
    }
}
```

#### Interceptors

- Definition: Interceptors are part of the Spring MVC framework. They provide additional processing for HTTP requests and responses at specific points, such as before the controller method, after the controller method, and after the complete request processing.

- Execution Scope: Interceptors work at the Handler level, meaning they operate within the Spring MVC context and can access controller-specific data.

- Implementation: Implement the HandlerInterceptor interface or extend HandlerInterceptorAdapter.

```java
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {
  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method: " + request.getRequestURI());
        return true;  // Proceed with the next interceptor or controller
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("After Completion method: " + request.getRequestURI());
    }
}

```

| **Aspect**                    | **Filter**                                  | **Interceptor**                                        |
| ----------------------------- | ------------------------------------------- | ------------------------------------------------------ |
| **Scope**                     | Servlet level (HTTP Request/Response)       | Spring MVC level (Handler methods)                     |
| **Package**                   | `javax.servlet.Filter`                      | `org.springframework.web.servlet.HandlerInterceptor`   |
| **Execution**                 | Before and after servlet processing         | Before, after controller, and after request completion |
| **Order**                     | Configured using `FilterRegistrationBean`   | Configured using `WebMvcConfigurer`                    |
| **Access to Controller Data** | No                                          | Yes                                                    |
| **Usage**                     | Authentication, logging, modifying requests | Logging, authorization, pre/post processing            |


### Transactional

[Medium url](https://medium.com/javarevisited/every-java-developer-misuses-transactional-6b96c7b91713)

#### Transactional Rules You Keep Forgetting

- ✅ Only works on public methods, called from outside via a Spring proxy.
- ❌ Doesn’t rollback on checked exceptions unless you say so. (Checked exceptions are compile time exceptions)
- 🤯 Nested methods share the same transaction unless told otherwise.


### Scaling 1M requests per sec

[Medium article](https://medium.com/@gaddamnaveen192/spring-boot-optimization-for-1m-requests-second-1e74ab08c942)


### Singleton and prototype beans

**Singleton Scope:**

- A single instance of the bean is created and shared across the entire Spring container.

- All requests for that bean will return the same instance.


**Prototype Scope:**

- If you want to create a new instance each time the bean is requested, you can set the scope to


### why spring cannot inject value for static fields if i use @value?

Spring cannot inject values into static fields using @Value because dependency injection in Spring works on instance-level, not class-level (static). Here's why:

**Why it doesn’t work for static fields**

- Spring's @Value, @Autowired, etc., work by creating and managing beans (object instances) in its ApplicationContext.

- When it creates a bean, it injects dependencies into that bean’s instance fields.

- However, static fields belong to the class itself, not any one instance — Spring does not manage class-level static context.

## Advanced spring 
[Medium article](https://medium.com/@pudarimadhavi99/advanced-spring-boot-concepts-every-java-developer-should-know-part-2-56f37d76f91a)