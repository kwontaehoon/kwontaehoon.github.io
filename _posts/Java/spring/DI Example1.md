---
layout : archive
title : DI example1
categories : Java
date : 2024-12-23
---
#### 의존성 주입 예시 1 (인터페이스의 재사용성)

```java
public class Store {

    private Pencil pencil;

    public Store() {
        this.pencil = new Pencil();
    }
}
```
- 문제점
1. Store에서 Pencil이 아닌 Food와 같은 다른 상품을 판매하고자 한다면 Store 클래스의 생성자에 변경이 필요
2. Store와 Pencil는 객체들 간의 관계가 아니라 클래스들 간의 관계가 맺어져 있다는 문제

- 해결방법
```java
// Product 인터페이스
public interface Product {
    String getData();
}

// Product의 구현체 1
@Service
public class ProductA implements Product {

    @Override
    public String getData() {
        return "Data from ProductA";
    }
}

// Product의 구현체 2
@Service
public class ProductB implements Product {

    @Override
    public String getData() {
        return "Data from ProductB";
    }
}

// Service 클래스
@Service
public class MyService {

    // 문제점
    private Product product;

    public MyService() {
        this.product = new ProductA(); // 특정 구현체를 직접 생성
    }

    // 필드 의존성 주입
    @Autowired
    private final Product product;

    // 생성자 의존성 주입 (필드보다 추천)
    private final Product product;

    @Autowired
    public MyService(Product product) {
        this.product = product;
    }
    /* */

    // RequiredArgsConstructor 어노테이션 사용 -> 생성자 자동 생성
    private final Product product;

}
```