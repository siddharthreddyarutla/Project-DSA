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