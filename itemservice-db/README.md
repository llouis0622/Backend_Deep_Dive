## 1. 데이터 접근 기술 - 시작

### 1. 데이터 접근 기술 진행 방식 소개
- SQLMapper
  - JdbcTemplate
  - MyBatis
- ORM 관련 기술
  - JPA, Hibernate
  - 스프링 데이터 JPA
  - Querydsl

### 2. 데이터베이스 테이블 생성
- 데이터베이스 기본 키 조건
  - null값 미허용
  - 유일성 만족
  - 불변 만족
- 테이블의 기본 키 선택
  - 자연 키(Natural Key) : 비즈니스에 의미가 있는 키
  - 대리 키(Surrogate Key) : 비즈니스와 관련 없는 임의로 만들어진 키, 대체 키

## 2. 데이터 접근 기술 - 스프링 JdbcTemplate

### 1. JdbcTemplate 소개와 설정
- 설정의 편리함 : 스프링으로 JDBC를 사용할 때 기본으로 사용하는 템플릿 활용 가능
- 반복 문제 해결
  - 템플릿 콜백 패턴 -> 반복 작업 처리
  - SQL 작성 -> 전달할 파라미터 정의, 응답 값 매핑
  - 커넥션 획득
  - statement 준비 및 실행
  - 결과 반복 루프 실행
  - 커넥션 종료, statement, resultset 종료
  - 트랜잭션 커넥션 동기화
  - 예외 발생 시 스프링 예외 변환기 실행
- 동적 SQL 해결 어려움

### 2. JdbcTemplate - 이름 지정 파라미터 1
- 기본 사용 시 파라미터 순서대로 바인딩
- `NamedParameterJdbcTemplate` : 이름 지정 파라미터 바인딩 가능
  - key : value 데이터 구조로 전달
  - key : 파라미터 이름
  - value : 파라미터 값
  - Map 사용 : 단순 Map 사용
  - MapSqlParameterSource 사용 : SQL에 좀 더 특화된 기능 제공
  - BeanPropertySqlParameterSource 사용 : 자바빈 프로퍼티 규약 -> 자동으로 파라미터 객체 생성

### 3. JdbcTemplate - SimpleJdbcInsert
- 직접 SQL을 작성하지 않아도 됨

### 4. JdbcTemplate 기능 정리
- JdbcTemplate : 순서 기반 파라미터 바인딩 지원
- NamedParameterJdbcTemplate : 이름 기반 파라미터 바인딩 지원, 권장
- SimpleJdbcInsert : INSERT SQL 편리하게 사용 가능
- SimpleJdbcCall : 스토어드 프로시저 편리하게 호출 가능

