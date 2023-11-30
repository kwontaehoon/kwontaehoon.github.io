---
layout : post
title : 가장 큰 수
categories : Programmers
date : 2022-02-15
---
> 문제<br>

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는
가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

> 제한사항<br>

numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

> 입출력 예<br>

|numbers|return|
|:--:|:--:|
|[6, 10, 2]|"6210"|
|[3, 30, 34, 5, 9]|"9534330|

> 코드
### JavaScript

<script src="https://gist.github.com/kwontaehoon/27aeb85c50c1b7bd62adca431185f01c.js"></script>

* 참고

<script src="https://gist.github.com/kwontaehoon/fa735fdc7880b939b950801f323d502c.js"></script>

[출처] https://velog.io/@fastpace04/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4JavaScript-%EA%B0%80%EC%9E%A5-%ED%81%B0-%EC%88%98

<br>

> 종합<br>

핵심코드는 sort((a, b) => b + a - (a + b))이다. 처음에는 splice 함수를 이용해서 문자열로 변환 후 각 자릿수를 더하려고했으나 sort 함수를 쓰면 간편하게 나올것같아서 생각을 바꿨다. 문자열에서 숫자의 크기나 최댓값 최솟값을 묻는 문제가 나온다면 sort함수는 유용하게 쓰일것같다.