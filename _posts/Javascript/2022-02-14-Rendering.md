---
layout : archive
title : 렌더링 과정
categories : Javascript
date : 2022-02-14
---
## 서론

자바스크립트는 웹 브라우저 환경에서도 동작하는 웹 페이지/애플리케이션의 클라이언트 사이드 이므로 HTML, CSS와 함께 실행된다. 이를 위해 브라우저는 HTML, CSS, 자바스크립트로 작성된 문서를 어떻게 파싱하여 브라우저에 렌더링하는지 과정을 알아보자.

<br>

## 자바스크립트 렌더링 과정

* 파싱 : 프로그래밍 언어의 문법에 맞게 텍스트 문서를 읽어 들여 실행하기 위해 텍스트 문서의 문자열을 토큰으로 분해하는 것 <br>

* 렌더링 : HTML, CSS, 자바스크립트로 작성된 문서를 파싱하여 브라우저에 시각적으로 출력하는 것 <br>

* DOM : HTML 문서를 파싱하여 브라우저가 이해할 수 있는 자료구조

> 렌더링 과정

1. 브라우저는 HTML, CSS, 자바스크립트 등 렌더링에 필요한 리소스를 요청하고 서버로부터 응답 받는다.<br>

2. 브라우저의 렌더링 엔진은 서버로부터 응답된 HTML과 CSS를 파싱하여 DOM과 CSSOM을 생성하고 렌더 트리를 생성한다.<br>

3. 브라우저의 자바스크립트 엔진은 서버로부터 응답된 자바스크립트를 파싱한다.<br>

4. HTML 요소의 레이아웃을 계산하고 브라우저 화면에 HTML 요소를 페인팅한다.<br>

> script 태그의 위치에 따른 블로킹

* head 태그에 위치할 경우 : DOM이 완성되지 않은 상태에서 조작하므로 에러가 발생할 수 있다. 하지만 HTML 요소들의 렌더링에 지장받는 일이 없어서 페이지 로딩 시간이 단축된다. <br>

* body 태그에 위치할 경우 : 이미 HTML 요소를 모두 파싱하여 DOM 생성을 완료한 이후기 때문에 자바스크립트가 DOM을 조작하는 에러가 발생할 우려가 없으며 페이지 로딩 신간이 단축된다. <br>

* async : 외부 자바스크립트 파일을 로드하는 경우, HTML 파싱과 외부 자바스크립트 파일의 로드가 비동기적으로 동시에 진행된다. 자바스크립트의 파싱과 실행은 HTML 파싱이 중된될 때 실행된다. <br>

* defer : 외부 자바스크립트 파일을 로드하는 경우, HTML 파싱과 외부 자바스크립트 파일의 로드가 비동기적으로 동시에 진행된다. 자바스크립트의 파싱과 실행은  HTML 파싱이 완료된 직후 진행된다. <br>

## 마무리

