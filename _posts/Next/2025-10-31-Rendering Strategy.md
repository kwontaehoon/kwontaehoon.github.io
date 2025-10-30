---
layout : archive
title : 렌더링 / 캐싱 전략
categories : Next
date : 2025-10-31
---
## 기술 스택

Next.js v16 (App router) + Tanstack Query

## 렌더링 전략

### SSR

Next.js의 SSR을 이용했습니다. SSR은 Server Side Rendering으로, 서버에서 데이터 패치와 렌더링이 이루어집니다. 서버에서 데이터가 추가된 다시말해 완성된 HTML이 브라우저로 전송됩니다. 브라우저는 완성된 HTML을 받아서 즉시 파싱을 하여 레이아웃 과정을 실행합니다. 서버에서 완성된 HTML을 만들기 때문에 SEO에 유리하고 javascript를 다운로드하고 실행하기 전에 HTML을 보여줄 수 있어서 초기 렌더링 과정이 빠릅니다.

### Next.js의 자동 SSR 변환

Next.js App Router에서는 page 파일에 'use client' 지시어를 명시하면 해당 컴포넌트는 클라이언트 컴포넌트로 처리됩니다. 하지만 Next.js 서버는 이 파일의 정적인 뼈대와 필수 JavaScript를 포함한 초기 HTML 문서를 여전히 서버에서 만들어 보냅니다. 이는 클라이언트 컴포넌트도 서버에서 렌더링되는 정적인 부분이 있음을 의미하며, 이 과정 덕분에 초기 로딩의 이점을 일부 가져갈 수 있습니다.

### Loading.(js/ts)

SSR 과정에서도 서버에서 데이터 페치가 지연될 경우 로딩 시간이 발생합니다. Next.js는 자동으로 해당 라우트 폴더의 loading.js 파일을 감지하고, 데이터 로딩이 완료될 때까지 이 로딩 컴포넌트의 HTML을 사용자에게 스트리밍하여 보여줍니다. 예를들어 client component에서 사용할 수 있는 tanstack query의 isLoading 역할을 수행할 수 있습니다.

### SSR + Suspense

Next.js는 부분 렌더링을 지원합니다. 이는 느린 데이터 로딩을 포함하는 컴포넌트를 Suspense로 감싸서, 나머지 정적인 페이지 구조를 먼저 클라이언트에 전송하는 방식입니다. 동적 요소의 로딩 상태는 클라이언트 컴포넌트에서 TanStack Query의 isLoading을 사용하거나, Suspense를 활용하여 fallback UI로 관리할 수 있습니다.

```javascript
import { Suspense } from 'react'
 
export default function Page() {
  return (
    <>
      <h1>...</h1>
      <Suspense fallback={<Skeleton />}>
        <DynamicContent />
      </Suspense>
    </>
  )
}
 
async function DynamicContent() {
  const res = await fetch('http://api.cms.com/posts')
  const { posts } = await res.json()
  return <div>{/* ... */}</div>
}
```

### 동적 함수를 사용하면 강제 SSR 변환

동적 함수는 cookie(), header() 등 사용자에 따라 변하는 동적 데이터를 포함한 함수입니다. 초기 렌더링의 빠른 속도를 위해서 ISR을 적용하려고했으나 header page의 로그인 UI에 필요한 session 값 때문에 ISR이 강제 SSR로 변환되었습니다. 결국 header page의 로그인 UI에 로딩 UI를 만들었고 SSR로 강제 변환되는 session 요소를 제거하여 ISR을 적용했습니다.


## 캐싱 전략

### 서버 캐시와 브라우저 캐시

서버의 캐시는 fetch 함수의 header 옵션으로 설정이 가능합니다. axios를 사용할 땐 react의 cache object로 관리가 가능하지만 Next.js에서는 fetch 함수를 선호합니다. client component에서 데이터 패칭을 tanstack query로 하기 때문에 서버에서 데이터를 불러오면 tanstack query 캐시에 저장하는 작업이 필요합니다. 따라서 fetch로 불러온 데이터를 tanstack query의 setQueryData 키워드를 통해 tanstack query 캐시에 저장하여 client component에서 서버에서의 재호출이 발생하지않게 사용했습니다.

### prefetch

prefetch도 마찬가지로 초기 server component에서 데이터를 fetch 함수로 불러온 후, 이후에 자주 이동하게될 페이지에서 동일한 데이터로 tanstack query를 사용한다면 tanstack query의 setQueryData 키워드를 통해 캐시에 미리 저장하여 서버의 재호출이 발생하지 않게 사용했습니다. 만약 초기 server component에서 사용하지않는 데이터는 prefetch 키워드를 통해 서버에 새로 데이터를 불러옵니다.

<br />

[출처] https://nextjs.org/docs