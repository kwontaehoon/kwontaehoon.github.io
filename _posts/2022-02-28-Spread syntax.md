---
layout : post
title : 스프레드 문법
categories : Javascript
date : 2022-02-28
---
## 서론

스프레드 문법을 사용하면 배열뿐만아니라 객체 리터럴에서도 ES5에서 사용하던 방식보다 간결하고 가독성 좋게 표현 할 수 있다.
함수처럼 잘 만 사용하면 좋은 스프레드 문법에 대해 알아보자.

<br>

> 스프레드 문법이란?

* ES6부터 도입된 스프레드 문법은  하나로 뭉쳐진 여러 값들의 집합을 펼쳐서 개별적인 값들의 목록을 만드는 문법이다.

* Array, String, Set, Map, DOM과 같이 for...of문으로 순회할 수 있는 이터러블에 한정한다.

* 여기서 이터러블은 어터러블 프로토콜을 준수한 객체를 가리키는데 for...of문으로 순회할 수 있는 자료구조라고 할 수 있다.

* 스프레드 문법을 사용하면 더욱 간결하고 가독성 좋게 표현할 수 있다.

<br>

> 배열에서 사용하는 스프레드 문법

```javascript

// 최댓값
const arr = [1, 2, 3];

var max = Math.max(...arr); // 3

// concat
const arr = [1, 2].concat([3, 4]);
console.log(arr); // [1, 2, 3, 4]

const arr = [...[1, 2], ...[3, 4]];
console.log(arr); // [1, 2, 3, 4]

// splice
var arr1 = [1, 4];
var arr2 = [2, 3];
arr1.splice(1, 0, arr2);
console.log(arr1); // [1, [2, 3], 4]

const arr1 = [1, 4];
const arr2 = [2, 3];
arr1.splice(1, 0, ...arr2);
console.log(arr1); // [1, 2, 3, 4]

// slice
var arr = [1, 2];
var copy = arr.slice();
console.log(copy); // [1, 2]

const arr = [1, 2];
const copy = [...arr];
console.log(copy); // [1, 2]
```

> 객체 리터럴 내부에서 사용하는 스프레드 문법

<br>

```javascript

// 객체 병합
const merged = { ...{x : 1, y : 2}, ...{y : 10, z : 3}};
console.log(merged); // { x : 1, y : 10, z : 3 }

// 프로퍼티 변경
const changed = { ...{x : 1, y : 2}, y : 100};
console.log(changed); // { x : 1, y : 100}

// 프로퍼티 추가
const added = { ...{ x : 1, y : 2}, z : 10 };
console.log(added); // { x : 1, y : 2, z : 0}
```