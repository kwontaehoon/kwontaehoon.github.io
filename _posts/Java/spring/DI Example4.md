---
layout : archive
title : DI example4
categories : Java
date : 2024-12-23
---
#### 의존성 주입 예시 4 (의존성 미주입)

```java
// Test class
@Configuration
public class Test {
  
  // @Bean o
  @Bean
  public int TestBean() {
    return 123;
  }

  // @Bean x
  public int TestNotAnotationBean() {
    return 456;
  }
  
  public void execute() {
    System.out.println("execute");
  }
}

// TestController
@RestController
@RequiredArgsConstructor
public class TestController {

  private int testBean; // 원시타입이라 런타임 에러는 안나지만 초기값 0으로 초기화
  private final int testBean;
  private Test test; // 객체타입은 final 키워드를 안쓰면 초기값 null 에러 발생
  private final Test test;

  @GetMapping("/api/test")
  public void test() {
    System.out.println(TestBean); // final 키워드가 없으면 0 아니면 123
    System.out.println(TestNotAnotationBean); // 456
    test.execute(); // execute
  }
}
```