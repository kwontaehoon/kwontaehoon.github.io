---
layout : archive
title : 내적
categories : Programmers
date : 2023-12-07
---
> 문제<br>

길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)


> 제한사항<br>

a, b의 길이는 1 이상 1,000 이하입니다.
a, b의 모든 수는 -1,000 이상 1,000 이하입니다.

> 입출력 예<br>

|a|b|result|
|:--:|:--:|:--:|
|[1,2,3,4]|[-3,-1,0,2]|3|
|[-1,0,1]|[1,0,-1]|-2|

> 코드

### JavaScript

<script src="https://gist.github.com/kwontaehoon/5470b3224262c9e629e82fff4d6b516b.js"></script>