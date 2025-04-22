---
layout : archive
title : Bean
categories : Java
date : 2024-12-23
---
## Bean

- 메서드 레벨에서 선언
- 외부 라이브러리가 제공하는 객체를 사용할 때 활용
- Bean을 사용시 Configuration 어노테이션을 반드시 사용

```java
## Qualifier

```java
@Configuration
public class Test {

    @Bean
    public int testBean() {
        return 123;
    }

    public int testNotAnnotationBean() {
        return 456;
    }

    public void execute() {
        System.out.println("Execute");
    }
}

@RestController
@RequiredArgsConstructor
public class TestController {

    private final int testBean;
    private final int testNotAnnotationBean;
    private final Test test;
    private final BannerRepository bannerRepository;

    @GetMapping("/api/test")
    public List<Banner> test() {

        // DI
        System.out.println(testBean); // 123
        System.out.println(testNotAnnotationBean); // 123
        // 스프링 컨테이너에 등록된 메서드가 없으면 같은 타입인 메서드의 반환값을 가져온다. 

        // Test 클래스의 메서드를 직접 호출
        System.out.println(test.testBean()); // 123
        System.out.println(test.testNotAnnotationBean()); // 456
        test.execute(); // Execute

        return bannerRepository.findAll();
    }
}
```

1. Bean을 사용하는 이유
- 동일한 역할을 수행하는 객체를 여러 번 만들지 않아도 됨
- 외부 라이브러리 객체 등록 -> 애플리케이션의 일관성 유지
- 빈의 생명 주기와 복잡한 객체 구성
- Mockito 라이브러리, @MockBean, @spyBean을 사용하여 테스트 용이