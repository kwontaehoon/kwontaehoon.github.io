---
layout : post
title : Number 함수
categories : Javascript
date : 2022-02-07
---
## 자바스크립트 Number Method
>  Number.isFinite

```javascript
Number.isFinite(0); // true
Number.isFinite(Number.Max_VALUE); // true

Number.isFinite(Infinity); // false
Number.isFinite(-Infinity); // false
Number.isFinite(null); // false

isFinite(null); // true
```
* 유한수 true, 무한수 false 반환
* isFinite는 암묵적으로 null을 0으로 타입 변환 

> Number.isInteger

```javascript
Number.isInteger(1234); // true
Number.isInteger(-1234); // true

Number.isInteger('1234'); // false
Number.isInteger(0.7); // false
```
* 정수 true, 정수가 아니면 false 반환한다.

> Number.isNaN

```javascript
Number.isNaN(NaN); // true

Number.isNaN(undefined); // false
isNaN(undefined); // true
```
* NaN 이면 true 반환한다.
* isNaN은 암묵적으로 undefined를 NaN으로 타입 변환한다.

> Number.prototype.toFixed

```javascript
(123.456).toFixed(); // "123"
(123.456).toFixed(1); // "123.5"
```
* 숫자를 반올림하여 문자열 반환한다.
* 인수를 생략하면 기본값 0 저장한다.

> Number.prototype.toString

```javascript
(10).toString(); // 10진수 10
(10).toString(2); // 2진수 101
(15).toString(8); // 8진수 17
```
* 숫자를 문자열로 반환한 후 진법을 나타내는 정수 값을 반환한다.