#### @layer
- 사용자 정의 CSS 규칙을 추가해야하는 경우 가장 쉬운 방법으로 스타일시트에 사용자 정의 CSS를 추가하는 것으로 이 선언을 사용하여 base/components/utilites를 사용할 수 있다.

#### base
- HTML 기본 태그의 전역 스타일 사용자 정의
- 우선순위 가장 낮음

```typescript
@layer base {
  h1 {
    font-size: theme('fontSize.4xl');
    font-weight: theme('fontWeight.bold');
    color: theme('colors.gray.800');
  }
  p {
    line-height: theme('lineHeight.relaxed');
    margin-bottom: theme('spacing.4');
  }
}
```

#### component
- 커스텀 UI 컴포넌트 스타일 사용자 정의
- 우선순위 중간

```typescript
@layer components {
  .card {
    @apply bg-white shadow-lg rounded-lg p-6;
  }
  .btn-primary {
    @apply bg-blue-500 text-white px-4 py-2 rounded;
    &:hover {
      background-color: theme('colors.blue.600');
    }
  }
}
```

#### utilitles
- Tailwind 유틸리티 함수와 매칭하여 확장 및 사용자 정의
- 우선순위 가장 높음

```typescript
@layer utilities {
  .text-shadow {
    text-shadow: 2px 2px theme('colors.gray.500');
  }
  .hover-scale:hover {
    transform: scale(1.1);
  }
  .rounded-xl {
    border-radius: theme('borderRadius.xl');
  }
}
```


#### theme 함수
- tailwind.config.ts 에서 커스텀한 theme을 그대로 사용하기 위해 theme 함수 사용

```typescript
/* 직접 값을 입력한 경우 */
.card {
  background-color: #ffffff; /* 직접 입력 */
  border-radius: 0.5rem;
  padding: 1.5rem;
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
}

/* Tailwind 설정값을 사용하는 경우 */
.card {
  background-color: theme('colors.white'); /* 설정값 참조 */
  border-radius: theme('borderRadius.lg');
  padding: theme('spacing.6');
  box-shadow: theme('boxShadow.xl');
}

```

