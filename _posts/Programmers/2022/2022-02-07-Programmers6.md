---
layout : post
title : 음양 더하기
categories : Programmers
date : 2022-02-07
---
> 문제<br>

어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.

> 제한사항<br>

absolutes의 길이는 1 이상 1,000 이하입니다.
absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
signs의 길이는 absolutes의 길이와 같습니다.
signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.

> 입출력 예<br>

|absolutes|signs|result|
|:--:|:--:|:--:|
|[4,7,12]|[true,false,true]|9|
|[1,2,3]|[false,false,true]|0|

> 코드
### JavaScript

* for문
<script src="https://gist.github.com/kwontaehoon/cd5d29c8db5677ee9addb6bc95a92ae0.js"></script>

* reduce문
<script src="https://gist.github.com/kwontaehoon/5727bb7614b6ac4264d5ea5a21598a1c.js"></script>

* Refactorting
<script src="https://gist.github.com/kwontaehoon/bb98b9c8e806644034c99be0786be3fd.js"></script>

