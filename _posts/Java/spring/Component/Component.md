---
layout : archive
title : Component
categories : Java
date : 2024-12-23
---
## Compoenent

- 클래스 레벨에서 선언
- 스프링 컨테이너에 빈(Bean)을 등록하기 위해 사용

```java
@Component
public class PasswordEncoder {
  
    public String encode(String seed) {
        return new BCryptPasswordEncoder().encode(seed);
    }

    public boolean matches(String seed, String password) {
        return new BCryptPasswordEncoder().matches(seed, password);
    }
}
```
