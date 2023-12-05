---
layout : post
title : 서울에서 김서방 찾기
categories : Programmers
date : 2023-12-04
---
> 문제<br>

String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

> 제한사항<br>

seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
"Kim"은 반드시 seoul 안에 포함되어 있습니다.

> 입출력 예<br>

|seoul|return|
|:--:|:--:|
|["Jane", "Kim"]|"김서방은 1에있다"|

> 코드

### JavaScript

<script src="https://gist.github.com/kwontaehoon/7a65ab5eeed45d2685c23d72f5e4cd3f.js"></script>