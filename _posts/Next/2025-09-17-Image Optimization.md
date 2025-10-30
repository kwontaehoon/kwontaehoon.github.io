---
layout : archive
title : 이미지 최적화
categories : Next
date : 2025-09-17
---

## 이미지 최적화

이미지 최적화: 이미지 최적화는 LCP (Largest Contentful Paint)를 개선하는 데 가장 중요한 요소 중 하나로 이미지 최적화를 통해 웹 성능을 향상시킬 수 있습니다.

### LCP (Largest Contentful Paint)

사용자가 페이지를 방문했을 때 가장 큰 콘텐츠가 완전히 화면에 표시되기까지 걸리는 시간을 측정하는 구글의 핵심 웹 바이탈


### 이미지 최적화 - 성능 최적화 방법

- 파일 압축 (고화질, 저화질 등)
- 이미지 포맷 변경 (WebP, AVIF 등)
- Nextjs의 이미지 최적화
    - Image 컴포넌트의 props 사용
    - width / height / fill / sizes
    - quality
    - priority (lazy / eager)
        - lazy: 페이지가 로드될 때, 당장 필요한 데이터만 먼저 가져오고, 나머지는 사용자가 실제로 해당 데이터에 접근할 때 가져오는 방식 (Defalut)
        - eager: 페이지가 로드될 때, 필요한 모든 데이터를 미리 한 번에 가져오는 방식


### 현재 Next.js 프로젝트에서 적용해본 이미지 최적화 방법
진행된 프로젝트명: "TripAI"

기존 파일
<br />
<img src="../../assets/image/원본 이미지.PNG" />

1. 파일 압축
<br />
<img src="../../assets/image/압축한 이미지.PNG" />

2. 이미지 포맷 변경: PNG -> WebP
<br />
<img src="../../assets/image/포맷 이미지.PNG" />

3. 압축한 파일에서 포맷 변경: 압축 -> PNG -> WebP
<br />
<img src="../../assets/image/압축 후 포맷한 이미지.PNG" />

4. Nextjs의 이미지 최적화

<img src="../../assets/image/이미지 최적화 전.PNG" />
<br />
Image 컴포넌트 최적화 전

<br />

<img src="../../assets/image/이미지 최적화 후.PNG" />
<br />
Image 컴포넌트 최적화 후

<br />

### Nextjs의 Image 컴포넌트 최적화 적용 후 알 수 있었던 사실

- Vercel에 배포하면 Next.js가 자동으로 PNG나 JPG 같은 이미지 형식을 WebP로 변환하여 최적화해줍니다. 
- quality 옵션을 사용해 이미지 품질을 낮출 수 있으며, 이를 통해 파일 크기를 줄여 성능을 높일 수 있었습니다. 특히 이미지가 주요 콘텐츠가 아닌 목록 페이지에 이 옵션을 적용했습니다.
- Image 컴포넌트는 기본적으로 지연 로딩(lazy loading) 방식을 사용하지만, **priority={true}**를 설정하여 선점 로딩(eager loading) 방식으로 변경할 수 있었습니다. 덕분에 페이지의 첫 화면에 보이는 주요 이미지들의 초기 로딩 시간을 효과적으로 줄일 수 있었습니다.
- **priority={true}**를 설정하면 다른 이미지보다 먼저 다운로드가 시작됩니다.
- fill 속성을 사용할 때는 sizes 속성을 함께 사용하는 것이 좋습니다. sizes는 화면 크기에 따라 이미지가 차지할 공간을 알려주는 역할을 하며, 이를 통해 브라우저가 사용자 환경에 가장 적합한 크기의 이미지를 받아볼 수 있도록 도와줍니다.


<br />

[출처] https://nextjs.org/docs