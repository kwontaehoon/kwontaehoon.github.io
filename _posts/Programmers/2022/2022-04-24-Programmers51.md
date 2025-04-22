---
layout : archive
title : 가장 먼 노드
categories : Programmers
date : 2022-04-24
---
> 문제<br>

n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

> 제한사항<br>

노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

> 입출력 예<br>

|n|vertex|return|
|:--:|:--:|:--:|
|6|[[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]]|3|

> 코드
### JavaScript

<script src="https://gist.github.com/kwontaehoon/52c0d68722fddbcac8a8e1520a6dbb91.js"></script>

<br>

* 참고

<script src="https://gist.github.com/kwontaehoon/6082534ab64634fa929ac72e0df9f0a2.js"></script>

[출처]https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.3-%EA%B0%80%EC%9E%A5-%EB%A8%BC-%EB%85%B8%EB%93%9C-JS

> 종합<br>

객체를 이용해서 비슷한 문제를 푼적이있었는데 이 문제처럼 배열을 자를 때 전체 배열의 길이도 줄어준다는 점을 감안하여 새로운 배열에서 작업을 했다. 그러다보니 while문을 실행할때마다 새로울 배열에서 나온 값들을 할당해줘야하기때문에 변수가 많이 필요했다.
참고는 너비우선탐색방법인 BFS로 구현을 했는데 확실히 가장 먼노드의 갯수를 구하는 문제에서 활용한다면 쉽게 구할 수 있는것같다. BFS와 더불어 DFS까지 같이 공부해봐야겠다.
