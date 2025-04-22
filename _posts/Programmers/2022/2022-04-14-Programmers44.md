---
layout : archive
title : 가장 큰 정사각형 찾기
categories : Programmers
date : 2022-04-14
---
> 문제<br>

1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
(단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

> 제한사항<br>

표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.

> 입출력 예<br>

|board|answer|
|:--:|:--:|
|[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]|9|
|[[0,0,1,1],[1,1,1,1]]|4|

> 코드

### JavaScript

<script src="https://gist.github.com/kwontaehoon/f177997c9435cb62cc3ed3f1369e560a.js"></script>

<br>

> 종합<br>

가로에서 1을 찾으면 0이 나올때까지 카운트를 하고 세로를 구한다.
세로를 구할때는 처음 1을 찾을때 인덱스로 구한다. 