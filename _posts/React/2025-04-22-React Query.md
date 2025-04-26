## TanStack Query

### 도입 배경

프로젝트에서 서버의 상태 관리보다는 서버와 연결하는 코드를 어떻게하면 깔끔하게 작성할 수 있을까 라는 고민 끝에 React Query를 도입하게 되었습니다. 기존에는 매번 axios 요청 후 로딩 상태, 에러 처리, 재요청 등의 로직을 직접 구현해야 했지만 React Query를 사용함으로써 반복적인 로직을 간단하게 줄일 수 있게 되었습니다.

### 주로 사용한 hook

- useQuery
- useQueries
- useMutation
- 무한 스크롤 구현에서 사용한 useInfiniteQuery

### 알아야할 cache, stale, fresh 동작

#### cache
- React Query에서 설정한 cacheTime만큼 데이터를 React Query 내부 메모리에 저장하여 동일한 요청을 다시 할 필요 없게 만드며 queryKey 단위로 캐시한다.

```javascript
useQuery({
  queryKey: ['user', id],
  queryFn: () => axios.get(`/api/user/${id}`),
})
```

#### stale
- staleTime이 지나 자동으로 "오래된 데이터"로 판단한 상태

#### fresh
- staleTime 내에 있거나 방금 불러온 데이터 상태

### 실제 동작 과정
1. 처음 useQuery 실행 -> 서버에서 fetch하여 캐시에 저장 -> fresh한 상태
2. staleTime이 지나면 stale 상태로 바뀜
3. 사용자가 화면 이동 후 다시 돌아올 경우 stale 상태라면 다시 서버에 재요청
4. 컴포넌트 unmount -> 캐시 유지됨

### 추가 옵션
- refetchOnMount: 마운트될 때 stale이면 자동 재요청 (기본값: true)
- enabled: 조건이 만족할 때만 쿼리 실행, 특정 조건을 만족하지 않을 경우 쿼리를 실행시키지않는 즉, 네트워크 요청을 막겠다는 의미입니다.
``` javascript
const { data: user } = useQuery({
  queryKey: ['user', email],
  queryFn: getUserByEmail,
})

const userId = user?.id

const { status, fetchStatus, data: projects } = useQuery({
  queryKey: ['projects', userId],
  queryFn: getProjectsByUser,
  // userId가 존재하면 쿼리가 실행
  enabled: !!userId,
})

// 쿼리 비활성화
// 버튼 클릭에만 데이터를 fetch 하고 싶을 때, 모달이 열릴 때만 데이터를 불러오고 싶을 때 유용
enabled: false
```
- select: 응답 데이터를 가공하여 원하는 형태로 반환
```javascript
export const useSelectTestQuery = () => {
    const queryOptions = {
        queryKey: TEST_QUERY_KEY.test,
        queryFn: async () => {
            const { data } = await getTest();
            return data;
        },
        select: (data) => {
            return data[0]
        }
    };

    return useQuery(queryOptions);
};
```
- retry: 요청 실패시 재시도 횟수 (기본값: 3)
- retryOnMount: 컴포넌트가 마운트될 때 이전에 실패한 쿼리를 다시 시도할지 여부
- retryDelay: 재시도 간의 지연시간 또는 함수로 설정 가능
- gcTime: 데이터가 언마운트된 후 캐시에 얼마나 오래 유지될지 (기본값: 5분)
- refetchInterval: 주기적으로 데이터를 refetch하는 인터벌
- refetchIntervalBackground: 창이 백그라운드 상태일 때도 refetchInterval을 작동할지 여부 (기본값: false)
- refetchOnWindowFocus: 창에 다시 포커스될 때 stale 상태면 재요청 (기본값: true)
```javascript
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false
    }
  }
})

function App() {
  return <QueryClientProvider client={queryClient}>...</QueryClientProvider>
}

useQuery({
  queryKey: ['todos'],
  queryFn: fetchTodos,
  refetchOnWindowFocus: false,
})
```
- Query Invalidation: 쿼리를 stale 상태로 표시하여 useQuery를 백그라운드에서 refetch 실행
```javascript
queryClient.invalidateQueries({
  queryKey: ['todos', { type: 'done' }],
})

const todoListQuery = useQuery({
  queryKey: ['todos', { type: 'done' }],
  queryFn: fetchTodoList,
})
```
> Why? refetch와의 차이점은?

refetch는 즉시 쿼리를 다시 가져오고 useQuery가 선언되어있는 컴포넌트 안에서 실행되지만 invalidation은 stale 상태로 만들어 백그라운드에서 새로고침되게 하며 전역 어디서든 사용가능하다는 차이점이 있습니다.

- initialData: 첫 요청 전에 보여줄 초기 데이터 (캐시로 저장됨)
```javascript
const useNextJSQuery = () => {
    const queryOptions = {
        queryKey: TEST_QUERY_KEY.nextjs,
        queryFn: async () => {
            const { data } = await getNextJS();
            return data;
        },
        enabled: false,
        initialData: {
            id: "taehoon",
            pwd: 1234
        }
    };
}
const { data } = useNextJSQuery()
console.log(data.id) // taehoon
```
- setQueryData: 쿼리 캐시에 저장된 데이터를 직접 수정함으로써 서버 요청없이 클라이언트 상태를 업데이트
```javascript
const queryClient = useQueryClient()

const mutation = useMutation({
  mutationFn: editTodo,
  onSuccess: (data) => {
    queryClient.setQueryData(['todo', { id: 5 }], data)
  },
})
```
- placeholderData: 로딩 상태일 때 UI를 위한 임시 데이터 (캐시에 저장되지 않음)로 새로운 데이터가 올 때 까지 이전 데이터가 보여짐
```javascript
const { data, isFetching, isPlaceholderData } = useQuery({
  queryKey: ['products', page],
  queryFn: () => fetchProducts(page),
  // 해당 설정을 통해 이전 데이터를 유지하면서 데이터 전환 가능
  // keepPreviousData 또한 placeholderData와 똑같이 동작하지만 의도를 명확하게 표현할 수 있어서 일반적으로 함께 쓰임
  placeholderData: (previousData: any) => previousData,
  keepPreviousData: true,
})

return (
  <>
    <ProductList data={data} />
    {isFetching && !isPlaceholderData && <Spinner />}
  </>
)
```
- suspense: 비동기 작업이 끝날 때까지 기다리게 하고, 그동안 보여줄 UI(로딩화면)를 지정
```javascript
const { data } = useQuery({
  queryKey: ['user'],
  queryFn: fetchUser,
  suspense: true,
});

export default function Page() {
  return (
    <Suspense fallback={<div>suspense ui</div>}>
      <Component />
    </Suspense>
  );
}
```