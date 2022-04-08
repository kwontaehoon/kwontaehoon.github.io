---
layout : post
title : H-index
categories : Programmers
date : 2022-03-28
---
> 문제<br>

H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

> 제한사항<br>

과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

> 입출력 예<br>

|citations|return|
|:--:|:--:|
|[3, 0, 6, 1, 5]|3|

> 코드
### JavaScript

<script src="https://gist.github.com/kwontaehoon/b5718d3b8c06fa0280fdbf71960a8a6f.js"></script>

* 참고

<script src="https://gist.github.com/kwontaehoon/e391896f444cc22a1ad71f14b27151d2.js"></script>
[출처]https://breathtaking-life.tistory.com/80
<br>

> 종합<br>

