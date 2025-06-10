---
layout : archive
title : Context API
categories : React
date : 2025-06-10
---

## Context API

React에서 사용하는 전역 상태 관리로 React 공식 내장 도구로 다양한 레벨에 네스팅된 많은 컴포넌트에게 데이터를 전달하는 것이 목표

### 전역 상태 라이브러리와의 차이점?

- 앱이 작고 상태가 많이 않을 때
- 별도 라이브러리 설치 없이 간편하게 시작하고 싶을 때
- 간단한 테마, 로그인 상태, 언어 설정 등 자주 바뀌지 않는 상태 관리할 때 유용
- 상태가 변경될 때 Provider 하위 전체 리렌더링 발생
- Provider, Context 생성 필요
- useContext hook을 통해 하위 컴포넌트에서 Context에 접근 가능

### Context 객체 생성

```javascript
// src/app/components/myContext.js
import { createContext } from "react"

export const MyContext = createContext({
    value: 'hi',
    counter: 2,
    theme: "light",
    setValue: () => {},
    setCounter: () => {},
    setTheme: () => {}
})
```

### Provider, Child 컴포넌트 생성

```javascript
// src/app/page.jsx
'use client'

import React, { useState } from 'react'
import { MyContext } from './components/myContext'
import Child from './Child'

const Page = () => {

  const [value, setValue] = useState('hello')
  const [counter, setCounter] = useState(1)
  const [theme, setTheme] = useState('dark')
  
  return (
    <MyContext.Provider 
      value={{
        value,
        setValue,
        counter,
        setCounter,
        theme,
        setTheme
        }}>
        <Child />
    </MyContext.Provider>
  )
}

export default Page

// src/app/child.jsx
'use client'

import React, { useContext } from 'react'
import { MyContext } from '@/myContext'

const page = () => {
  
  const { value, setValue, counter, setCounter, theme, setTheme } = useContext(MyContext)

  return (
    <div>
        <div>value: {value}</div>
        <div>counter: {counter} </div>
    </div>
  )
}

export default page
```
<br />

> why? Provider value의 state 값과 createContext 값이 다를까?

맞춰주는것이 일반적이지만 createContext 값은 Provider로 감싸기 전에만 쓰이는 임시 기본값이고 실제로 사용되는 값은 useState 값 입니다.

<br />

### Context 객체를 여러개 만들고 싶다면?

Provider를 중첩해서 사용 가능합니다.

```javascript
import React, { useState } from 'react'
import { MyContext } from './components/myContext'
import Child from './Child'
import { createContext } from "react"

const Page = () => {

  const ThemeContext = createContext('')
  const ValueContext = createContext('')

  return (
    <ThemeContext.Provider value="dark">
        <ValueContext.Provider value="value">
            <Child />
        </ValueContext.Provider>
    </ThemeContext.Provider>
  )
}

export default Page
```

[출처] https://ko.legacy.reactjs.org/docs/context.html