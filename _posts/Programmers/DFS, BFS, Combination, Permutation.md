---
layout : archive
title : DFS, BFS, 조합과 순열
categories : Programmers
date : 2022-05-12
---
## 서론

Programmers 문제나 배열 관련된 문제를 풀어보면 깊이 우선 탐색(DFS: Depth First Serach)와 BFS(BFS: Breadth First Serach)를 자주 사용하는것을 볼 수 있다. DFS와 BFS와 동작 방식을 코드로 표현해보았다. 

<br>

###### DFS : 루트 노드에서 시작해서 해당 행을 완벽하게 탐색하는 방식, 주로 모든 노드를 방문하고 싶을 때 이 방법을 자주 사용한다.<br>

###### BFS : 루트 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방식, 주로 최단 경로를 찾고 싶을 때 이 방법을 자주 사용한다. <br>

<br>


1. DFS <br>

### JavaScript

<script src="https://gist.github.com/kwontaehoon/f44ba5d8310726c7cfadf11d8e8fa371.js"></script>

[출처]https://velog.io/@sangbooom/JS-BFS-DFS

2. BFS <br>

### JavaScript

<script src="https://gist.github.com/kwontaehoon/e884115600b62098459987d6483687c4.js"></script>

[출처]https://velog.io/@sangbooom/JS-BFS-DFS

3. 조합 <br>

### JavaScript

<script src="https://gist.github.com/kwontaehoon/bb37e5f61b4d5f8a18108ba02e49de24.js"></script>

[출처]https://velog.io/@devjade/JavaScript%EB%A1%9C-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0

3. 순열 <br>

### JavaScript

<script src="https://gist.github.com/kwontaehoon/0e98be199351cbba3a42f39b2f134c87.js"></script>

[출처]https://velog.io/@devjade/JavaScript%EB%A1%9C-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0

## 마무리

DFS, BFS, Combination, Permutation까지는 코드를 까보며 이해를 했지만 2차원배열에서 조합과 순열에대해서는 for문만 쓸줄알뿐 재귀함수로 표현하기엔 아직 어려웠다. 조합과 순열과 비슷한 개념인 경우의 수를 묻는 문제가 많을거같으니 2차원배열은 천천히 구현해봐야겠다.





