
> JWT Security
- 기본적으로 Basic Authentication 사용
  - Stateless
  - 요청마다 Authorization 헤더로 전송
  - 

1. 서버 실행 시 SecurityFilterChain은 DelegatingFilterProxty에 의해서 한 번 실행되어 필터 체인을 초기화 (필터 체인은 HTTP 요청마다 실행됨)
2. 클라이언트에서 HTTP 요청을 보내면 SecurityFilterChain 실행
3. UsernamePasswordAuthentication으로 JwtAuthenticationFilter 실행
4. Jwt 설정에 따라서 JwtTokenProvider 실행
5. Java Servlet FilterAPI의 핵심 메서드인 doFilter가 실행되면서 필터 체인에서 요청과 응답을 처리하거나 다음 필터로 전달하는 역할 수행

```java

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers("/api/login", "/api/signup").permitAll() // 비교
                                .anyRequest().authenticated()

                )
                .formLogin(form -> form
                        .loginPage("/login") // 비교
                        .permitAll()
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails userDetails = User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            // .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}

```