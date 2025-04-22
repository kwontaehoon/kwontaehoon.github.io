---
layout : archive
title : DI example2
categories : Java
date : 2024-12-23
---
#### 의존성 주입 예시 2

```java

public class Service {
    private Repository repository;

    public Service() {
        this.repository = new Repository(); // Repository 구현체 직접 생성
    }

    public void doSomething() {
        System.out.println(repository.getData());
    }
}

public class Repository {
    public String getData() {
        return "Data from Repository";
    }
}

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.doSomething();
    }
}
```

- 새로운 구현체를 추가할 경우

```java
public class CustomRepository extends Repository {

    @Override
    public String getData() {
        return "Data from CustomRepository";
    }
}

public class Service {
    private Repository repository;

    public Service() {
        // 기존 구현체를 다른 구현체로 교체
        this.repository = new CustomRepository(); // CustomRepository로 변경
    }

    public void doSomething() {
        System.out.println(repository.getData());
    }
}
```
- 문제점
1. Service 클래스는 특정 구현체(Repository 또는 CustomRepository)에 강하게 결합되어 있다.
2. 새로운 구현체가 추가되면 Service 코드를 반드시 수정해야 한다.

- 해결방법

```java
// 인터페이스 정의
public interface Repository {
    String getData();
}

// 기본 구현체
@Component
public class DefaultRepository implements Repository {

    @Override
    public String getData() {
        return "Data from DefaultRepository";
    }
}

// 커스텀 구현체
@Component
public class CustomRepository implements Repository {
  
    @Override
    public String getData() {
        return "Data from CustomRepository";
    }
}

// 서비스 클래스
@Service
public class MyService {
    private final Repository repository;

    // 의존성 주입
    @Autowired
    public MyService(Repository repository) {
        this.repository = repository;
    }

    public void doSomething() {
        System.out.println(repository.getData());
    }
}
```