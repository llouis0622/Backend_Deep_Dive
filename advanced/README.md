## 1. 예제 만들기

### 1. 로그 추적기 - 요구사항 분석
- 모든 PUBLIC 메서드의 호출과 응답 정보 로그 출력
- 애플리케이션 흐름 미변겅
- 메서드 호출 걸린 시간
- 정상 흐름과 예외 흐름 구분
- 메서드 호출 깊이 표현
- HTTP 요청 구분

### 2. 로그 추적기
- HTTP 요청 구분 및 깊이 표현 -> TraceId 동기화 필요
- TraceId 동기화 -> 관련 메서드의 모든 파라미터 수정
- 로그 처음 시작 시 begin() 호출, 처음이 아닐때 beginSync() 호출

## 2. 쓰레드 로컬 - ThreadLocal

### 1. 필드 동기화 - 동시성 문제
- 동시성 문제 : 여러 쓰레드가 동시에 같은 인스턴스의 필드 값을 변경하면서 발생하는 문제
- 트래픽 증가 -> 동시성 문제 증가

### 2. ThreadLocal
- 쓰레드 로컬 : 해당 쓰레드만 접근할 수 있는 특별한 저장소
- 쓰레드 로컬 사용 후 미제거 -> WAS처럼 쓰레드 풀 사용 시 심각한 문제 발생
