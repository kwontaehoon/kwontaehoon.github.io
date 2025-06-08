---
layout : archive
title : React Profiler
categories : React
date : 2025-05-28
---
## React profiler

### React profiler란?

리액트 앱의 성능을 분석하고 최적화하는 데 도움을 주는 도구

### 도입 배경

React 랜더링을 최적화하기 위해 React에서 제공하는 useMemo, useCallback, React.memo를 사용하게 되었습니다. 랜더링 과정을 콘솔보다 다른 방법으로 추적이 가능한가 싶어서 찾아봤는데 React profiler라는 브라우저 확장 툴을 이용할 수 있었습니다. 따라서 React profiler를 이용해서 랜더링 추적을 하고 최적화 해보겠습니다.

### 최적화 hooks

- useMemo: 연산 결과를 메모이제이션 (값)
- useCallback: 함수를 메모이제이션 (함수)
- React.memo: 컴포넌트 메모이제이션 (컴포넌트)

### 랜더링 최적화 방법

부모 컴포넌트에서 리렌더링이 발생했을 때 자식 컴포넌트는 무조건 리렌더링이 발생합니다.
여기서 문제는 부모나 자식 컴포넌트 어디에서 오래걸리는 연산작업이 발생한다면 리렌더링이 발생함과 동시에 오래걸리는 연산작업이 다시 한번 이루어지기 때문에 랜더링의 시간적인 부분에 문제가 발생합니다. 따라서 아래와 같은 방법으로 리렌더링을 방지합니다.

- 원시 타입을 props로 넘길 때
값 자체로 비교 하기 때문에 자식 컴포넌트에 React.memo를 사용하여 리렌더링 방지

<br />

> why? 원시 타입?

string, number, boolean, null, undefined, symbol, bigint 등

<br />

- 객체 타입을 props로 넘길 때
참조값으로 비교 하기 때문에 새로 생성되면 내용이 같아도 다르다고 판단, 따라서 React.memo와 useMemo / useCallback을 사용하여 참조값을 메모이제이션하여 리렌더링 방지

<br />

> why? 객체 타입?

Object, Array, Function, Date, Map, Set 등

<br />

### React profiler

React 렌더링 과정을 추적할 수 있는 브라우저 확장 툴로 아래 사진처럼 어떤 컴포넌트가 렌더링 되었고 메모이제이션이 되었는지 추적이 가능

- Flamegraph

<img src="https://tong-bucket.s3.ap-northeast-2.amazonaws.com/react_profiler_flamegraph.PNG">

- ranked

<img src="https://tong-bucket.s3.ap-northeast-2.amazonaws.com/react_profiler_ranked.PNG" />