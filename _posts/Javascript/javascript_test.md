---
layout : post
title : test입니다
categories : Javascript
date : 2022-09-02
---

## HTTP 응답 상태 코드

> 1xx(information response)

* 100(Continue): 진행중
* 101(Switching Protocol): 클라이언트에 의해 보낸 업그레이드 요청 헤더에 대한 응답을 보낸다.
* 102(Processing): 서버가 요청을 수신하였으며 이를 처리하고 있지만 응답을 알려줄 수 없음을 보낸다.

<br>

> 2xx(Success category): 클라이언트 요청이 서버에서 성공

* 200(Ok): GET, PUT, POST 요청에 대한 성공 응답
* 201(Created): 요청이 성공적이었고 그 결과로 새로운 리소스가 생성되었다는 응답, 일반적으로 POST, PUT 요청에 대응
* 202(Accepted): 요청은 수신했지만 후속 액션을 할 수 없다는 코드
* 203(Non-Authoritive Information): 돌려받은 메타 정보 세트가 오리진 서버의 것과 일치하지 않음
* 204(No Content): 요청에 대해서 보내줄 수 있는 콘텐츠가 없지만 헤더는 의미있을 수 있음

<br>

> 3xx(Redirection message)

* 300(Multiple Choice): 요청에 대해서 하나 이상의 응답 가능
* 301(Moved Permanetly): 요청한 리소스의 URI가 변경되었음
* 302(Fount): 요청한 리소스의 URI가 일시적으로 변경되었음
* 304(Not Modified): 클라이언트에게 응답이 수정되지 않았음을 알려주며 클라이언트는 계속해서 응답의 캐시된 버전을 사용 할 수 있음
* 305(Use Proxy): 요청한 응답은 반드시 프록시를 통해서 접속해야 하는 것을 알려줌

<br>

> 4xx(Client error responses)

* 400(Bad Request): 잘못된 문법으로 인하여 서버가 요청을 의미할 수 없음을 의미
* 401(Unauthorized): 비승인
* 403(Forbidden): 클라이언트가 컨텐츠에 접근할 권한을 가지고 있지 않음
* 404(Not Found): 클라이언트의 요청 리소스를 서버가 찾을 수 없음
* 405(Method Not Allowed): 요청한 메소드는 서버에서 알고 있지만, 제거되었고 사용할 수 없는 경우
* 406(Not Acceptable): 서버가 서버 주도 콘텐츠 협상을 수행한 이후, 정해진 규격에 따른 어떠한 컨텐츠도 찾지 못했을 때 웹 서버에 보냄
* 407(Proxy Authentication Required): 프록시에 의해 완료된 인증 필요
* 408(Request Timeout): 지정된 요청 응답시간을 초과한 경우
* 409(Conflit): 요청이 현재 서버의상태와 충돌
* 410(Gone): 요청 컨텐츠가 서버에서 완전 삭제되었을 때 발생

<br>

> 5xx(Server Error)

* 500(Internal Server Error): 웹 서버에 에러 발생
* 501(Not Implemented): 클라이언트의 요청을 서버가 이행하는데 필요한 기능을 지원하지 않고 있음
* 502(Bad Gateway): 서버가 게이트웨어로부터 잘못된 응답을 수신했음, 인터넷상에서 서버가 다른 서버로부터 유효하지 않은 응답을 받은 경우 발생
* 503(Service Unavailable): 서버가 요청 처리를 위한 준비가 되어 있지 않은 상태
* 504(Gateway timeout): 웹 페이지를 로드하거나 브라우저에서 다른 요청을 태우려는 동안 서버가 액세스하고 있는 다른 서버에서 적시에 응답을 받지 못했을 경우 발생