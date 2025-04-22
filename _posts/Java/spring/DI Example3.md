---
layout : archive
title : DI example3
categories : Java
date : 2024-12-23
---
#### 의존성 주입 예시 3 (약한 / 느슨한 결합)

```java
// 인터페이스 정의
public interface Service {
    void doSomething();
}

// 인터페이스 구현체 1
public class ServiceImpl implements Service {

    @Override
    public void doSomething() {
        System.out.println("Doing something in ServiceImpl");
    }
}

// 인터페이스 구현체 2
public class AnotherServiceImpl implements Service {

    @Override
    public void doSomething() {
        System.out.println("Doing something in AnotherServiceImpl");
    }
}

// 의존성 주입을 통해 느슨한 결합 구현
public class A {
    private final Service service;

    // 생성자 주입
    public A(Service service) {
        this.service = service;
    }

    public void performAction() {
        service.doSomething();
    }

    public static void main(String[] args) {
        // ServiceImpl 주입
        Service service1 = new ServiceImpl();
        A a1 = new A(service1);
        a1.performAction();

        // AnotherServiceImpl 주입
        Service service2 = new AnotherServiceImpl();
        A a2 = new A(service2);
        a2.performAction();
    }
}
```