---
title : post
layout : Markdown 가이드
---

< 특수 문자 >

**입력**
\# test
\* test

**출력**
# test
* test

< Heading >

**입력**
\# Heading 1
\## Heading 2
\### Heading 3
\#### Heading 4
\##### Heading 5

**출력**
# Heading 1
## Heading 2
### Heading 3
#### Heading 4
##### Heading 5
<br>

< Quote >

**입력**
\> test
\* 목록 1
\* 목록 2
\- 목록 3
\- 목록 4

**출력**
>test
* 목록1
* 목록2
1. 숫자 목록 1
2. 숫자 목록 2

< Link >

**입력**
Click [here]\(주소)
\![imge description]\(주소)

**출력**
Click [here](주소)
![image description](주소)

< Table >

**입력** (:으로 정렬가능)
\|Header|Description|
\|--: |:--: |
\|cell1|cell2|

**출력**
|Header|Description|
|--:|:--:|
|cell1|cell2|

< code >

**입력**
\```javascript
console.log();
\```

**출력**

```javascript
console.log();
```







