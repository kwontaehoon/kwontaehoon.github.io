## Spring Security

> 정의
- 일반적인 공격에 대한 인증, 권한 부여 및 보호를 제공하는 프레임워크
- 명령형 및 반응형 애플리케이션 모두를 보호하기 위한 일류 지원

> 기능
- 모든 엔드포인트에 대해 인증된 사용자 필요
- 시작 시 생성된 비밀번호로 기본 사용자 등록
- BCrypt 및 기타 항목으로 암호 저장소 보호
- 양식 기반 로그인 및 로그아웃 흐름 제공
- 양식 기반 로그인 및 HTRTP Basic 인증
- CSRF 공격 완화
- 세션 고정 공격 완화
- HTTPS를 보장하기 위해 Strict-Transport-Security 작성
- 스니핑 공격을 완화하기 위해 X-Content-Type-Options 작성
- 인증된 리소스를 보호하는 Cache Control 헤더 사용
- 클릭재킹을 완화하기 위해 X-Frame-Options 작성
- HttpsServletRequest 인증 방법과 통합
- 인증 성공 및 실패 이벤트 게시

> 아키텍처
- Filter 기반으로 동작
- Filter 종류
  - SecurityContext PersistenceFilter
  - LogoutFilter
  - UsernamePasswordAuthenticationFilter
  - DefaultLoginPageGeneratingFilter
  - BasicAuthenticationFilter
  - RememberMeAuthenticationFilter
  ...

1. AuthenticationFilter
2. UsernamePasswordAuthentication Token
3. AuthenticationManager <<interface>> - ProviderManager
4. AuthenticationProvider
5. UserDetailsService
6. UserDetails
7. AuthenticationProvider
8. AuthenticationManager
9. AuthenticationFilter
10. SecurityContextHolder

1. 사용자가 폼에 아이디, 비밀번호를 입력하면 HTTPServletRequest에 아이디, 비밀번호 정보가 전달됨
2. AuthenticationFilter가 넘어온 아이디와 비밀번호의 유효성 검사 실시
3. 유효성 검사 후 실제 구현체인 UsernamePasswordAuthenticationToken을 만들어 넘겨줌
4. AuthenticationFilter는 받아온 Token을 AuthenticationManager에게 넘김
5. Token을 다시 AuthenticationProvider에게 전달
6. 사용자 아이디를 UserDetailsService로 보냄
7. UserDetailsService는 사용자 아이디로 찾은 사용자의 정보를 UserDetails 객체로 만들어 AutheicationProvider에게 전달
8. DB에 있는 사용자 정보를 가져옴
9. 입력 정보와 UserDetails의 정보를 비교해서 실제 인증 처리 진행
10. 검증된 인증 객체를 AuthenticationFilter에게 전달
11. 검증된 인증 객체를 SecurityContextHolder의 SecurityContext에 저장