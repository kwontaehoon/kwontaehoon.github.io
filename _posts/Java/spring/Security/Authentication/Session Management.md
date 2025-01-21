#### Session Management

> 기능
- 세션 관리의 구성 요소 이해
- 사용자가 동시에 로그인할 수 있는 횟수 제한 가능
- Spring Security가 인증을 하는 대신 직접 인증 가능
- 인증을 수동으로 저장하고 있으며 제거 가능
- SessionMnagementFilter를 사용하고 있으며 그 효과에서 벗어나는 방법 필요
- 세션이 아닌 다른 곳에 인증 저장 가능

##  인증이 저장되는 위치 사용자 지정

기본적으로 Spring Security는 HTTP 세션에 보안 컨텍스트를 저장
- 인스턴스에서 개별 setter를 호출할 수 있음 HttpSessionSecurityContextRepository
- 보안 컨텍스트를 캐시 또는 데이터베이스에 저장하여 수평적 크기 조정을 사용할 수 있음 SecurityContextRepository HttpSessionSecurityContextRepository HttpSecurity

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) {
    SecurityContextRepository repo = new MyCustomSecurityContextRepository();
    http
        // ...
        .securityContext((context) -> context
            .securityContextRepository(repo)
        );
    return http.build();
}
```

수동으로 저장할 경우
```java
private SecurityContextRepository securityContextRepository =
        new HttpSessionSecurityContextRepository(); // 1

@PostMapping("/login")
public void login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) { // 2
    UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
        loginRequest.getUsername(), loginRequest.getPassword()); // 3
    Authentication authentication = authenticationManager.authenticate(token); // 4
    SecurityContext context = securityContextHolderStrategy.createEmptyContext();
    context.setAuthentication(authentication); // 5
    securityContextHolderStrategy.setContext(context);
    securityContextRepository.saveContext(context, request, response); // 6
}

class LoginRequest {

    private String username;
    private String password;

    // getters and setters
}
```
1. 컨트롤러에 추가SecurityContextRepository
2. 를 주입하고 저장할 수 있습니다. HttpServletRequestHttpServletResponseSecurityContext
3. 제공된 자격 증명을 사용하여 인증되지 않은 자격 증명을 만듭니다.UsernamePasswordAuthenticationToken
4. 사용자를 인증하기 위한 호출AuthenticationManager#authenticate
5. a를 만들고 그 안에 설정하십시오.SecurityContextAuthentication
6. 에 저장 SecurityContextSecurityContextRepository


## 사용하지 않을 때 SessionCreationPolicy.STATELESS

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) {
    http
        // ...
        .sessionManagement((session) -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
    return http.build();
}
```

## Concurrent Session Control 구성
- 단일 사용자가 애플리케이션에 로그인하는 기능에 제약 조건을 적용하려는 경우 -> 사용자가 여러번 로그인하는 것 방지 가능 / 두 번째 로그인은 첫 번째 로그인 무효화 가능


## 시간 초과 감지


## 로그아웃시 세션 쿠기 지우기