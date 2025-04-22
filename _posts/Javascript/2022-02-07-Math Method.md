---
layout : archive
title : Math 함수
categories : Javascript
date : 2022-02-07
---
## 자바스크립트 Math
> Math.PI

```javascript
Math.PI;
```
* 원주율 값을 반환한다.

> Math.abs

```javascript
Math.abs(-2); // 2
Math.abs('-2'); // 2
Math.abs(''); // 0
Math.abs(); // NaN
```
* 인수로 전달된 숫자의 절대값을 반환한다.

> Math.round

```javascript
Math.round(1.7); // 2
Math.round(-8.4); // -8
Math.round(); // NaN
```
* 인수로 전달된 숫자의 소수점 이하를 반올림한 정수를 반환한다.

> Math.ceil

```javascript
Math.ceil(1.6); // 2
Math.ceil(-1.6); // -1
```
* 인수로 전달된 숫자의 소수점 이하를 올림한 정수를 반환한다.

> Math.floor

```javascript
Math.floor(1.8); 1
Math.floor(-1.8); // -2
```
* 인수로 전달된 숫자의 소수점 이하를 내림한 정수를 반환한다.
* 소수점 이하를 버린 수를 반환한다.

> Math.sqrt

```javascript
Math.sqrt(16); // 4
Math.sqrt(-5); // NaN
Math.sqrt(2); // 1.4...
Math.sqrt(1); // 1
Math.sqrt(0); // 0
```
* 인수로 전달된 숫자의 제곱근을 반환한다.

> Math.random

```javascript
const random = Math.floor(Math.random()*10);

const arr = [1, 6, 80, 41, 33]
const random = Math.floor(Math.random()*arr.length);
console.log(arr[random]); // 배열에서 랜덤한 값 추출
```
* 0에서 1미만의 랜덤한 **실수**를 반환한다.
* 랜덤한 정수를 구하기 위해서는 Math.floor 메서드와 같이 사용한다.
* 배열 length를 이용해서 랜덤한 값을 추출할 수도 있다.

> Math.pow

```javascript
Math.pow(2, 5); // 256
Math.pow(2, -1); // 0.5
Math.pow(2); // NaN
```
* 첫 번째 인수를 밑으로 두 번째 인수를 지수로 거듭제곱한 결과를 반환한다.

> Math.max / min

```javascript
Math.max(1, 2, 3);
Math.min(1, 2, 3);

// 배열 요소 중에서 최대값, 최소값
Math.max.apply(null, [1, 2, 3]); // 3
Math.min.apply(null, [1, 2, 3]); // 1
```
* 전달받은 인수 중에서 가장 큰 수/ 작은 수를 반환한다.