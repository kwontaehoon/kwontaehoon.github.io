---
layout : post
title : String 함수
categories : Javascript
date : 2022-02-08
---
## String 함수
> String.prototype.indexOf

```javascript
const str = 'Hello world';

str.indexOf('o'); // 4
str.indexOf('l', 2); // 3 인덱스 2부터 'l' 검색
str.indexOf('x'); // -1
```
* 대상 문자열에서 인수로 전달받을 검색하여 첫 번째 인덱스를 반환한다.
* 검색에 실패하면 -1을 반환한다.

<br>

> String.prototype.search

```javascript
const str = 'Hello world';

str.search(/o/); // 4
str.search(/x/); // -1
```
* 대상 문자열에서 인수로 전달받은 정규 표현식과 매치하는 문자열을 검색하여 일치하는 문자열의 인덱스를 반환한다.
* 검색에 실패하면 -1을 반환한다.

<br>

> String.prototype.includes

```javascript
const str = 'Hello world';

str.includes('Hello'); // true
str.includes(''); // true
str.includes(); // false

str.includes('l', 3); // true
```
* 대상 문자열에 인수로 전달받은 문자열이 포함되어 있는지 확인하여 true/false를 반환한다.
* 2번째 인수로 검색을 시작할 인덱스를 전달한다.

<br>

> String.prototype.startWith

```javascript
const str = 'Hello world';

str.startWith('He'); // true
str.startWith(' ', 5); // true
```
* 대상 문자열이 인수로 전달받은 문자열로 시작하는지 확인하여 true/false를 반환한다.
* 2번째 인수를 검색을 시작할 인덱스를 전달한다.

<br>

> String.prototype.endsWith

```javascript
const str = 'Hello world';

str.endsWith('ld'); // true
str.endsWith('t'); // false
str.endsWith('lo', 5); // true
```
* 대상 문자열이 인수로 전달받은 문자열로 끝나는지 확인하여 true/false를 반환한다.
* 2번째 인수로 검색할 문자열의 길이를 전달한다.

<br>

> String.prototype.charAt

```javascript
const str = 'Hello';

for(let i=0; i<str.length; i++){
    console.log(str.charAt(i);) // Hello
}

str.charAt(5); // ''
```
* 대상 문자열에서 인수로 전달받은 인덱스에 위치할 문자를 검색하여 반환한다.

<br>

> String.prototype.substsring

```javascript
const str = 'Hello world';

str.substring(2, 4); // llo

str.substring(-5); // Hello world
```
* 대상 문자열에서 첫 번째 인수로 전달받은 인덱스에 위치하는 문자부터 두 번째 인수로 전달받은 인덱스에 위치하는 문자의 이전 문자까지의 부분 문자열을 반환한다.
* 인수 < 0 또는 NaN인 경우 0으로 취급된다.

<br>

> String.prototype.slice

```javascript
const str = 'Hello world';

str.slice(0, 5); // Hello

str.slice(-5); // world
```
* substring과 똑같이 동작하지만 음수인 경우 뒤에서 인수만큼 잘라내어 반환한다.

<br>

> String.prototype.toUpperCase / toLowerCase

```javascript
const str = 'Hello world';

str.toUpperCase(); // HELLO WORLD

str.toLowerCase(); // hello world
```
* toUpperCase는 대상 문자열을 모두 대문자로 변경한 문자열을 반환한다.
* toLowerCase는 대상 문자열을 모두 소문자로 변경한 문자열을 반환한다.

<br>

> String.prototype.trim

```javascript
const str = '    Hello world ';

str.trim(); // Helloworld
```
* 대상 문자열 앞뒤에 공백 문자가 있을 경우 제거한 문자열을 반환한다.

<br>

> String.prototype.repeat

```javascript
const str = 'abc'

str.repeat(); // ''
str.repeat(1); // abc
str.repeat(2); // abc
str.repeat(-1); // Error : Invalid count value
```
* 대상 문자열을 인수로 전달받은 정수만큼 반복해 연결한 새로운 문자열을 반환한다.

<br>

> String.prototype.replace

```javascript
const str = 'Hello world';

str.replace('world', 'Lee'); // Hello Lee

const str2 = 'Hello world world';
str2.replace('world', 'Lee'); // Hello Lee world
```
* 대상 문자열에서 첫 번째 인수로 전달받은 문자열 또는 정규표현식을 검색하여 두 번째 인수로 전달한 문자열로 치환한 문자열을 반환한다.

<br>

> String.prototype.split

```javascript
const str = 'Hello world !';

str.split(' '); // ["Hello", "world", "!"]

str.split(' ', 1); // ["Hello"]
```
* 대상 문자열에서 첫 번째 인수로 전달한 문자열 또는 정규 표현식을 검색하여 문자열을 구분한 후 분리된 각 문자열로 이루어진 배열을 반환한다.
* 두 번째 인수로 배열의 길이를 지정할 수 있다.